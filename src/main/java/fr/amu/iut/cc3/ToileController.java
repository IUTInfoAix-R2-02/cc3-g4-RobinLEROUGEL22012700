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

    private TextField[] ListText = {compt1,compt2};

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
        double X1 = getXRadarChart(Double.parseDouble(compt1.getText()),1);
        double Y1 = getYRadarChart(Double.parseDouble(compt1.getText()),1);
        graphe.getChildren().add(new Circle(X1,Y1,5));

        //**************************     Compt2     ***********************************
        double X2 = getXRadarChart(Double.parseDouble(compt2.getText()),2);
        double Y2 = getYRadarChart(Double.parseDouble(compt2.getText()),2);
        graphe.getChildren().add(new Circle(X2,Y2,5));

        //**************************     Compt3     ***********************************
        double X3 = getXRadarChart(Double.parseDouble(compt3.getText()),3);
        double Y3 = getYRadarChart(Double.parseDouble(compt3.getText()),3);
        graphe.getChildren().add(new Circle(X3,Y3,5));

        //**************************     Compt4     ***********************************
        double X4 = getXRadarChart(Double.parseDouble(compt4.getText()),4);
        double Y4 = getYRadarChart(Double.parseDouble(compt4.getText()),4);
        graphe.getChildren().add(new Circle(X4,Y4,5));

        //**************************     Compt5     ***********************************
        double X5 = getXRadarChart(Double.parseDouble(compt5.getText()),5);
        double Y5 = getYRadarChart(Double.parseDouble(compt5.getText()),5);
        graphe.getChildren().add(new Circle(X5,Y5,5));

        //**************************     Compt6     ***********************************
        double X6 = getXRadarChart(Double.parseDouble(compt6.getText()),6);
        double Y6 = getYRadarChart(Double.parseDouble(compt6.getText()),6);
        graphe.getChildren().add(new Circle(X6,Y6,5));


    }
    @FXML
    public void Vide(){
    }


}
