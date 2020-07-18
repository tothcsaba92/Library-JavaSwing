package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ImportDataBase {
    private Connection conn = null;

    public void makeConnectionWithDatabase(String url) {
        try {
            conn = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("books.csv"));
        while (sc.hasNextLine()){
            try {
                PreparedStatement ps =  conn.prepareStatement("");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
