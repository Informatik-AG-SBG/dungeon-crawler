package sbg.informatikag.world;

import sbg.informatikag.Rectangle;
import sbg.informatikag.Vector2;
import sbg.informatikag.world.tiles.Tile;

public class WorldSlice implements World {

    World world;
    Rectangle visibleArea;

    public WorldSlice(World world, Rectangle visibleArea) {
        this.world = world;
        this.visibleArea = visibleArea;
    }

    @Override
    public Tile getTileOnTileMapLocation(Vector2 location) {
        if (!location.collides(this.visibleArea)) {
            return null;
        }

        return this.world.getTileOnTileMapLocation(location);
    }

    @Override
    public WorldSlice getSlice(Rectangle sliceArea) {
        return new WorldSlice(this, sliceArea);
    }
}
