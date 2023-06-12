package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends State{
    private Texture background;
    private Texture playButton;
    //konstruktor Menu dziedziczący konstruktor z State
    public Menu(GameStateManager gsm){
        super(gsm);
        background = new Texture("Background.png");
        playButton = new Texture("play_button.png");
    }

    @Override
    public void inputEvents() {
        if(Gdx.input.justTouched()){
            gsm.set(new Play(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        inputEvents();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());//rysowanie tła w lewym dolnym rogu
        sb.draw(playButton,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/3+Gdx.graphics.getHeight()/9,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/10);//rysowanie przycisku w centrum
        sb.end();
    }
    @Override
    public void dispose(){
        background.dispose();
        playButton.dispose();
    }


}
