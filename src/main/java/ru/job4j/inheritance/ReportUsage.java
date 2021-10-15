package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        HtmlReport report = new HtmlReport();
        text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        JSONReport jsonReport = new JSONReport();
        text = jsonReport.generate("name", "body");
        System.out.println(text);
    }
}
