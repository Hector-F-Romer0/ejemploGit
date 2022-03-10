/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author hector_fabio.romero
 */
public class Punto2D {
    
    private double X;
    private double Y;

    public Punto2D() {
    }

    public Punto2D(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public double getY() {
        return Y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(double Y) {
        this.Y = Y;
    }


    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public double getX() {
        return X;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(double X) {
        this.X = X;
    }

    @Override
    public String toString() {
        return  "x: " + X + ", y: " + Y;
    }

}
