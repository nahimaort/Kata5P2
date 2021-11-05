package kata4.main;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    public static List<Mail> input() {
        String nameFile = "email.txt";
        List<Mail> mailList = MailListReader.read(nameFile);
        return mailList;
    }
    
    public static Histogram<String> process(List<Mail> mailList) {
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        return histogram;
    }
    
    public static void output(Histogram<String> histogram) {
        HistogramDisplay histogramDisplay = new HistogramDisplay("HistogramDisplay", histogram);
        histogramDisplay.execute();
    }
    
    public static void execute() {
        List<Mail> mailList = input();
        Histogram<String> histogram = process(mailList);
        output(histogram);
    }
    
    public static void main(String[] args) {
        Kata4.execute();
    }
}
