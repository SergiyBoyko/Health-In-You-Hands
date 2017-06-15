package ch.makery.health.view;

import ch.makery.health.MainApp;
import ch.makery.health.model.Code;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by fbrsw on 28.03.2017.
 */
public class FullBaseController {
    @FXML
    private Label cod;
    @FXML
    private TableView<Code> codeTable;
    @FXML
    private TableColumn<Code, String> firstNameColumn;
    @FXML
    private ImageView image;


    private Stage dialogStage;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        codeTable.setItems(mainApp.getCodesData());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());

        showCodeDetails(null);

        codeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCodeDetails(newValue));

    }

    private void showCodeDetails(Code code) {
        if (code != null) {
            cod.setText(code.getName() + " : " + code.getCode());
            Image img = new Image("file:resources/Images/" + code.getPicture());
            image.setImage(img);
        } else {
            // Если code = null, то убираем весь текст.
            cod.setText("");
        }
    }

}
