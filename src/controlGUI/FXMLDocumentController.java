/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author hector_fabio.romero
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas lienzo;
    
    //Permite tener todo lo necesario para pintar en el canvas
    GraphicsContext g;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        // Le damos un color al canva
        g.setStroke(Color.BLUE);
        g.setLineWidth(3);  // Grosor de la línea
        g.strokeOval(200, 200, 40, 40);    // Creamos un rectángulo con las coordenadas dadas
        g.setFill(Color.CHOCOLATE);
        g.fillOval(200, 200, 40, 40);
        
        
    }
    
    @FXML
    private void crearCuadrado(){
        g.setStroke(Color.BURLYWOOD);
        g.setLineWidth(10);  // Grosor de la línea
        g.strokeRect(300, 300, 60, 60);    // Creamos un rectángulo con las coordenadas dadas
        g.setFill(Color.CRIMSON);
        g.fillRect(300, 300, 60, 60);
        
  
        g.setFill(Color.CRIMSON);
        g.fillRect(500, 300, 60, 60);
        
        
    }
    
    @FXML
    private void crearTriangulo(){
        double x1[] = {40,450,560};
        double y1[] = {200,100,200};
        
        g.setStroke(Color.CADETBLUE);
        g.setLineWidth(2);
        g.strokePolygon(x1, y1, 3);
        
        
        
//        g.setStroke(Color.DARKBLUE);
//        g.setLineWidth(7);  // Grosor de la línea
//        g.stroke(200, 200, 40, 40);    // Creamos un rectángulo con las coordenadas dadas
//        g.setFill(Color.CHOCOLATE);
//        g.fillOval(200, 200, 40, 40);
        
    }
    
    @FXML
    private void crearRectangulo(){
        
        g.setStroke(Color.MAGENTA);
        g.setLineWidth(10);  // Grosor de la línea
        g.strokeRect(100, 100, 60, 20);    // Creamos un rectángulo con las coordenadas dadas
        g.setFill(Color.CRIMSON);
        g.fillRect(100, 100, 60, 20);
        
        g.setLineWidth(0);
//        g.strokeRect(300, 100, 60, 60);    
        g.setFill(Color.TEAL);
        g.fillRect(300, 100, 60, 20);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Permite indicar al graficContext que pinte en el lienzo que hemos creado
        g = lienzo.getGraphicsContext2D();
        
        //Delimitamos el área que podremos pintar. Para eso, obtenemos el largo y ancho del canva que vamos a usar:
        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();
        
        // Le damos un color al canva
        g.setStroke(Color.AQUAMARINE);
        g.setLineWidth(3);  // Grosor de la línea
        g.strokeRect(0, 0, largo, alto);    // Creamos un rectángulo con las coordenadas dadas
                
                
                
    }    
    
}
