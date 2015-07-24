package net.zomis.gdxplayground.twod;

public interface TwoDMap {

    int getWidth();
    int getHeight();

    Tile getTile(int x, int y);
}
