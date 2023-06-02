package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    private boolean test1 = false;
    private boolean test2 = false;
    private boolean test3 = false;
    private boolean test4 = false;
    private boolean test5 = false;
    private boolean test6 = false;

    @FXML
    private Pane graphe = new Pane();
    @FXML
    private TextField compt1= new TextField("");
    @FXML
    private TextField compt2= new TextField("");
    @FXML
    private TextField compt3= new TextField("");
    @FXML
    private TextField compt4= new TextField("");
    @FXML
    private TextField compt5= new TextField("");
    @FXML
    private TextField compt6 = new TextField("");
    @FXML
    private Label messErr = new Label("");

    private Circle circle1 = new Circle();
    private Circle circle2 = new Circle();
    private Circle circle3 = new Circle();
    private Circle circle4 = new Circle();
    private Circle circle5 = new Circle();
    private Circle circle6 = new Circle();
    private boolean err = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    @FXML
    public void Trace(){
        //**************************     Compt1     ***********************************
        if(!compt1.getText().equals("")) {
            if (Double.parseDouble(compt1.getText()) < 0 || Double.parseDouble(compt1.getText()) > 20){
                err = true;
            }
            else {
                double X1 = getXRadarChart(Double.parseDouble(compt1.getText()), 1);
                double Y1 = getYRadarChart(Double.parseDouble(compt1.getText()), 1);
                circle1.setCenterX(X1);circle1.setCenterY(Y1);circle1.setRadius(5);
                if(test1 == false){
                    graphe.getChildren().add(circle1);
                    test1 = true;
                }
            }
        }

        //**************************     Compt2     ***********************************

        if(!compt2.getText().equals("")) {
            if (Double.parseDouble(compt2.getText()) < 0 || Double.parseDouble(compt2.getText()) > 20){
                err = true;
            }
            else {
                double X2 = getXRadarChart(Double.parseDouble(compt2.getText()), 2);
                double Y2 = getYRadarChart(Double.parseDouble(compt2.getText()), 2);
                circle2.setCenterX(X2);circle2.setCenterY(Y2);circle2.setRadius(5);
                if(test2 == false){
                    graphe.getChildren().add(circle2);
                    test2 = true;
                }
            }
        }
        //**************************     Compt3     ***********************************
        if(!compt3.getText().equals("")) {
            if (Double.parseDouble(compt3.getText()) < 0 || Double.parseDouble(compt3.getText()) > 20){
                err = true;
            }
            else {
                double X3 = getXRadarChart(Double.parseDouble(compt3.getText()), 3);
                double Y3 = getYRadarChart(Double.parseDouble(compt3.getText()), 3);
                circle3.setCenterX(X3);circle3.setCenterY(Y3);circle3.setRadius(5);
                if(test3 == false){
                    graphe.getChildren().add(circle3);
                    test3 = true;
                }
            }
        }

        //**************************     Compt4     ***********************************
        if(!compt4.getText().equals("")) {
            if (Double.parseDouble(compt4.getText()) < 0 || Double.parseDouble(compt4.getText()) > 20){
                err = true;
            }
            else {
                double X4 = getXRadarChart(Double.parseDouble(compt4.getText()), 4);
                double Y4 = getYRadarChart(Double.parseDouble(compt4.getText()), 4);
                circle4.setCenterX(X4);circle4.setCenterY(Y4);circle4.setRadius(5);
                if(test4 == false){
                    graphe.getChildren().add(circle4);
                    test4 = true;
                }
            }
        }
        //**************************     Compt5     ***********************************
        if(!compt5.getText().equals("")) {
            if (Double.parseDouble(compt5.getText()) < 0 || Double.parseDouble(compt5.getText()) > 20){
                err = true;
            }
            else {
                double X5 = getXRadarChart(Double.parseDouble(compt5.getText()), 5);
                double Y5 = getYRadarChart(Double.parseDouble(compt5.getText()), 5);
                circle5.setCenterX(X5);circle5.setCenterY(Y5);circle5.setRadius(5);
                if(test5 == false){
                    graphe.getChildren().add(circle5);
                    test5 = true;
                }
            }
        }

        //**************************     Compt6     ***********************************
        if(!compt6.getText().equals("")) {
            if (Double.parseDouble(compt6.getText()) < 0 || Double.parseDouble(compt6.getText()) > 20){
                err = true;
            }
            else {
                double X6 = getXRadarChart(Double.parseDouble(compt6.getText()), 6);
                double Y6 = getYRadarChart(Double.parseDouble(compt6.getText()), 6);
                circle6.setCenterX(X6);circle6.setCenterY(Y6);circle6.setRadius(5);
                if(test6 == false){
                    graphe.getChildren().add(circle6);
                    test6 = true;
                }
            }
        }

        //****************************     Err     *************************************
        if(err == true){
            err = false;
            messErr.setText("Erreur de saisie : \n Les valeurs doivent etre entre 0 et 20");
        }
        else{
            messErr.setText("");
        }

    }
    @FXML
    public void Vide(){
        compt1.setText("");
        circle1.setRadius(0);

        compt2.setText("");
        circle2.setRadius(0);

        compt3.setText("");
        circle3.setRadius(0);

        compt4.setText("");
        circle4.setRadius(0);

        compt5.setText("");
        circle5.setRadius(0);

        compt6.setText("");
        circle6.setRadius(0);
    }


}
