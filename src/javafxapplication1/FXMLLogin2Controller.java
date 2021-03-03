/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class FXMLLogin2Controller implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button bntConnect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == bntConnect) {
            insertRecord();
            Parent Ajouter = FXMLLoader.load(getClass().getResource("FXMLSCOREPARAM.fxml"));
            Scene scene = new Scene(Ajouter);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

    }

    public Connection getConnetion() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2fac", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("error");
            return null;
        }
    }

    public ObservableList<User> getUserList() {
        ObservableList<User> userlist = FXCollections.observableArrayList();
        Connection conn = getConnetion();
        String query = "SELECT * FROM login";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            User user;
            while (rs.next()) {
                user = new User(rs.getString("Email"), rs.getString("Password"));
                userlist.add(user);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return userlist;
    }

    private void insertRecord() {
        String query = "INSERT INTO login (Email,Password) VALUES('" + tfLogin.getText() + "','" + tfPassword.getText()+ "')";
        executeQuery(query);
    }

    private void executeQuery(String query) {
        Connection conn = getConnetion();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
