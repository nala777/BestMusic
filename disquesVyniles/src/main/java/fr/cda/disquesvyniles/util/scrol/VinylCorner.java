package fr.cda.disquesvyniles.util.scrol;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import fr.cda.disquesvyniles.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class VinylCorner {
    public static String scrapCultureFactory(String searchTitle, String searchPriceMin, String searchPriceMax, String genre) {
        String res = "";
        switch (genre) {
            case "Rock":
                genre = "5";
                break;
            case "Blues":
                genre = "11";
                break;
            case "Jazz":
                genre = "11";
                break;
            case "Reggae":
                genre = "10";
                break;
            case "Funk":
                genre = "5";
                break;
            case "Electro":
                genre = "7";
                break;
            case "Tous les styles":
                genre = "3";
                break;
            case "Soul":
                genre = "5";
                break;

        }
        String url = "https://www.vinylcorner.fr/catalogsearch/result/?q=" + searchTitle + "&category=" + genre;
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
            Double prixF = 0.0;


            List<HtmlElement> li = htmlPage.getByXPath("//div/div[1]/a/span/span/img");

            for (HtmlElement e : li) {


                HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
                List<HtmlElement> nomArtistes = htmlPage1.getByXPath("//div[2]/div/div/div[1]/div[1]/p[2]");
                List<HtmlElement> prix = htmlPage1.getByXPath("//div[4]/div/span/span/span");
                List<HtmlElement> titre = htmlPage1.getByXPath("div[2]/div/div/div[2]/div/p[2]");
                List<HtmlElement> description = htmlPage1.getByXPath("//div/div/div/div[6]/span");

                for (HtmlElement na : nomArtistes) {
                    ValueNA = na.getTextContent();
                    System.out.println("nom artiste:" + ValueNA);
                }

                for (HtmlElement ti : titre) {
                    ValueNA = ti.getTextContent();
                    System.out.println("titre:" + ti);
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
                            "\n Prix : " + prixF + " €"+
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
