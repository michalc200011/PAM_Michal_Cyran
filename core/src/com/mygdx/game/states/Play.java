package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Logs;

public class Play extends State{
    private static final int logs_spacing = Gdx.graphics.getWidth()/2;
    private static final int logs_count = 4;
    private Texture background;
    private Bird bird;

    private Array<Logs> logs;
    public Play(GameStateManager gsm) {
        super(gsm);
        bird=new Bird(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/3);
        background = new Texture("Background.png");

        cam.setToOrtho(false, Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/6,Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/6);
        logs = new Array<Logs>();
        for(int i=1;i<=logs_count;i++){logs.add(new Logs(i*logs_spacing+Logs.width/2));}
    }

    @Override
    protected void inputEvents() {

        if(Gdx.input.isTouched()){

            bird.jump();
        }

    }

    @Override
    public void update(float dt) {
        inputEvents();
        bird.update(dt);
        cam.position.x = bird.getPosition().x+80;
        for(Logs log : logs){
            if(cam.position.x-(cam.viewportWidth/2)>log.getPosTopLog().x+Logs.width/4){
                log.reposition(log.getPosTopLog().x + ((logs_spacing )*logs_count));
            }
            if(log.collides((bird.getBounds()))){gsm.set(new Play(gsm));}
            if(bird.getPosition().y<=0){gsm.set(new Play(gsm));}
            if(bird.getPosition().y-bird.getTexture().getHeight()*1.2>Gdx.graphics.getHeight()/2){gsm.set(new Play(gsm));}

        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,cam.position.x-(cam.viewportWidth/2),0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());//rysowanie tła w lewym dolnym rogu
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        for(Logs log:logs) {
            sb.draw(log.getTopLog(), log.getPosTopLog().x, log.getPosTopLog().y);
            sb.draw(log.getBotLog(), log.getPosBotLog().x, log.getPosBotLog().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
    }
}
