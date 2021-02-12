package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import model.Classroom;
import model.UserAccount;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.time.LocalDate;

enum Gender{
    MALE, FEMALE, OTHER
}

enum Browser{
    CHROME, MOZILLA, OPERA, EDGE, TOR
}

enum Career{
    SOFTWAREENGINEERING, TELEMATICENGINEERING, INDUSTRIALENGINEERING
}

public class ClassroomGUI {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label userLabel;

    @FXML
    private ImageView pfpImageView;

    @FXML
    private TableView<?> uaiTableView;

    @FXML
    private TableColumn<UserAccount, String> userTableColumn;

    @FXML
    private TableColumn<UserAccount, String> genTableColumn;

    @FXML
    private TableColumn<UserAccount, String> carTableColumn;

    @FXML
    private TableColumn<UserAccount, LocalDate> bdTableColumn;

    @FXML
    private TableColumn<UserAccount, String> brTableColumn;

    @FXML
    private TextField regUTextField;

    @FXML
    private TextField regPTextField;

    @FXML
    private TextField pfpTextField;

    @FXML
    private RadioButton mlRadioButton;

    @FXML
    private RadioButton flRadioButton;

    @FXML
    private RadioButton otRadioButton;

    @FXML
    private CheckBox seCheckBox;

    @FXML
    private CheckBox teCheckBox;

    @FXML
    private CheckBox ieCheckbox;

    @FXML
    private DatePicker bdDatePicker;

    @FXML
    private ComboBox<?> fbComboBox;

    private Classroom classroom;


    public ClassroomGUI() {
        this.classroom = new Classroom();
    }

    //login button in register.fxml
    @FXML
    public void loadLogIn(ActionEvent event) throws  IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
    }

    //login button from login.
    @FXML
    public void loadAccountList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("account-list.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
    }

    //signup button from login.
    @FXML
    public void loadSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
    }

    //logout button from account-list
    @FXML
    public void logout(ActionEvent event) throws IOException {
        loadLogIn(event);
    }

    //create account button on register.fxml
    @FXML
    public void createAccount(ActionEvent event)  {

    }

    //browse button on register.fxml
    @FXML
    public void browsePfp(ActionEvent event) {

    }

}
