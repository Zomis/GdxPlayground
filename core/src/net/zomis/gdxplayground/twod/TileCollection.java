package net.zomis.gdxplayground.twod;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Represents a collection of TwoDTiles.
 */
public class TileCollection implements Collection<TwoDTile> {

    private final Collection<TwoDTile> tiles;

    public TileCollection(Collection<TwoDTile> collection) {
        this.tiles = collection;
    }

    public static TileCollection set() {
        return new TileCollection(new HashSet<TwoDTile>());
    }

    public void withCollection(TileConsumer perform) {
        for (TwoDTile tile : tiles) {
            perform.perform(tile);
        }
    }

    public boolean add(TwoDTile tile) {
        return tiles.add(tile);
    }

    @Override
    public boolean addAll(Collection<? extends TwoDTile> collection) {
        return tiles.addAll(collection);
    }

    @Override
    public void clear() {
        tiles.clear();
    }

    @Override
    public boolean contains(Object o) {
        return tiles.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return tiles.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    @Override
    public Iterator<TwoDTile> iterator() {
        return tiles.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return tiles.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return tiles.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return tiles.retainAll(collection);
    }

    @Override
    public int size() {
        return tiles.size();
    }

    @Override
    public Object[] toArray() {
        return tiles.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return tiles.toArray(ts);
    }

}
