/**@Author Yam Chernichovsky 327484085
 * @version 26.4.2023
 */

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class MenuController {
    Order order;
    Optional<String> result;

    public void alert (){ //Popup that pups when the user press on the main button
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order confirmation");
        alert.setHeaderText("Here is you'r order!");
        String s =order.m.toStringSelected();
        s =s.concat("The total price is: "+order.m.getTotalPrice());
        alert.setContentText(s);
        ButtonType buttonTypeOne = new ButtonType("Pay");
        ButtonType buttonTypeTwo = new ButtonType("Abort");
        ButtonType buttonTypeCancel = new ButtonType("Edit", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){ //pay pressed
            pay();
        } else if (result.get() == buttonTypeTwo) { //abort presed
            initialize();
        }else {   // //edit pressed or the dialog closed
        }
    }
    public void pay(){ //when pay in the dialog pressed
        TextInputDialog dialog = new TextInputDialog("NameId");
        dialog.setTitle("Payment");
        dialog.setHeaderText("Payment");
        dialog.setContentText("Please enter your name and id");
        Optional<String> result = dialog.showAndWait(); //get response valuse and save to file.
        if (result.isPresent()){
            try {
                FileWriter myWriter = new FileWriter(result.get()+".txt");
                String s =order.m.toStringSelected();
                s =s.concat("The total price is: "+order.m.getTotalPrice());
                myWriter.write(s);
                myWriter.close();
                initialize();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
    @FXML
    private GridPane grid;

    @FXML
    void orderPressed(ActionEvent event) {
        alert();
    }

        @FXML
        public void initialize () {
            order = new Order();
            int count = 0;
            final int PREFWIDTH = (int) (grid.getPrefWidth() / 4);
            final int PREFHEIGHT = (int) grid.getPrefHeight() / menueSize(order);
            Separator separator = new Separator();
            grid.add(separator, count++, 0);
            for (int i = 0; i < 4; i++) {
                if (order.getType(i).size() > 0) {
                    Label l = new Label();
                    l.setText(reOrderType(i));
                    l.setBackground(Background.fill(Color.LIGHTBLUE));
                    l.setAlignment(Pos.CENTER);
                    l.setPrefSize(PREFWIDTH, PREFHEIGHT);
                    grid.add(l, 0, count++);
                    for (int j = 0; j < order.getType(i).size(); j++) {
                        Label nameLable = new Label(order.getType(i).get(j).getDiscription());
                        Label priceLable = new Label(order.getType(i).get(j).getPriceString());
                        CheckBox checkBox = new CheckBox();
                        ComboBox comboBox = new ComboBox<>();
                        comboBox.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7"));
                        nameLable.setPrefSize(PREFWIDTH, PREFHEIGHT);
                        priceLable.setPrefSize(PREFWIDTH, PREFHEIGHT);
                        checkBox.setAccessibleText(i+""+j);
                        comboBox.setAccessibleText(i+""+j);
                        checkBox.setOnAction(
                            //get the saved valuse :
                           // int i = Integer.parseInt(String.valueOf(nameLable.getAccessibleText().charAt(0)))
                          //  int j = Integer.parseInt(String.valueOf(nameLable.getAccessibleText().charAt(1)))
                                (e) -> order.getType(Integer.parseInt(String.valueOf(checkBox.getAccessibleText().charAt(0)))).get(Integer.parseInt(String.valueOf(checkBox.getAccessibleText().charAt(1)))).selected()
                        );
                        comboBox.setOnAction(
                                (e) -> order.getType(Integer.parseInt(String.valueOf(comboBox.getAccessibleText().charAt(0)))).get(Integer.parseInt(String.valueOf(comboBox.getAccessibleText().charAt(1)))).setAmount(Integer.parseInt(comboBox.getValue().toString()))
                        );
                        grid.add(nameLable, 0, count);
                        grid.add(priceLable, 1, count);
                        grid.add(checkBox, 2, count);
                        grid.add(comboBox, 3, count++);

                    }
                }
            }
        }


        public int menueSize (Order o){ //helps to calculate the prefer wight and the prefer hight
            int count = 0;
            for (int i = 0; i < 4; i++) {
                count += o.getType(i).size();
            }
            if (count > 0)
                return count;
            else return 1;
        }

        public String reOrderType ( int i){ //back from numbers to strings
            if (i == 0)
                return "Apetiter";
            else if (i == 1)
                return "Main";
            else if (i == 2)
                return "Desert";
            else if (i == 3)
                return "Drink";
            else return "";
        }

    }

