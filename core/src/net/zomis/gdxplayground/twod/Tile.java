package net.zomis.gdxplayground.twod;

import net.zomis.gdxplayground.twod.TwoDTile;

public class Tile implements TwoDTile {

    private int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

}
