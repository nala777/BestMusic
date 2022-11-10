package fr.cda.disquesvyniles.util.scrol;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import fr.cda.disquesvyniles.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The type Culture factory.
 */
public class CultureFactory {
    /**
     * Scrap culture factory  and return a string with the result.
     *
     * @param searchTitle    the search title
     * @param searchPriceMin the search price min
     * @param searchPriceMax the search price max
     * @return the string
     */
    public static String scrapCultureFactory(String searchTitle, String searchPriceMin, String searchPriceMax) {
        String res = "";
        String url = "https://culturefactory.fr/recherche?controller=search&s=" + searchTitle;
        try {
            WebClient webClient = new WebClient();

            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage htmlPage = webClient.getPage(url);

            String ValueNA = "";
            String ValuePrix = "";
            String ValueDesc = "";
            String ValueNAlbum = "";
            double prixF = 0.0;


            List<HtmlElement> li = htmlPage.getByXPath("//h4/a[@href]");

            for (HtmlElement e : li) {


                HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
                List<HtmlElement> nomArtistes = htmlPage1.getByXPath("//h1[@class='h1 namne_details']");
                List<HtmlElement> prix = htmlPage1.getByXPath("//html/body/main/div[1]/div[2]/div/div/section/div[1]/div[2]/div[1]/div[1]/div/span");
                List<HtmlElement> description = htmlPage1.getByXPath("//div[@class='product-desc']");

                for (HtmlElement na : nomArtistes) {
                    ValueNA = na.getTextContent();
                    System.out.println("nom artiste:" + ValueNA);

                }

                for (HtmlElement desc : description) {
                    ValueDesc = desc.getTextContent();
                    System.out.println("description" + ValueDesc);
                }

                for (HtmlElement px : prix) {
                    ValuePrix = px.getTextContent();
                    ValuePrix = ValuePrix.replace(',', '.').replaceAll("[^0-9.]", "").trim();
                    prixF = Double.parseDouble(ValuePrix);
                    System.out.println("prix: " + ValuePrix);
                }

                if (prixF <= Double.parseDouble(searchPriceMax) && prixF >= Double.parseDouble(searchPriceMin)) {

                    res += "Article : " + ValueNAlbum +
                            "\n Artiste/Album : " + ValueNA +
                            "\n Prix : " + ValuePrix +
                            "\n Description de l'article : " + ValueDesc +
                            "\n lien : " + htmlPage1.getUrl() +
                            "\n--------------------------------------------------------------------\n";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
