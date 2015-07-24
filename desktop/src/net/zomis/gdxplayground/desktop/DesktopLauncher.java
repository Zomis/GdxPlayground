package net.zomis.gdxplayground.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.zomis.gdxplayground.GdxPlaygroundGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1000;
        config.height = (int) (config.width * (6f / 8f));
		new LwjglApplication(new GdxPlaygroundGame(), config);
	}
}
