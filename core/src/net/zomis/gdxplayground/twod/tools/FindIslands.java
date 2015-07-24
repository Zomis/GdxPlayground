package net.zomis.gdxplayground.twod.tools;

import net.zomis.gdxplayground.twod.TileCollection;
import net.zomis.gdxplayground.twod.TwoDMap;
import net.zomis.gdxplayground.twod.TwoDTile;

import java.util.ArrayList;
import java.util.List;

public class FindIslands {

    public static List<TileCollection> findIslands() {
        List<TileCollection> result = new ArrayList<TileCollection>();
        TileCollection.set();
        return result;
    }

    private void floodFill(TwoDMap intMap, TileCollection collection, int x, int y) {
        if (y < 0 || y >= intMap.getHeight()) {
            return;
        }
        if (x < 0 || x >= intMap.getWidth()) {
            return;
        }
        TwoDTile tile = intMap.getTile(x, y);
        if (tile.getValue() < 0) {
            return;
        }
        tile.setValue(-tile.getValue() - 1);
        collection.add(tile);
        floodFill(intMap, collection, x - 1, y);
        floodFill(intMap, collection, x + 1, y);
        floodFill(intMap, collection, x, y - 1);
        floodFill(intMap, collection, x, y + 1);

    }

}
