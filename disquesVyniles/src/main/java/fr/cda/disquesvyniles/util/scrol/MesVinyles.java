package fr.cda.disquesvyniles.util.scrol;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class MesVinyles {
    public static String scrapMesVinyles(String searchTitle, String searchPriceMin, String searchPriceMax, String year) {
        String res = "";

        String url = "https://mesvinyles.fr/fr/recherche?controller=search&s=" + searchTitle;
        try {
            WebClient webClient = new WebClient();

            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage htmlPage = webClient.getPage(url);

            String ValueTi = "";
            String ValuePrix = "";
            String ValueAnn = "";
            String ValueNAlbum = "";
            Double prixF = 0.0;


            List<HtmlElement> li = htmlPage.getByXPath("//ul/li/div/div[1]/a/img");

            for (HtmlElement e : li) {


                HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
                List<HtmlElement> titre = htmlPage1.getByXPath("//div/div/section/div[1]/div[2]/h1");
                List<HtmlElement> prix = htmlPage1.getByXPath("//div[2]/form/div[2]/div[1]/div/span");
                System.out.println("prix = " + prix);
                List<HtmlElement> annee = htmlPage1.getByXPath("//section/div/div/div[2]/section[1]/dl/dd[5]");

                for (HtmlElement ti : titre) {
                    ValueTi = ti.getTextContent();
                    System.out.println("Titre:" + ValueTi);
                }

                for (HtmlElement px : prix) {
                    ValuePrix = px.getTextContent();
                    ValuePrix = ValuePrix.replace(',', '.').replaceAll("[^0-9.]", "").trim();
                    prixF = Double.parseDouble(ValuePrix);
                    System.out.println("Prix: " + ValuePrix);
                }

                for (HtmlElement ann : annee) {
                    ValueAnn = ann.getTextContent();
                    System.out.println("Annee: " + ValueAnn);
                }

                if (prixF <= Double.parseDouble(searchPriceMax) && prixF >= Double.parseDouble(searchPriceMin) && year == ValueAnn) {

                    res += "Article : " + ValueNAlbum +
                            "\n Artiste/Album : " + ValueTi +
                            "\n Prix : " + prixF + " €"+
                            "\n Annee : " + ValueAnn + " €"+
                            "\n Lien : " + htmlPage1.getUrl() +
                            "\n--------------------------------------------------------------------\n";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
