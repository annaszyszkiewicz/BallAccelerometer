package edu.ib.lista14zpo2020;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * rozszerzenie widoku
 */
public class BallView extends View {

    private int viewWidth;
    private int viewHeight;
    Ball ball;

    /**
     * kontruktor tworzacy widok
     *
     * @param context konteks
     */
    public BallView(Context context) {
        super(context);
        Paint ballPaint = new Paint();
        ballPaint.setColor(Color.MAGENTA);
        ball = new Ball(this, 0, 0, 50, ballPaint);
    }

    public Ball getBall() {
        return ball;
    }

    public int getViewWidth() {
        return viewWidth;
    }

    public int getViewHeight() {
        return viewHeight;
    }

    /**
     * metoda wykonujaca sie przy zmianie romiaru okna
     * ustawia pozycje kulki na srodku ekranu
     *
     * @param w    nowa szerokosc okna
     * @param h    nowa wysokosc okna
     * @param oldw stara szerokosc okna
     * @param oldh stara wysokosc okna
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewWidth = w;
        viewHeight = h;
        ball.setX(viewWidth / 2);
        ball.setY(viewHeight / 2);
    }

    /**
     * metoda rysujaca kulke
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ball.calculate();
        canvas.drawCircle((float) ball.getX(), (float) ball.getY(), (float) ball.getRadius(), ball.getPaint());
        invalidate();
    }
}
