package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.SchoolBoyRun;
import com.mygdx.game.sprites.Boy;
import com.mygdx.game.sprites.Obstacle;

/**
 * Created by JUAN_work on 05/02/2018.
 */

public class GameoverState extends State {

    private static final int GROUND_Y_OFFSET = -50;
    BitmapFont bitmapFont;
    private int scoreDef;
    private String scoreName;
    private Texture bg;


    public GameoverState(GameStateManager gsm, int score) {
        super(gsm);
        scoreDef = score;
        scoreName = "score: " + score;
        bitmapFont = new BitmapFont();
        bg = new Texture("bg.png");
        cam.setToOrtho(false, (SchoolBoyRun.WIDTH/2 - 60), (SchoolBoyRun.HEIGHT - 40));
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2),0);
        sb.draw(bg, cam.position.x - (cam.viewportWidth/5),0);
        bitmapFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        bitmapFont.draw(sb, scoreName, cam.position.x + (cam.viewportWidth/4),cam.position.y + (cam.viewportHeight/3));
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
