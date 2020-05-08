import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JobSearchScrape {
    public static void main(String[] args) throws IOException {

        final String urlJobSearch =
                "https://www.jobsearch.az/";
        try {
            final Document doc = Jsoup.connect(urlJobSearch).timeout(6000).get();
//            for(Element row : doc.select("td.hotv_text")) {
            for(Element row : doc.select("tr")) {
                if (row.text().toLowerCase().contains("software") || row.text().toLowerCase().contains("back") || row.text().toLowerCase().contains("end")) {
                    String s = row.select("td.hotv_text").text();
//                    System.out.println(row.text());
                    System.out.println(s);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
