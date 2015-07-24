package net.zomis.gdxplayground.twod;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tile implements TwoDTile {

    private final int x;
    private final int y;
    private int value;
    private final TileConsumer onValueChange;
    private final Image image;

    public Tile(int x, int y, TileConsumer onValueChange) {
        this.x = x;
        this.y = y;
        this.onValueChange = onValueChange;
        this.image = new Image();
        setValue(0);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
        this.onValueChange.perform(this);
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Tile(" + x + ", " + y + ")";
    }
}
