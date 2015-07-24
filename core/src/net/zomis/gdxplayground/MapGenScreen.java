package net.zomis.gdxplayground;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.MathUtils;
import net.zomis.gdxplayground.twod.*;
import net.zomis.gdxplayground.twod.tools.FindIslands;
import net.zomis.gdxplayground.twod.tools.PerlinNoiseGenerator;

import java.util.List;

public class MapGenScreen implements Screen, TileConsumer {

    private final GdxPlaygroundGame game;
    private final TileMap map;

    public MapGenScreen(GdxPlaygroundGame game) {
        this.game = game;
        this.map = new TileMap(40, 40, this);

        MathUtils.random.setSeed(42);

        float[][] floatMap = PerlinNoiseGenerator.generatePerlinNoise(map.getWidth(), map.getHeight(), 4);
        int[][] intMap = perlinNoiseToIntMap(floatMap);
        this.setValues(map, intMap);
        postHandle();

    }

    private void setValues(TileMap map, int[][] intMap) {
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                map.getTile(x, y).setValue(intMap[y][x]);
            }
        }
    }

    private void postHandle() {
        List<TileCollection> islands = FindIslands.findIslands(map);
        for (TileCollection collection : islands) {
            if (collection.size() < 10) {
                collection.withCollection(new TileConsumer() {
                    @Override
                    public void perform(TwoDTile tile) {
                        Gdx.app.log(tile.toString(), tile.toString());
                        tile.setValue(1 - tile.getValue());
                    }
                });
            }
        }
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
        if (v < 0.5f) {
            return 0;
        }
        if (v < 0.75f) {
            return 1;
        }
        return 1;
    }

    @Override
    public void show() {
        game.stage.addActor(map.getTable());
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
        map.getTable().remove();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void perform(TwoDTile tile) {
        Tile t = (Tile) tile;
        t.getImage().setDrawable(game.drawables[t.getValue()]);
    }
}
