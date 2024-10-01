package com.fpdone.reservametaquest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {


    String nombre = "Cafu Mancilla";
    String fechaInicio = "01 de enero";
    String fechaFin = "31 de diciembre";
    int cantidad = 0;

    @FXML
    private Button realizarReservaBttn;
    @FXML
    private Button eliminarReserveBttn;
    @FXML
    private Button verReservasBttn;
    @FXML
    private Button salirBttn;


    private ObservableList<Usuario> usuarios;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();
        generarReservas();

    }

    public void generarReservas()
    {
        nombre = "";
        fechaInicio = "";
        fechaFin = "";
        cantidad = 12;
        Usuario usuario1 = new Usuario("Cafu Mancilla", "02 de octubre", "06 de octubre", 11);
        Usuario usuario2= new Usuario("Jose Mendoza", "08 de octubre", "10 de octubre", 13);
        Usuario usuario3 = new Usuario("David Quispe", "11 de octubre", "15 de octubre", 7);
        Usuario usuario4 = new Usuario("Juan Huaman", "16 de octubre", "20 de octubre", 16);
        Usuario usuario5 = new Usuario("Rodrigo Torrez", "25 de octubre", "30 de octubre", 6);
        Usuario usuario6 = new Usuario("Ernesto Echegaray", "01 de noviembre", "03 de noviembre", 15);
        Usuario usuario7 = new Usuario("Fernando Condor", "08 de noviembre", "09 de noviembre", 9);
        Usuario usuario8 = new Usuario("Hector Mendizabal", "15 de noviembre", "19 de noviembre", 10);
        Usuario usuario9 = new Usuario("Carlos Hurtado", "23 de noviembre", "26 de noviembre", 11);
        Usuario usuario10 = new Usuario("Raul Parraga", "29 de noviembre", "04 de diciembre", 16);

        Usuario[] usuariosArray = {usuario1, usuario2, usuario3, usuario4, usuario5, usuario6, usuario7, usuario8, usuario9, usuario10};

        for (int i = 0; i < usuariosArray.length; i++){

            if (!this.usuarios.contains(usuariosArray[i])) {
                this.usuarios.add(usuariosArray[i]);
            }
        }
    }

    public void updateObservableList(ObservableList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @FXML
    private void realizarReservaScreen(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("RealizarReservaView.fxml"));

            Parent root = loader.load();

            RealizarReservaController controller = loader.getController();
            controller.setupObservableList(usuarios);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> controller.closeWindows());

            Stage myStage = (Stage) this.realizarReservaBttn.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void eliminarReservaScreen(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("EliminarReservaView.fxml"));

            Parent root = loader.load();

            EliminarReservaController controller = loader.getController();
            controller.setupObservableList(usuarios);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> controller.closeWindows());

            Stage myStage = (Stage) this.eliminarReserveBttn.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void verReservasScreen(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerReservasView.fxml"));

            Parent root = loader.load();

            VerReservasController controller = loader.getController();
            controller.setupObservableList(usuarios);

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> controller.closeWindows());

            Stage myStage = (Stage) this.verReservasBttn.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void salirScreen(ActionEvent actionEvent) {
        Stage stage = (Stage) this.salirBttn.getScene().getWindow();
        stage.close();
    }

}
