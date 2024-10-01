package com.fpdone.reservametaquest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerReservasController implements Initializable {

    @FXML
    private TableColumn<?, ?> cantidadMQColumn;

    @FXML
    private TableColumn<?, ?> fechaFinColumn;

    @FXML
    private TableColumn<?, ?> fechaInicioColumn;

    @FXML
    private TableColumn<?, ?> instructorColumn;

    @FXML
    private TableView<Usuario> reservasTableView;


    private ObservableList<Usuario> usuarios;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();

        this.reservasTableView.setItems(this.usuarios);

        this.instructorColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.fechaInicioColumn.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        this.fechaFinColumn.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        this.cantidadMQColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

    }

    public void setupObservableList(ObservableList<Usuario> usuarios) {

        this.usuarios = usuarios;
        this.reservasTableView.setItems(this.usuarios);

    }

    public void closeWindows(){

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));

            Parent root = loader.load();

            MainMenuController controller = loader.getController();
            controller.updateObservableList(this.usuarios);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
