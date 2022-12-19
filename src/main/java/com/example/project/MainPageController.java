package com.example.project;

import com.example.focus.Client;
import com.example.focus.ObjectSwamp;
import com.example.focus.Storage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainPageController {
    public VBox deliversVBox;
    public TextField moneyTextField;
    public TextArea loggerTextArea;
    public VBox vBoxBreadDelivery;
    public VBox vBoxConfectioneryDelivery;
    public VBox vBoxDairyDelivery;
    public VBox vBoxMeatDelivery;
    public VBox vBoxFishDelivery;
    public VBox vBoxVegetableDelivery;
    public VBox vBoxFruitDelivery;
    public VBox vBoxBeverageDelivery;
    public VBox vBoxBreadUser;
    public VBox vBoxConfectioneryUser;
    public VBox vBoxDairyUser;
    public VBox vBoxMeatUser;
    public VBox vBoxFishUser;
    public VBox vBoxVegetableUser;
    public VBox vBoxFruitUser;
    public VBox vBoxBeverageUser;
    public static ArrayList<VBox> deliversGoodsVBox = new ArrayList<>();
    public static ArrayList<VBox> usersGoodsVBox = new ArrayList<>();
    public TextField fieldDepartmentInfo;
    public TextField fieldProductInfo;
    public TextField fieldCostInfo;
    public TextField fieldCountInput;
    public TextField fieldDeliverInfo;
    public Button buttonBuy;

    private void setUpVBox(ArrayList<VBox> listGoods, VBox vBoxBreadUser, VBox vBoxConfectioneryUser, VBox vBoxDairyUser, VBox vBoxMeatUser, VBox vBoxFishUser, VBox vBoxVegetableUser, VBox vBoxFruitUser, VBox vBoxBeverageUser) {
        listGoods.add(vBoxBreadUser);
        listGoods.add(vBoxConfectioneryUser);
        listGoods.add(vBoxDairyUser);
        listGoods.add(vBoxMeatUser);
        listGoods.add(vBoxFishUser);
        listGoods.add(vBoxVegetableUser);
        listGoods.add(vBoxFruitUser);
        listGoods.add(vBoxBeverageUser);
    }
    public void initialize() {
        setUpVBox(deliversGoodsVBox, vBoxBreadDelivery, vBoxConfectioneryDelivery, vBoxDairyDelivery, vBoxMeatDelivery,
                vBoxFishDelivery, vBoxVegetableDelivery, vBoxFruitDelivery, vBoxBeverageDelivery);

        setUpVBox(usersGoodsVBox, vBoxBreadUser, vBoxConfectioneryUser, vBoxDairyUser, vBoxMeatUser, vBoxFishUser,
                vBoxVegetableUser, vBoxFruitUser, vBoxBeverageUser);

        ObjectSwamp.loadClass();
        Timer myTimer;
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            public void run() {
                timerTick();
            }
        }, 0, 1000); // каждые 5 секунд
        for(String deliver : ObjectSwamp.delivers.keySet()) {
            Button buttonDeliverToAdd = new Button(ObjectSwamp.delivers.get(deliver).getName());
            buttonDeliverToAdd.setPrefWidth(deliversVBox.getPrefWidth());
            buttonDeliverToAdd.setOnAction(actionEvent -> {
                for (VBox vBox : deliversGoodsVBox) {
                    vBox.getChildren().clear();
                }
                for (VBox vBox : usersGoodsVBox) {
                    vBox.getChildren().clear();
                }
                for (int i = 0; i < deliversGoodsVBox.size(); i++){
                    Storage currentDeliverStorage = ObjectSwamp.delivers.get(deliver).storage;
                    Storage currentUserStorage = ObjectSwamp.myStorage;
                    setUpVBox(i, deliversGoodsVBox);
                    setUpVBox(i, usersGoodsVBox);
                    for(int j = 0; j < 3; j++){
                        String currentDivision = ObjectSwamp.divisionsName.get(i);
                        setUpDeliverGoods(i, j, deliver, currentDeliverStorage, currentDivision);
                        setUpUserGoods(i, j, currentUserStorage, currentDivision);
                    }
                }
            });
            deliversVBox.getChildren().add(buttonDeliverToAdd);
        }
        moneyTextField.setText(Integer.toString(ObjectSwamp.myTerminal.getMoney()));
    }
    private void setUpDeliverGoods(int i, int j, String deliver, Storage currentDeliverStorage, String currentDivision) {
        HBox hBoxDeliver = new HBox();
        Button buttonGoodDeliver = new Button(currentDeliverStorage.goodsByDivision.get(currentDivision).get(j).getName());
        Label labelCostDeliver = new Label(Integer.toString(currentDeliverStorage.goodsByDivision.get(currentDivision).get(j).getOldCost()));
        Label labelCountDeliver = new Label(Integer.toString(currentDeliverStorage.goodsByDivision.get(currentDivision).get(j).getCount()));
        buttonGoodDeliver.setOnAction(actionEvent1 -> {
            fieldDeliverInfo.setText(ObjectSwamp.delivers.get(deliver).getName());
            fieldDepartmentInfo.setText(currentDivision);
            fieldProductInfo.setText(buttonGoodDeliver.getText());
            fieldCostInfo.setText(labelCostDeliver.getText());
        });
        buttonGoodDeliver.setPrefWidth(110);
        labelCostDeliver.setPrefWidth(40);
        hBoxDeliver.getChildren().add(buttonGoodDeliver);
        hBoxDeliver.getChildren().add(labelCostDeliver);
        hBoxDeliver.getChildren().add(labelCountDeliver);
        deliversGoodsVBox.get(i).getChildren().add(hBoxDeliver);
    }
    private void setUpUserGoods(int i, int j, Storage currentUserStorage, String currentDivision){
        HBox hBoxUser = new HBox();
        Button buttonGoodUser = new Button(currentUserStorage.goodsByDivision.get(currentDivision).get(j).getName());
        Label labelCostUser = new Label(Integer.toString(currentUserStorage.goodsByDivision.get(currentDivision).get(j).getOldCost()));
        Label labelCountUser = new Label(Integer.toString(currentUserStorage.goodsByDivision.get(currentDivision).get(j).getCount()));
        buttonGoodUser.setOnAction(actionEvent1 -> {

        });
        buttonGoodUser.setPrefWidth(110);
        labelCostUser.setPrefWidth(40);
        hBoxUser.getChildren().add(buttonGoodUser);
        hBoxUser.getChildren().add(labelCostUser);
        hBoxUser.getChildren().add(labelCountUser);
        usersGoodsVBox.get(i).getChildren().add(hBoxUser);
    }
    private void setUpVBox(int i, ArrayList<VBox> goodsVBox) {
        HBox hBoxTitleUser = new HBox();
        Button buttonGoodTitleUser = new Button("Product");
        Label labelCostTitleUser = new Label("Cost");
        Label labelCountTitleUser = new Label("Count");
        buttonGoodTitleUser.setDisable(true);
        buttonGoodTitleUser.setPrefWidth(110);
        labelCostTitleUser.setPrefWidth(40);
        hBoxTitleUser.getChildren().add(buttonGoodTitleUser);
        hBoxTitleUser.getChildren().add(labelCostTitleUser);
        hBoxTitleUser.getChildren().add(labelCountTitleUser);
        goodsVBox.get(i).getChildren().add(hBoxTitleUser);
    }

    public void buttonBuyClick(){

    }
    public int timerTickIndex = 0;
    public void timerTick(){
        timerTickIndex++;
        if(timerTickIndex % 15 == 0) {
            Random rand = new Random();
            int randName = rand.nextInt(ObjectSwamp.goodsName.size());
            ObjectSwamp.clients.add(new Client(ObjectSwamp.goodsName.get(randName)));
        }
        if(timerTickIndex % 25 == 0) {

        }
        System.out.println(timerTickIndex);
    }
}