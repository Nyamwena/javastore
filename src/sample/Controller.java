package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML RadioButton usdRadio, zwlRadio;
    @FXML Button btnCal, btnReset;
    @FXML ComboBox itemSelect;

    @FXML
    TextField txtQuantity  ;
    @FXML ListView listItem;
    @FXML
    Label totalCost;
    double sugar = 0, bread = 0, milk= 0, jam = 0;
    double total = 0;
    double quantity = 0;

    ObservableList<String> observableList = FXCollections.observableArrayList("Select Item", "Sugar", "Bread", "Milk", "Jam");

    ObservableList<String> listviewItems = FXCollections.observableArrayList("");




   // radio button selected



    // function for ZWL currency
    public  void zwlCurrency (){
        sugar = 20.00;
        bread = 8.50;
         milk = 7.00;
         jam = 15.00;
    }
    //function for USD currency
    public  void usdCurrency (){
        sugar = 2.00;
         bread = 0.90;
        milk = 1.00;
        jam = 1.50;
    }

    public void calculateTotal (){

        if (usdRadio.isSelected()) {
            usdCurrency();
        }
        if (zwlRadio.isSelected()) {
            zwlCurrency();
        }
        double mytotal = Double.parseDouble(totalCost.getText());

       quantity = Integer.parseInt(txtQuantity.getText());
       if(itemSelect.getValue().equals("Sugar") && usdRadio.isSelected() ){
           usdCurrency();

           total =  (sugar * quantity) + mytotal;
           txtQuantity.setText("");
           itemSelect.setValue("Select Item");
           String itemSugar = "Sugar" + "                                                  " + quantity ;
          listItem.getItems().add(itemSugar);
       }
        if(itemSelect.getValue().equals("Milk") && usdRadio.isSelected() ){
            usdCurrency();

            total =  (milk * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");

            String itemMilk = "Milk" + "                                                  " + quantity ;
            listItem.getItems().add(itemMilk);
        }
        if(itemSelect.getValue().equals("Bread") && usdRadio.isSelected() ){
            usdCurrency();

            total =  (bread * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");

            String itemBread = "Bread" + "                                                  " + quantity ;
            listItem.getItems().add(itemBread);
        }
        if(itemSelect.getValue().equals("Jam") && usdRadio.isSelected() ){
            usdCurrency();

            total =  (jam * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");

            String itemJam = "Jam" + "                                                  " + quantity ;
            listItem.getItems().add(itemJam);
        }


        //call zwl currency
        if(itemSelect.getValue().equals("Sugar") && zwlRadio.isSelected() ){
            zwlCurrency();

            total =  (sugar * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");
            String itemSugar = "Sugar (zwl)" + "                                                  " + quantity ;
            listItem.getItems().add(itemSugar);
        }
        if(itemSelect.getValue().equals("Milk") && zwlRadio.isSelected() ){
            zwlCurrency();

            total =  (milk * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");

            String itemMilk = "Milk (zwl)" + "                                                  " + quantity ;
            listItem.getItems().add(itemMilk);
        }
        if(itemSelect.getValue().equals("Bread") && zwlRadio.isSelected() ){
            zwlCurrency();

            total =  (bread * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");
            String itemBread = "Bread (zwl)" + "                                                  " + quantity ;
            listItem.getItems().add(itemBread);
        }
        if(itemSelect.getValue().equals("Jam") && zwlRadio.isSelected() ){
            zwlCurrency();

            total =  (jam * quantity) + mytotal;
            txtQuantity.setText("");
            itemSelect.setValue("Select Item");
            String itemJam = "Jam (zwl)" + "                                                  " + quantity ;
            listItem.getItems().add(itemJam);
        }



        totalCost.setText(String.valueOf(total));

    }

    public void resetFields(){
        double resetTotal = 0;
        totalCost.setText(String.valueOf(resetTotal));
        itemSelect.setValue("");
        listItem.setItems(listviewItems);
        txtQuantity.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemSelect.setItems(observableList);
      //  listItem.ge
        listItem.getItems().add("Item         ________________________       Quantity");

        totalCost.setText(String.valueOf(total));
    }
}
