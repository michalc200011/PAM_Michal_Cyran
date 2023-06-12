package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    private static final int grav=-15;
    private static final int mov=100;
    private Vector2 position;
    private Vector2 velocity;
    private Texture bird;
    private Rectangle bounds;
    public Bird(float x, float y){
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        bird = new Texture("Bird.png");
        bounds = new Rectangle(x,y, (float) (bird.getWidth()*0.7), (float) (bird.getHeight()*0.7));

    }

    public void update(float dt){
        if(position.y>0) velocity.add(0,grav);
        velocity.scl(dt);
        position.add(mov * dt,velocity.y);
        if(position.y < 0) position.y=0;
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }
    public void jump(){
        velocity.y = Gdx.graphics.getHeight()/8;

    }
    public Rectangle getBounds(){
        return bounds;
    }
}
