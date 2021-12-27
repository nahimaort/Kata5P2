package kata5.view;

import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MailListReaderBD {
    
    public List<Mail> read() {
        List<Mail> mailList = new ArrayList<Mail>();
        Connection connection = null;
        String url = "jdbc:sqlite:mail.db";
        String select = "SELECT * FROM EMAIL";
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(select);
            
            while (rs.next()) {
                String line = rs.getString("Mail");
                if (Mail.isMail(line));
                    mailList.add(new Mail(line));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailList;
    }
}
