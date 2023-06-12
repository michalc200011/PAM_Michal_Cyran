package com.mygdx.game.states;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;//Camera w grze
    protected Vector3 mouse;//Myszka
    protected GameStateManager gsm;//Obsługa stanów gry
    //Konstruktor Stanu gry w zależności od danego stanu
    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void inputEvents();//Wejściowe Eventy
    public abstract void update(float dt);//aktualizowanie stanu
    public abstract void render(SpriteBatch sb);//renderowanie rzeczy
    public abstract void dispose();
}
