package ch.makery.health.view;

import ch.makery.health.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Created by fbrsw on 28.03.2017.
 */
public class RootLayoutController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleBase() {
        mainApp.showBase();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Допомога");
        alert.setHeaderText("Правила натискання");
        alert.setContentText("Лікувальні точки необхідно натискати строго в заданому порядку.\n" +
                "Кожну точку потрібно натискати приблизно 3 секунди." +
                "\n ...");

        alert.showAndWait();
    }
}
