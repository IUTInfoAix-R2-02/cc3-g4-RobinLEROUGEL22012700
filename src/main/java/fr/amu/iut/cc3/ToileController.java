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
import javafx.scene.paint.Color;
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
    private Line[] TabLine = new Line[6];
    private double[][] Tabcoord = new double[7][2];

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
        VideTab();//initialise les valeurs du tableau a 0 pour effacer les lignes en cas de changement de valeurs
        TracePoint();//Trace Les points
        MessageErreure(); // affiche un message d'erreure si une valeur saisie est <20 ou >0
        TraceLine(); // trace les lignes entre les points
    }
    
    @FXML
    public void Vide(){
        RemoveCircle(); // Réduit le rayon du cercle a 0 afin e ne plus l'afficher
        VideTab();//initialise les valeurs du tableau a 0 pour effacer les lignes en cas de changement de valeurs
    }

    @FXML
    public void actChamp(){
        Trace(); //retrace en cas de changement d'une des valeurs
    }

    public void TraceLine(){
        for(int i = 0;i < Tabcoord.length-1;++i) {
            if (!(Tabcoord[i][0] == 0) && !(Tabcoord[i + 1][0] == 0)) {
                Line line = new Line(Tabcoord[i][0], Tabcoord[i][1], Tabcoord[i + 1][0], Tabcoord[i + 1][1]);
                TabLine[i] = line;
                graphe.getChildren().add(line);
            }
        }
    }
    public void VideTab(){

        for(int i = 0;i < Tabcoord.length-1;++i){
            Tabcoord[i][0] = 0;
            Tabcoord[i][1] = 0;
        }

        for(int i = 0;i < TabLine.length;++i){
            if(!(TabLine[i] == null)) {
                TabLine[i].setStartX(0);
                TabLine[i].setStartY(0);
                TabLine[i].setEndX(0);
                TabLine[i].setEndY(0);
            }
        }
    }
    public void RemoveCircle(){
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
    public void MessageErreure(){
        if(err == true){
            err = false;
            messErr.setText("Erreur de saisie : \n Les valeurs doivent etre entre 0 et 20");
        }
        else{
            messErr.setText("");
        }
    }
    public void TracePoint(){
        //**************************     Compt1     ***********************************
        if(!compt1.getText().equals("")) {
            if (Double.parseDouble(compt1.getText()) < 0 || Double.parseDouble(compt1.getText()) > 20){
                err = true;
            }
            else {
                double X1 = getXRadarChart(Double.parseDouble(compt1.getText()), 1);
                double Y1 = getYRadarChart(Double.parseDouble(compt1.getText()), 1);
                Tabcoord[0][0] = X1;
                Tabcoord[0][1] = Y1;
                System.out.println(""+X1+" "+Y1);
                Tabcoord[6][0] = X1;
                Tabcoord[6][1] = Y1;
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
                Tabcoord[1][0] = X2;
                Tabcoord[1][1] = Y2;
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
                Tabcoord[2][0] = X3;
                Tabcoord[2][1] = Y3;
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
                Tabcoord[3][0] = X4;
                Tabcoord[3][1] = Y4;
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
                Tabcoord[4][0] = X5;
                Tabcoord[4][1] = Y5;
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
                Tabcoord[5][0] = X6;
                Tabcoord[5][1] = Y6;

                circle6.setCenterX(X6);circle6.setCenterY(Y6);circle6.setRadius(5);
                if(test6 == false){
                    graphe.getChildren().add(circle6);
                    test6 = true;
                }
            }
        }
    }
}
