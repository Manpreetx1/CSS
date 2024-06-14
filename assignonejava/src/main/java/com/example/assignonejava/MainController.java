package com.example.assignonejava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainController {
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private TableView<FlightData> tableView;
    @FXML
    private TableColumn<FlightData, String> reviewColumn;
    @FXML
    private TableColumn<FlightData, Integer> delayColumn;
    @FXML
    private TableColumn<FlightData, Double> priceColumn;
    @FXML
    private TableColumn<FlightData, Integer> comfortColumn;
    @FXML
    private TableColumn<FlightData, Integer> complaintsColumn;

    private ObservableList<FlightData> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        reviewColumn.setCellValueFactory(new PropertyValueFactory<>("review"));
        delayColumn.setCellValueFactory(new PropertyValueFactory<>("delay"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        comfortColumn.setCellValueFactory(new PropertyValueFactory<>("comfort"));
        complaintsColumn.setCellValueFactory(new PropertyValueFactory<>("complaints"));
    }

    @FXML
    public void loadData(ActionEvent event) {
        dataList.clear();
        barChart.getData().clear();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://database-1.cvqq62oao35d.us-east-1.rds.amazonaws.com:3306/flight_data", "admin1", "Man-030728");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM flights")) {

            while (resultSet.next()) {
                String review = resultSet.getString("review");
                int delay = resultSet.getInt("delay");
                double price = resultSet.getDouble("price");
                int comfort = resultSet.getInt("comfort");
                int complaints = resultSet.getInt("complaints");

                FlightData data = new FlightData(review, delay, price, comfort, complaints);
                dataList.add(data);

                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.getData().add(new XYChart.Data<>("Delay", delay));
                series.getData().add(new XYChart.Data<>("Price", price));
                series.getData().add(new XYChart.Data<>("Comfort", comfort));
                series.getData().add(new XYChart.Data<>("Complaints", complaints));
                barChart.getData().add(series);
            }
            tableView.setItems(dataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
