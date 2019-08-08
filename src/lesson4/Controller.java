package lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML public TextArea textArea;
    @FXML public TextField textField;

    public void sendMSG(ActionEvent actionEvent) {

        String t = textField.getText();

        if (t.equals("")) {
            alertMessage("Сообение не может быть пустым");  return;
        }
        textArea.appendText(t + "\n");
        textField.setText("");

    }

    private void alertMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setEditable(false);
    }
}
