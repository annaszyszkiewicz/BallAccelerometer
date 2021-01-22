package edu.ib.lista14zpo2020;

import android.graphics.Paint;
import android.view.View;

/**
 * klasa opisujaca pilke
 */
public class Ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double radius;
    private View view;
    private Paint paint;

    /**
     * konstruktor tworzacy pilke
     *
     * @param view   widok aplikacji
     * @param x      polozenie pilki w plaszczyznie x
     * @param y      polozenie pilki w plaszczyznie y
     * @param radius promien pilki
     * @param paint  odpowiada za kolor pilki
     */
    public Ball(View view, double x, double y, double radius, Paint paint) {
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.ax = 0;
        this.ay = 0;
        this.radius = radius;
        this.view = view;
        this.paint = paint;
    }

    /**
     * metoda odpowiadajaca za zasady fizyki w aplikacji
     * by kulka nie wyszla za ekran
     * by kulka odbijala się od granic ekranu z odpowiednia predkoscia
     */
    public void calculate() {
        vx += ax;
        if (vx > 50) vx = 50;
        if (vx < -50) vx = -50;
        vy += ay;
        if (vy > 50) vy = 50;
        if (vy < -50) vy = -50;
        x += vx;
        if (x < radius) {
            x = radius;
            vx *= -0.8;
        }
        if (x > view.getWidth() - radius) {
            x = view.getWidth() - radius;
            vx *= -0.8;
        }
        y += vy;
        if (y < radius) {
            y = radius;
            vy *= -0.8;
        }
        if (y > view.getHeight() - radius) {
            y = view.getHeight() - radius;
            vy *= -0.8;
        }
    }

    public Paint getPaint() {
        return paint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }
}
