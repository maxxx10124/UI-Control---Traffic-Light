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
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class App extends Application {
    int radius = 20;
    Circle circle = new Circle(radius);
    int dx = 1, dy = 1;
    double x = circle.getRadius(), y = circle.getRadius();
@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Loan Calculator");
// Create UI elements
        TextField loanAmountField = new TextField();
        TextField interestRateField = new TextField();
        TextField loanTermField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();
        Label totalPayment = new Label();
 // Layout using VBox
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        layout.setHgap(5.5);
        layout.setVgap(5.5);
        layout.add(new Label("Loan Amount:"), 0,0);
        layout.add(loanAmountField,1,0);
        layout.add(new Label("Interest Rate:"), 0, 1);
        layout.add(interestRateField,1,1);
        layout.add(new Label("Loan Term:"), 0, 2);
        layout.add(loanTermField, 1, 2);
        layout.add(new Label("Monthly Payment:"), 0, 4);
        layout.add(resultLabel, 1,4);
        layout.add(new Label("Total Payment:"), 0, 5);
        layout.add(totalPayment, 1, 5);
        layout.setAlignment(Pos.CENTER);
        layout.add(calculateButton, 1, 3);
        calculateButton.setOnAction(e -> {
// Calculation Logic
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText()) / 100 / 12;
            int loanTerm = Integer.parseInt(loanTermField.getText()) *12;
            double monthlyPayment = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTerm));
            double total  = monthlyPayment * loanTerm;
            resultLabel.setText(String.format("%.2f",monthlyPayment));
            totalPayment.setText(String.format("%.2f", total));
        });



// Animation        
        Pane pane = new Pane();
        
        circle.setFill(Color.RED);
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(6), e -> moveBall(pane)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        pane.getChildren().add(circle);
        pane.setPrefWidth(400);
        pane.setBorder(new Border(new BorderStroke(Color. BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        circle.setCenterX(15);
        circle.setCenterY(15);
        BorderPane bp = new BorderPane();
        bp.setLeft(layout);
        bp.setRight(pane);
        Scene scene = new Scene(bp, 800, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void moveBall(Pane p) {
        if (x < radius || x > p.getWidth() - radius) {
          dx *= -1; 
        }
        if (y < radius || y > p.getHeight() - radius) {
          dy *= -1; 
        }
    
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
      }
    public static void main(String[] args) {
        launch(args);
    }
}