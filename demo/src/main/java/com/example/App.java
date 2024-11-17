package com.example;
// Main class for the Loan Calculator
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import javafx.animation.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class App extends Application {
@Override
    public void start(Stage primaryStage) {
      RadioButton rbRed = new RadioButton("Red");
      RadioButton rbYellow = new RadioButton("Yellow");
      RadioButton rbGreen = new RadioButton("Green");
      HBox buttons = new HBox(20);
      ToggleGroup group = new ToggleGroup();
      rbRed.setToggleGroup(group);
      rbYellow.setToggleGroup(group);
      rbGreen.setToggleGroup(group);
      buttons.getChildren().addAll(rbRed, rbYellow, rbGreen);

      Pane pane = new Pane();
      Rectangle border = new Rectangle(70, 10, 60, 166);
      border.setFill(Color.BLACK);
      Rectangle frame = new Rectangle(72, 12, 56, 162);
      frame.setFill(Color.WHITE);
      Circle redLightBorder = new Circle(100, 42, 22);
      redLightBorder.setFill(Color.BLACK);
      Circle redLight = new Circle(100, 42, 20);
      redLight.setFill(Color.WHITE);
      Circle yellowLightBorder = new Circle(100, 92, 22);
      yellowLightBorder.setFill(Color.BLACK);
      Circle yellowLight = new Circle(100, 92, 20);
      yellowLight.setFill(Color.WHITE);
      Circle greenLightBorder = new Circle(100, 142, 22);
      greenLightBorder.setFill(Color.BLACK);
      Circle greenLight = new Circle(100, 142, 20);
      greenLight.setFill(Color.WHITE);
      pane.getChildren().addAll(border,frame, redLightBorder, redLight, yellowLightBorder, yellowLight, greenLightBorder, greenLight);
      rbRed.setOnAction(e -> {
        if (rbRed.isSelected()) {
          redLight.setFill(Color.RED);
          yellowLight.setFill(Color.WHITE);
          greenLight.setFill(Color.WHITE);
        }
      });
      rbYellow.setOnAction(e ->{
        if(rbYellow.isSelected()){
          redLight.setFill(Color.WHITE);
          yellowLight.setFill(Color.YELLOW);
          greenLight.setFill(Color.WHITE);
        }
      });
      rbGreen.setOnAction(e ->{
        if(rbGreen.isSelected()){
          redLight.setFill(Color.WHITE);
          yellowLight.setFill(Color.WHITE);
          greenLight.setFill(Color.GREEN);
        }
      });
    
  






      primaryStage.setTitle("Trafic Light");
      BorderPane bp = new BorderPane();
      bp.setBottom(buttons);
      bp.setTop(pane);
      Scene scene = new Scene(bp, 200, 200);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}