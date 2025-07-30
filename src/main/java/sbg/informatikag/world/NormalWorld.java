package sbg.informatikag.world;

import java.util.LinkedHashMap;

import sbg.informatikag.Rectangle;
import sbg.informatikag.Vector2;
import sbg.informatikag.world.tiles.FloorTile;
import sbg.informatikag.world.tiles.Tile;

public class NormalWorld implements World {

    LinkedHashMap<Vector2, Tile> tileMap;

    public NormalWorld(Vector2 bound) {
        this.tileMap = new LinkedHashMap<Vector2, Tile>();
        for (int y = 0; y < bound.getY(); y++) {
            for (int x = 0; x < bound.getX(); x++) {
                this.tileMap.put(new Vector2(x, y), new FloorTile(null));
            }
        }
    }

    @Override
    public Tile getTileOnTileMapLocation(Vector2 location) {
        return this.tileMap.get(location);
    }

    @Override
    public WorldSlice getSlice(Rectangle sliceArea) {
        return new WorldSlice(this, sliceArea);
    }

}
