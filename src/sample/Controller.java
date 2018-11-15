package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Controller {
    @FXML
    private Button sqrCreate;
    @FXML
    private Button cubCreate;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    @FXML
    NumberAxis xAxis;

    @FXML
    NumberAxis yAxis;

    @FXML
    private LineChart<Number, Number> myChart;

    @FXML
    private void click() {
        buildChart();
    }
    @FXML
    private void clickDb(){
        connectDb("jdbc:mysql://31.31.196.177:3306","u0450775_Boris11","nsrmgrb1173211");
    }
/*Params.Strings = (
      'Database=u0450775_club'
      'User_Name=u0450775_Boris11'
      'Password=nsrmgrb1173211'
      'Server=31.31.196.177'
      'DriverID=MySQL')

private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";
 */


    void connectDb (String url, String user, String password)
    {

        String query = "select count(*) from users";

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
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }



    void buildChart()
    {
        Integer [] arr = new Integer[10];
        Integer [] arrFunc = new Integer [10];
        for(int i = 0; i<arr.length;i++)
        {
            arr[i]=i;
            arrFunc[i] = i * i ;
        }

        XYChart.Series<Number,Number> seriesApril= new <Integer,Integer>XYChart.Series();
        seriesApril.setName("SQR");

        for (int i = 0; i< arr.length; i++)
        {
            seriesApril.getData().add(new XYChart.Data(i, arrFunc[i]));
        }
        myChart.getData().add(seriesApril);
    }



}
