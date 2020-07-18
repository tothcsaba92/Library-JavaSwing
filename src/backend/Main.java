package backend;

public class Main {

    public static void main(String[] args) {
        BookDB dbc = new BookDB();
        dbc.makeConnectionWithDatabase();
        Ui ui = new Ui(dbc);
        ui.welcomeMessage();
       // ImportDataBase idb = new ImportDataBase();
        //idb.makeConnectionWithDatabase("jdbc:mysql://localhost/library?serverTimezone=UTC");

        //ui.mainMenu();
        //ui.deleteBook();
        ui.mostPopularBook();
        //ui.mainMenu();
        //ui.deleteBook();
        ui.nrOfBorrows();

    }

}
