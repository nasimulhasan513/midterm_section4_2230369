package iub.midterm_section4_2230369;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.ArrayList;

public class DatapackageController {


    @FXML
    private TextField dataAmount;

    @FXML
    private DatePicker offerEnds;

    @FXML
    private TextField packageName;

    @FXML
    private TextField price;

    @FXML
    private ComboBox<String> validity;

    @FXML
    private ComboBox<String> availability;

    @FXML
    private Text validationMessage;


    @FXML
    private TableView<DataPackage> dataTable;

    @FXML
    private TableColumn<DataPackage, String> packageNameColumn;
    @FXML
    private TableColumn<DataPackage, String> availabilityColumn;

    @FXML
    private TableColumn<DataPackage, LocalDate> offerEndsColumn;

    @FXML
    private TableColumn<DataPackage, Integer> amountColumn;


    @FXML
    private TableColumn<DataPackage, Integer> priceColumn;

    @FXML
    private TableColumn<DataPackage, String> validityColumn;

    private ArrayList<DataPackage> packages;

    private ArrayList<DataPackage> filteredPackages;

    @FXML
    void initialize() {
        validity.getItems().setAll("3 Days", "7 Days", "15 Days", "30 Days", "Unlimited");
        availability.getItems().setAll("App Only", "Recharge Only", "App and Recharge Both");

        packages = new ArrayList<DataPackage>();

        packageNameColumn.setCellValueFactory(new PropertyValueFactory<DataPackage, String>("package_name"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<DataPackage, String>("availability"));
        offerEndsColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,LocalDate>("offer_ends"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,Integer>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,Integer>("price"));
        validityColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,String>("validity"));

    }

    ArrayList<DataPackage> dataPackages = new ArrayList<>();


    @FXML
    void createDataPack(MouseEvent event) {


        if(packageName.getText().trim().isEmpty()){
            validationMessage.setText("Please enter a valid package name.");
            return;
        }


        // duplicate name check
        for(DataPackage dataPackage : dataPackages){
            if(dataPackage.getPackage_name().equals(packageName.getText())){
                validationMessage.setText("Package already exists.");
                return;
            }
        }


        if(dataAmount.getText().trim().isEmpty()){
            validationMessage.setText("Data Amount cannot be empty and must be greater than 0.");
            return;
        }

        if(price.getText().trim().isEmpty()){
            validationMessage.setText("Price cannot be empty and must be greater than 0.");
            return;
        }


        if(validity.getValue().trim().isEmpty()){
            validationMessage.setText("Please select a valid validity type.");
            return;
        }


        DataPackage data_pack = new DataPackage(packageName.getText().trim(), Integer.parseInt(dataAmount.getText().trim()), validity.getValue() ,availability.getValue(),
                Integer.parseInt(price.getText().trim()),
                offerEnds.getValue()
                );

        dataPackages.add(data_pack);

        validationMessage.setText("Data Package created.");

        dataTable.getItems().add(data_pack);
    }

}
