package net.zomis.gdxplayground.twod;

import net.zomis.gdxplayground.twod.Tile;
import net.zomis.gdxplayground.twod.TwoDMap;

public class TileMap implements TwoDMap {

    private int width;
    private int height;
    private Tile[][] tiles;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    @Override
    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

}
