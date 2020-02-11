package sample;

import Domain.Product;
import Repository.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    @FXML
    private ListView<String> productList;

    @FXML
    private Button filterButton;

    @FXML
    private TextField productNameText;

    @FXML
    private TextField inferiorLimitText;

    @FXML
    private TextField superiorLimitText;


    @FXML
    private ListView<String> basketList;
    @FXML
    private TextField totalSum;

    @FXML
    public TextField quantityText;

    Repo repo=new Repo("C:\\Users\\Smart_Slim\\IdeaProjects\\PracticalExamMAP\\src\\products.txt");
    ArrayList<Product> products=repo.getProducts();

    ObservableList<String> productsFromRepo = FXCollections.observableArrayList();
    public void initialize() {
        this.productsFromRepo.setAll(products.get(0).toString(),products.get(1).toString(),products.get(2).toString(),
                products.get(3).toString(),products.get(4).toString());
        this.productList.setItems(this.productsFromRepo);
    }

    ObservableList<String> filteredProducts = FXCollections.observableArrayList();
    @FXML
    void filterButtonF(ActionEvent event) {
        this.productList.getItems().clear();


        String name=productNameText.getText();
        int inf=Integer.parseInt(inferiorLimitText.getText());
        int sup=Integer.parseInt(superiorLimitText.getText());
        //cred ca pot face pe products direct
        List<Product> newProducts= products.stream().filter(product->{
            if ((product.getPrice()<=sup&&product.getPrice()>=inf)&&product.getName().contains(name))
                    return true;
                return false;
            }).collect(Collectors.toList());
        for(int i=0;i<newProducts.size();i++)
            this.filteredProducts.add(i,products.get(i).toString());
        this.productList.setItems(this.filteredProducts);
    }

    ObservableList<String> boughtP = FXCollections.observableArrayList();
    @FXML
    private void buyButtonF(ActionEvent actionEvent) {

        Alert a = new Alert(Alert.AlertType.NONE);
        String p=productList.getSelectionModel().getSelectedItem();
        String[] elems = p.split(",");
        int quantity=Integer.parseInt(elems[4]);
        int quantityText1=Integer.parseInt(quantityText.getText());
        if(quantity<quantityText1)
        {
            a.setAlertType(Alert.AlertType.CONFIRMATION);

            // show the dialog
            a.show();
        }
        else
        {
            this.boughtP.add(p);
            this.basketList.setItems(this.boughtP);

        }
        int sum=Integer.parseInt(this.totalSum.getText());
        String price=sum+quantityText1*Integer.parseInt(elems[3])+"$";
        this.totalSum.setText(price);

    }
}
