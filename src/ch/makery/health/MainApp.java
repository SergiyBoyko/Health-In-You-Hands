package ch.makery.health;

import ch.makery.health.model.Code;
import ch.makery.health.view.FullBaseController;
import ch.makery.health.view.MainSearchController;
import ch.makery.health.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by fbrsw on 28.03.2017.
 */


public class MainApp extends Application {

    private ObservableList<Code> codesData = FXCollections.observableArrayList();

    private Stage primaryStage;
    private BorderPane rootLayout;

    public MainApp() {
        // В качестве образца добавляем некоторые данные
        codesData.add(new Code("Статеві залози", "73", "1.jpg"));
        codesData.add(new Code("Спазми в черевній порожнині", "1В,71", "2.jpg"));
        codesData.add(new Code("Лімфатичні судини черевної порожнини", "73,45", "3.jpg"));
        codesData.add(new Code("Набряк черевної порожнини", "49 1/2,52,73,26,27,9М", "4.jpg"));
        codesData.add(new Code("Ахіллове сухожилля", "73,45", "5.jpg"));
        codesData.add(new Code("Підвищена кислотність", "20,14B,8,S3-ліва,S1-права", "6.jpg"));
        codesData.add(new Code("Хвороба Аддісона", "46,10МВ,11МВ", "7.jpg"));
        codesData.add(new Code("Аденоіди", "11M,48", "8.jpg"));
        codesData.add(new Code("Спайки", "49,S2-ліва,2В", "9.jpg"));
        codesData.add(new Code("Наднирники", "46,10МВ,43", ""));
        codesData.add(new Code("Накопичення лугів", "14В", ""));
        codesData.add(new Code("Амнезія", "63", ""));
        codesData.add(new Code("Анемія", "49,24,80", ""));
        codesData.add(new Code("Аневризма", "S1левая,49 (Зі4)", ""));
        codesData.add(new Code("Укус тварини", "S2ліва, 59", ""));
        codesData.add(new Code("Кісточка", "41,61,73", ""));
        codesData.add(new Code("Антибіотики", "48,S2левая", ""));
        codesData.add(new Code("Анус", "84,68,S3левая", ""));
        codesData.add(new Code("Черевна аорта", "49 (Зі4)", ""));
        codesData.add(new Code("Втрата голосу", "24,2В,80", ""));
        codesData.add(new Code("Апоплексия", "26,49,91,50", ""));
        codesData.add(new Code("Аппендицит", "5В-права або 77-права, 65", ""));
        codesData.add(new Code("Апетит поганий", "1В, 19", ""));
        codesData.add(new Code("Руки", "20,36,12В, 82,81,50", ""));
        codesData.add(new Code("Артеріальна кров-хлів", "S2 ліва", ""));
        codesData.add(new Code("Артерії", "S1левая, S2левая", ""));
        codesData.add(new Code("Атеросклероз", "12М", ""));
//        codesData.add(new Code("","",""));
    }

    public ObservableList<Code> getCodesData() {
//        System.out.println("size : " + codesData.size());
        return codesData;
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Health In You Hand");

        initRootLayout();

        showMainSearch();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     */
    public void showMainSearch() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainController.fxml"));
            AnchorPane MainSearchPage = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(MainSearchPage);

            MainSearchController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBase() {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FullBase.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("База кодів");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            FullBaseController controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
