package net.zomis.gdxplayground.twod.tools;

import net.zomis.gdxplayground.twod.*;

import java.util.ArrayList;
import java.util.List;

public class FindIslands {

    public static List<TileCollection> findIslands(TileMap map) {
        List<TileCollection> result = new ArrayList<TileCollection>();
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Tile tile = map.getTile(x, y);
                boolean exists = existsInAny(tile, result);
                if (!exists) {
                    TileCollection collection = TileCollection.set();
                    result.add(collection);
                    floodFill(map, collection, tile.getValue(), x, y);
                }
            }
        }
        return result;
    }

    private static boolean existsInAny(Tile tile, List<TileCollection> result) {
        for (TileCollection collection : result) {
            if (collection.contains(tile)) {
                return true;
            }
        }
        return false;
    }

    private static void floodFill(TwoDMap intMap, TileCollection collection, int value, int x, int y) {
        if (y < 0 || y >= intMap.getHeight()) {
            return;
        }
        if (x < 0 || x >= intMap.getWidth()) {
            return;
        }
        TwoDTile tile = intMap.getTile(x, y);
        if (tile.getValue() != value) {
            return;
        }
        if (!collection.add(tile)) {
            return;
        }
        floodFill(intMap, collection, value, x - 1, y);
        floodFill(intMap, collection, value, x + 1, y);
        floodFill(intMap, collection, value, x, y - 1);
        floodFill(intMap, collection, value, x, y + 1);

    }

}
