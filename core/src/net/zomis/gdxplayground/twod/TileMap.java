package net.zomis.gdxplayground.twod;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TileMap implements TwoDMap {

    private final Table table;
    private int width;
    private int height;
    private Tile[][] tiles;

    public TileMap(int width, int height, TileConsumer onValueChange) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        this.table = new Table();
        table.setFillParent(true);

        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                Tile tile = new Tile(x, y, onValueChange);
                this.tiles[y][x] = tile;
                table.add(tile.getImage());
            }
            table.row();
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    public Table getTable() {
        return table;
    }
}
