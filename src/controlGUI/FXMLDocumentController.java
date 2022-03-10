/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlGUI;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Punto2D;

/**
 *
 * @author hector_fabio.romero
 * @author felipe.aristizabal_m
 */
public class FXMLDocumentController implements Initializable {

    // Se definen para cualquier figura geométrica
    double x1[];
    double y1[];
    // Coordenadas iniciales de x y Y
    double coorX;
    double coorY;

    LinkedList<Punto2D> listaPuntos;
    HashMap<String, LinkedList<Punto2D>> ejemploMap;

    @FXML
    private Canvas lienzo;

    @FXML
    private TextField txtCantidad_lados;

    @FXML
    private Label labelRadio;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Label labelNumLados;

    @FXML
    private TextField txtRadio;
    //Permite tener todo lo necesario para pintar en el canvas
    GraphicsContext g;

    @FXML
    private void crearCirculo(ActionEvent event) {

        // Le damos un color al canva
        g.setStroke(Color.BLUE);
        g.setLineWidth(3);  // Grosor de la línea
        g.strokeOval(200, 200, 40, 40);    // Creamos un rectángulo con las coordenadas dadas
        g.setFill(Color.CHOCOLATE);
        g.fillOval(200, 200, 40, 40);

    }

    @FXML
    private void crearCuadrado() {
        g.setStroke(Color.BURLYWOOD);
        g.setLineWidth(10);  // Grosor de la línea
        g.strokeRect(300, 300, 60, 60);    // Creamos un rectángulo con las coordenadas dadas
        g.setFill(Color.CRIMSON);
        g.fillRect(300, 300, 60, 60);

        g.setFill(Color.CRIMSON);
        g.fillRect(500, 300, 60, 60);

    }

    @FXML
    private void crearTriangulo() {
//        double x1[] = {40,450,560};
//        double y1[] = {200,100,200};
//        
//        g.setStroke(Color.CADETBLUE);
//        g.setLineWidth(2);
//        g.strokePolygon(x1, y1, 3);

//        g.setStroke(Color.DARKBLUE);
//        g.setLineWidth(7);  // Grosor de la línea
//        g.stroke(200, 200, 40, 40);    // Creamos un rectángulo con las coordenadas dadas
//        g.setFill(Color.CHOCOLATE);
//        g.fillOval(200, 200, 40, 40);
    }

    @FXML
    private void crearRectangulo() {

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

    @FXML
    private void crearPoligonoRegular(ActionEvent event) {

        listaPuntos = new LinkedList<>();
        //Obtiene el radio que el usuario escoja en un textArea.
        int r = Integer.parseInt(txtRadio.getText());

        //Sirve para obtener el color que el usuario quiere escoger en la interfaz gráfica.
        g.setStroke(colorPicker.getValue());

        // Obtiene el número de lados que el usuario quiere digitar en la interfaz gráfica.
        int numLados = Integer.parseInt(txtCantidad_lados.getText());

        // Dividimos entre  2PI el número de lados que tendrá nuestro polígono regular.
        double angulo = (2 * Math.PI) / numLados;
        // Nuestro centro estará dado por las coordenadas (k,h), donde k representará la posición en Y y h la posición en X.
        double h = coorX;
        double k = coorY;
        x1 = new double[numLados];
        y1 = new double[numLados];
        x1[0] = h + r;
        y1[0] = k;
//        Punto2D puntoInical = new Punto2D(x1[0], y1[0]);
//        listaPuntos.add(puntoInical);
        System.out.println("Coordenada: 0" + "x: " + x1[0] + ", y: " + y1[0]);

        for (int i = numLados - 1; i > 0; i--) {
            double a = r * Math.sin(angulo * i);
            double b = r * Math.cos(angulo * i);

            // Hallamos los catetos de un tríangulo de radio r y sumamos las distancias del centro a dichas
            // coordenadas para ubicar un punto a teta angulos en la circunferencia
            x1[i] = b + h;
            y1[i] = a + k;
            System.out.println("Coordenada: " + i + "x: " + x1[i] + "y: " + y1[i]);

        }
        Punto2D puntito = new Punto2D(x1[0], y1[0]);
        listaPuntos.add(puntito);
        for (int i = 1; i < x1.length; i++) {
            Punto2D punto = new Punto2D(x1[i], y1[i]);
            listaPuntos.addLast(punto);

        }
        if (listaPuntos.size() == 5) {
            ejemploMap.put("Pentágono", listaPuntos);
        }
        if (listaPuntos.size() == 6) {
            ejemploMap.put("Hexágono", listaPuntos);
        }        
        
        // Creamos el polígono con base en las coordenadas ya halladas anteriormente.
        g.strokePolygon(x1, y1, numLados);
        g.setLineWidth(3);

        System.out.println(listaPuntos.toString());

    }
    
    
    @FXML
    private void asignarValores(ActionEvent event) {
        // Agregamos a la estructura de datos valores y claves.
        // La clave ha de ser única para cada valor.
//        ejemploMap.put(10, "David");
//        ejemploMap.put(1, "Sofia");
//        ejemploMap.put(87, "Antonio");
//        ejemploMap.put(9, "Carlos");
//        ejemploMap.put(63, "Maria");
        
        // Caracterizamos al iterador
        Iterator<Map.Entry<String,LinkedList<Punto2D>>> entries = ejemploMap.entrySet().iterator();
        
        while (entries.hasNext()) {            
            Map.Entry<String,LinkedList<Punto2D>> entry = entries.next();
            System.out.println(entry.getKey());
            
            for (int i = 0; i < entry.getValue().size(); i++) {
                Punto2D get = listaPuntos.get(i);
                System.out.println("Puntos: " + get.toString() + "\n");
            }
            
            
        }
        
        
        
    }
    

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
//        // Obtenemos las coordenadas x y y del mouse cuando hacemos un click dentro del click
        coorX = event.getX();
        coorY = event.getY();
//        
//        Punto2D punto = new Punto2D(x, y);
//        System.out.println(punto.toString());
//        
//        g.setStroke(Color.BLUE);
//        g.setLineWidth(3);  // Grosor de la línea
//        g.strokeOval(x, y, 200, 200);
//        g.setFill(Color.CHOCOLATE);
//        g.fillOval(x, y, 200, 200);
        System.out.println("El punto " + coorX + ", " + coorY);

    }

    @FXML
    private void pintarMouse(MouseEvent event) {
//        // Obtenemos las coordenadas x y y del mouse cuando hacemos un click dentro del click
//        coorX= event.getX();
//        coorY = event.getY();
//        
//        Punto2D punto = new Punto2D(coorX, coorY);
//        System.out.println(punto.toString());
//        
////        g.setStroke(Color.BLUE);
////        g.setLineWidth(3);  // Grosor de la línea
////        g.strokeOval(x, y, 100, 100);
//        g.setFill(Color.LIGHTBLUE);
//        g.fillOval(coorX, coorY, 50, 50);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Creación del HashMap
        ejemploMap = new HashMap<>();
        
        // Permite indicar al graficContext que pinte en el lienzo que hemos creado
        g = lienzo.getGraphicsContext2D();

        //Delimitamos el área que podremos pintar. Para eso, obtenemos el largo y ancho del canva que vamos a usar:
        double alto = lienzo.getHeight();
        double largo = lienzo.getWidth();

        // Le damos un color al canva
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);  // Grosor de la línea
        g.strokeRect(0, 0, largo, alto);    // Creamos un rectángulo con las coordenadas dadas    
    }

}
