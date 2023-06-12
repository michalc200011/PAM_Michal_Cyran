package com.mygdx.game.sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;


public class Logs {
    public static final int width=295;
    public static final int height=1090;
    private static final int gap = Gdx.graphics.getHeight()/5+50;
    private static final int fluc = height*2/3;
    private static final int low_op = height*1/3;
    private Texture topLog,botLog;
    private Vector2 posTopLog;
    private Vector2 posBotLog;
    private Rectangle boundsTop,boundsBot;
    private Random rand;

    public Logs(float x){
        topLog = new Texture("Log.png");
        botLog = new Texture("Log.png");
        rand=new Random();
        posTopLog = new Vector2(x, rand.nextInt(fluc)+gap+low_op);
        posBotLog = new Vector2(x, posTopLog.y - gap - height);
        boundsTop= new Rectangle(posTopLog.x, posTopLog.y, (float) (width*0.8),height);
        boundsBot= new Rectangle(posBotLog.x, posBotLog.y, (float) (width*0.8),height);

    }

    public Texture getTopLog() {
        return topLog;
    }

    public Texture getBotLog() {
        return botLog;
    }

    public Vector2 getPosTopLog() {
        return posTopLog;
    }

    public Vector2 getPosBotLog() {
        return posBotLog;
    }

    public void reposition(float x){
        posTopLog.set(x, rand.nextInt(fluc)+gap+low_op);
        posBotLog.set(x, posTopLog.y - gap - height);
        boundsTop.setPosition(posTopLog.x, posTopLog.y);
        boundsBot.setPosition(posBotLog.x, posBotLog.y);
    }
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }
}
