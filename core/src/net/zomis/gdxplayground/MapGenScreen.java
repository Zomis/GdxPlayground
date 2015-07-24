package net.zomis.gdxplayground;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MapGenScreen implements Screen {

    private final GdxPlaygroundGame game;
    private final Table table;
    private final Image[][] imgs = new Image[40][40];

    public MapGenScreen(GdxPlaygroundGame game) {
        this.game = game;
        this.table = new Table();
        table.setFillParent(true);

        MathUtils.random.setSeed(42);

        float[][] map = PerlinNoiseGenerator.generatePerlinNoise(imgs.length, imgs[0].length, 4);
        int[][] intMap = perlinNoiseToIntMap(map);
        postHandle(intMap);

        for (int y = 0; y < imgs.length; y++) {
            for (int x = 0; x < imgs[y].length; x++) {
                Image img = new Image();
                int i = intMap[y][x];
                img.setDrawable(game.drawables[i]);
                imgs[y][x] = img;
                table.add(img);
            }
            table.row();
        }
    }

    private void postHandle(int[][] intMap) {
        createIslands(intMap);
    }

    private void createIslands(int[][] intMap) {
        for (int y = 0; y < intMap.length; y++) {
            for (int x = 0; x < intMap[y].length; x++) {
                int i = intMap[y][x];

            }
        }
    }

    private void createIsland(int[][] intMap, int y, int x) {
        if (y < 0 || y >= intMap.length) {
            return;
        }
        if (x < 0 || x >= intMap[0].length) {
            return;
        }
        if (intMap[y][x] < 0) {
            return;
        }
        intMap[y][x] = - intMap[y][x] - 1;
        createIsland(intMap, y - 1, x);
        createIsland(intMap, y + 1, x);
        createIsland(intMap, y, x - 1);
        createIsland(intMap, y, x + 1);
    }

    private int[][] perlinNoiseToIntMap(float[][] map) {
        int[][] result = new int[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                result[y][x] = mapToI(map[y][x]);
            }
        }
        return result;
    }

    private int mapToI(float v) {
        if (v < 0.2f) {
            return 0;
        }
        if (v < 0.6f) {
            return 0;
        }
        if (v < 0.8f) {
            return 1;
        }
        return 1;
    }

    @Override
    public void show() {
        game.stage.addActor(table);
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        table.remove();
    }

    @Override
    public void dispose() {

    }

}
