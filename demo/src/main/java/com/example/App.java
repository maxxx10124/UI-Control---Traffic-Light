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
        primaryStage.setTitle("Loan Calculato with Bouncing Ball Animation");
        //Calculator
        TextField loanAmountTf = new TextField();
        TextField interestRateTf = new TextField();
        TextField loanTermTf = new TextField();
        Button calculateBt = new Button("Calculate");
        Label resultLb = new Label();
        Label totalPaymentLb = new Label();
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        layout.setHgap(5.5);
        layout.setVgap(5.5);
        layout.add(new Label("Loan Amount:"), 0,0);
        layout.add(loanAmountTf,1,0);
        layout.add(new Label("Interest Rate:"), 0, 1);
        layout.add(interestRateTf,1,1);
        layout.add(new Label("Loan Term:"), 0, 2);
        layout.add(loanTermTf, 1, 2);
        layout.add(new Label("Monthly Payment:"), 0, 4);
        layout.add(resultLb, 1,4);
        layout.add(new Label("Total Payment:"), 0, 5);
        layout.add(totalPaymentLb, 1, 5);
        layout.setAlignment(Pos.CENTER);
        layout.add(calculateBt, 1, 3);
        calculateBt.setOnAction(e -> {
            double loanAmount = Double.parseDouble(loanAmountTf.getText());
            double interestRate = Double.parseDouble(interestRateTf.getText()) / 100 / 12;
            int loanTerm = Integer.parseInt(loanTermTf.getText()) *12;
            double monthlyPayment = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTerm));
            double total  = monthlyPayment * loanTerm;
            resultLb.setText(String.format("%.2f",monthlyPayment));
            totalPaymentLb.setText(String.format("%.2f", total));
        });



//Ball Animation        
        Pane pane = new Pane();
        
        circle.setFill(Color.RED);
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(6), e -> moveBall(pane)));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        pane.getChildren().add(circle);
        pane.setPrefWidth(400);
        pane.setBorder(new Border(new BorderStroke(Color. BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        circle.setCenterX(x);
        circle.setCenterY(y);
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