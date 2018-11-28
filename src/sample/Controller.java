package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Controller {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    //обьявление обьектов формы
    @FXML
    private AnchorPane main_frame;
    @FXML
    private TextField fieldFuncPane1;
    @FXML
    private TextField fieldCountPane1;
    @FXML
    private LineChart<Number, Number> myChart;
    @FXML
    private TextField fieldDownloadWay;
    @FXML
    private Button downloadButtClick;
    @FXML
    private TextArea outputArea;
//Методы событий на форме
    @FXML
    private void clickDb(){

        //connectDb("jdbc:mysql://31.31.196.177:3306/web_windigo_db","u0450775_Boris11","nsrmgrb1173211");
    }
    @FXML
    private void clickStartPane1()
    {
        ArrayCreator my_array = new ArrayCreator(Integer.parseInt(fieldCountPane1.getText()));
        my_array.generatingArray();

        XYChart.Series<Number,Number> seriesApril= new <Integer,Integer>XYChart.Series();
        seriesApril.setName("SQR");
        System.out.print(my_array.toString());
        for (int i = 0; i< my_array.getLength_arr(); i++) {
            seriesApril.getData().add(new XYChart.Data(i,i*i));
        }
        myChart.getData().add(seriesApril);

        //https://netbeans.org/kb/docs/web/mysql-webapp_ru.html#planStructure
        System.out.println(fieldFuncPane1.getText());
    }
    @FXML
            private void clickDownloadFile()
    {
        outputArea.appendText("WTF THIS SHIT");
    }


// Методы которые вызываются внутри событий
    void connectDb (String url, String user, String password) {

        String query = "select distinct id from tb_users";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

}
