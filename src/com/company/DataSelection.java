package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataSelection {

    public static Element selectData(Document document) {
        Element latestYearPlayedRow;

        Element dataTable = document.select("table[border = 0]").first();
        latestYearPlayedRow = dataTable.select("tr").last().previousElementSibling();

        while (latestYearPlayedRow.text().contains("NHL totals") || !latestYearPlayedRow.text().contains("NHL")) {
            latestYearPlayedRow = latestYearPlayedRow.previousElementSibling();
        }
        return latestYearPlayedRow;
    }
}
