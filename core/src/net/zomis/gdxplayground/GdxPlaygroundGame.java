package net.zomis.gdxplayground;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GdxPlaygroundGame extends Game {
	SpriteBatch batch;
    Texture img;
    Drawable imgDraw;
    Stage stage;
    Drawable[] drawables = new Drawable[5];
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        imgDraw = new TextureRegionDrawable(new TextureRegion(img));
        for (int i = 0; i < drawables.length; i++) {
            drawables[i] = new TextureRegionDrawable(new TextureRegion(new Texture("verified/v" + (i + 1) + ".png")));
        }
        stage = new Stage();
        setScreen(new MapGenScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
/*		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
        stage.draw();
	}
}
