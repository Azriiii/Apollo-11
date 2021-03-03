/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class FXMLSIDEBARController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Button p1;
    @FXML
    private Button p2;
    @FXML
    private Button p3;
    @FXML
    private Button p4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == p1) {
            //insertRecord();
            Parent Ajouter = FXMLLoader.load(getClass().getResource("FXMLInscription.fxml"));
            Scene scene = new Scene(Ajouter);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else if (event.getSource() == p2) {
            //insertRecord();
            Parent Ajouter = FXMLLoader.load(getClass().getResource("FXMLParam.fxml"));
            Scene scene = new Scene(Ajouter);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else if (event.getSource() == p3) {
            //insertRecord();
            Parent Ajouter = FXMLLoader.load(getClass().getResource("FXMLLogin2.fxml"));
            Scene scene = new Scene(Ajouter);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else if (event.getSource() == p4) {
            //insertRecord();
            Parent Ajouter = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(Ajouter);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

    }
}
