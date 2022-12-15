package com.example.project;

import com.example.focus.Good;
import com.example.focus.ObjectSwamp;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HelloController {
    public VBox deliversVBox;
    public VBox goodsVBox;
    public VBox storageVBox;
    public TextField moneyTextField;
    public TextArea loggerTextArea;
    public TextField fieldGoodName;
    public Button buttonBuy;
    public TextField fieldGoodCost;
    public TextField fieldGoodNewCost;
    private Good currentGood;
    private Button currentButtonGood;
    public void buttonBuyClick(){
        try {
            ObjectSwamp.myStorage.addGood(currentGood);
            ObjectSwamp.myTerminal.decreaseMoney(currentGood.getOldCost());
            currentGood.setNewCost(Integer.parseInt(fieldGoodNewCost.getText()));
            moneyTextField.setText(Integer.toString(ObjectSwamp.myTerminal.getMoney()));
            goodsVBox.getChildren().remove(currentButtonGood);

            HBox hBox = new HBox();
            TextField textFieldGoodName = new TextField(currentGood.getName());
            textFieldGoodName.setEditable(false);
            textFieldGoodName.setPrefWidth(170);
            TextField textFieldGoodCost = new TextField(Integer.toString(currentGood.getNewCost()));
            textFieldGoodCost.setEditable(false);
            hBox.getChildren().add(textFieldGoodName);
            hBox.getChildren().add(textFieldGoodCost);
            storageVBox.getChildren().add(hBox);
        } catch (Exception exception) {
            System.out.println("Empty fields!");
        }
        fieldGoodName.setText("");
        fieldGoodCost.setText("");
        fieldGoodNewCost.setText("");
        currentGood = null;
        currentButtonGood = null;
    }

    public void initialize() {
        for(String deliver : ObjectSwamp.delivers.keySet()) {
            Button buttonDeliverToAdd = new Button(ObjectSwamp.delivers.get(deliver).getName());
            buttonDeliverToAdd.setPrefWidth(deliversVBox.getPrefWidth());
            buttonDeliverToAdd.setOnAction(actionEvent -> {
                goodsVBox.getChildren().clear();
                ArrayList<Good> goods = ObjectSwamp.delivers.get(buttonDeliverToAdd.getText()).getGoods();
                for (Good good : goods){
                    Button buttonGoodToAdd = new Button(good.getName());
                    buttonGoodToAdd.setOnAction(actionEvent1 -> {
                        fieldGoodName.setText(good.getName());
                        fieldGoodCost.setText(Integer.toString(good.getOldCost()));
                        this.currentGood = good;
                        this.currentButtonGood = buttonGoodToAdd;
                    });
                    buttonGoodToAdd.setPrefWidth(goodsVBox.getPrefWidth());
                    goodsVBox.getChildren().add(buttonGoodToAdd);
                }
            });
            deliversVBox.getChildren().add(buttonDeliverToAdd);
        }
        moneyTextField.setText(Integer.toString(ObjectSwamp.myTerminal.getMoney()));
    }
}