package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;


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
    private TableView<UserAccount> uaiTableView;

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
    private PasswordField regPasswordField;

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
    private ComboBox<String> fbComboBox;

    @FXML
    ToggleGroup gender;

    private Classroom classroom;

    private FileChooser fileChooser;

    private Alert alert;

    private UserAccount loggedAccount;


    public ClassroomGUI(Classroom cr) {
        this.classroom = cr;
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg","*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        alert = new Alert(null);
    }

    @FXML
    public void initialize(){
        gender = new ToggleGroup();
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
        if (logIn()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("account-list.fxml"));
            loader.setController(this);
            mainBorderPane.setCenter(loader.load());
            loadSignedAccount();
            setTableView();
        }
    }

    //signup button from login.
    @FXML
    public void loadSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        loader.setController(this);
        mainBorderPane.setCenter(loader.load());
        initializeGroups();
        initializeCombobox();
    }

    //logout button from account-list
    @FXML
    public void logout(ActionEvent event) throws IOException {
        userLabel = null;
        pfpImageView = null;
        loadLogIn(null);
        this.loggedAccount = null;
    }

    //create account button on register.fxml
    @FXML
    public void createAccount(ActionEvent event)  {
        try {
            RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
            classroom.getAccounts().add(new UserAccount(
                    Objects.requireNonNull(bdDatePicker.getValue()),
                    Objects.requireNonNull(checkIfStringEmpty(regUTextField.getText())),
                    Objects.requireNonNull(checkIfStringEmpty(regPasswordField.getText())),
                    Objects.requireNonNull(pfpTextField.getText()),
                    Objects.requireNonNull(getCheckboxesValues()),
                    Objects.requireNonNull(fbComboBox.getValue()),
                    selectedRadioButton.getText()));
            showAlert("Account created", Alert.AlertType.INFORMATION, "The new acount has been created");
        } catch (NullPointerException np) {
            showAlert("Validation Error", Alert.AlertType.ERROR, "You must fill each field in the form");
        }
    }
    //browse button on register.fxml
    @FXML
    public void browsePfp(ActionEvent event) {
        Node node = (Node)event.getSource();
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());
        fileChooser.setTitle("Select a profile picture");
        if (file != null) {
            pfpTextField.setText(file.toURI().toString());
        }
    }

    public void initializeGroups(){
        flRadioButton.setToggleGroup(gender);
        mlRadioButton.setToggleGroup(gender);
        otRadioButton.setToggleGroup(gender);
    }

    public void showAlert(String title, Alert.AlertType type, String content){
        alert.setAlertType(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public boolean logIn(){
        for (UserAccount ua : classroom.getAccounts()){
            if(ua.getUsername().equals(usernameTextField.getText()) && ua.getPassword().equals(passwordTextField.getText())){
                loggedAccount = ua;
                return true;
            } else {
                showAlert("Unable to Log In", Alert.AlertType.ERROR, "The username or password is incorrect");
            }
        } return false;
    }

    public String getCheckboxesValues(){
        if (seCheckBox.isSelected() || teCheckBox.isSelected() || ieCheckbox.isSelected()) {
            String careers = "";
            if (seCheckBox.isSelected()) {
                careers += (seCheckBox.getText() + ", ");
            }
            if (teCheckBox.isSelected()) {
                careers += (teCheckBox.getText() + ", ");
            }
            if (ieCheckbox.isSelected()) {
                careers += ieCheckbox.getText();
            }
            return careers;
        } else {
            return null;
        }
    }

    public void initializeCombobox(){
        ObservableList<String> browsers = FXCollections.observableArrayList("Chrome", "Firefox", "Opera", "Tor", "Edge");
        fbComboBox.setItems(browsers);
    }

    public String checkIfStringEmpty(String s){
        if (s.trim().equals("")){
            return null;
        } return s;
    }

    public void loadSignedAccount(){
        userLabel.setText(loggedAccount.getUsername());
        pfpImageView.setImage(new Image(loggedAccount.getProfilePhoto()));
    }

    private void setTableView() {
        try {
            ObservableList<UserAccount> data = FXCollections.observableArrayList(classroom.getAccounts());
            uaiTableView.setItems(data);
            userTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            genTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            carTableColumn.setCellValueFactory(new PropertyValueFactory<>("careers"));
            bdTableColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
            brTableColumn.setCellValueFactory(new PropertyValueFactory<>("favoriteBrowser"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
