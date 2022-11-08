package fr.cda.disquesvyniles.util.scrol;

import fr.cda.disquesvyniles.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class LeBonCoin {
    public static String ScrapLeboncoin(String searchTitle, String searchPriceMin, String searchPriceMax) {
        String url = "https://leboncoin.fr/recherche?category=26&text=" + searchTitle + "&price=" + searchPriceMin + "-" + searchPriceMax;
        String res = "";
        try {
            WebClient webClient = new WebClient();

            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage htmlPage = webClient.getPage(url);

            List<HtmlElement> li = htmlPage.getByXPath("//a/div[2]/div[2]/div[1]/p");
//            System.out.println("li = " + li);

            for (HtmlElement e : li) {
                HtmlPage htmlPage1 = webClient.getPage(e.click().getUrl());
                String nomArticle = "";
                String prixArticle = "";
                String description = "";

                List<HtmlElement> nom = htmlPage1.getByXPath("//div[@class='sc-bdVaJa cYMESN']/h1[@data-qa-id='adview_title']");
                List<HtmlElement> prix = htmlPage1.getByXPath("//span[@class='Roh2X _3gP8T _35DXM _25LNb']");
                List<HtmlElement> desc = htmlPage1.getByXPath("//div[5]/div/div/p");

                for (HtmlElement n : nom) {
                    nomArticle = n.getTextContent();
//                    System.out.println("Nom = " + nomArticle);

                }
                for (HtmlElement p : prix)
                    prixArticle = p.getTextContent();
                    prixArticle = prixArticle.replace("\u00a0", "");
//                    System.out.println("prixArticle = " + prixArticle);

                for (HtmlElement d : desc) {
                    description = d.getTextContent();
//                    System.out.println("description = " + description);
                }
                res += "Article : " + nomArticle +
                        "\n Prix : " + prixArticle +
                        "\n Description de l'article : " + description +
                        "\n lien : " + htmlPage1.getUrl() +
                        "\n--------------------------------------------------------------------\n";
//                System.out.println(res);
//                System.out.println(searchTitle + " "+searchPriceMax+" "+searchPriceMin + "\n"+res);
            }
//            System.out.println(searchTitle + " "+searchPriceMax+" "+searchPriceMin + "\n"+res);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


}
