package sbg.informatikag.world;

import sbg.informatikag.world.tiles.Tile;
import sbg.informatikag.Rectangle;
import sbg.informatikag.Vector2;

public interface World {
    public Tile getTileOnTileMapLocation(Vector2 location);
    public WorldSlice getSlice(Rectangle sliceArea);
}
