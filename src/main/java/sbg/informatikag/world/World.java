package sbg.informatikag.world;

import sbg.informatikag.world.tiles.Tile;
import sbg.informatikag.Rectangle;
import sbg.informatikag.Vector2;
import sbg.informatikag.entities.actors.actions.Action;

public interface World {
    public Tile getTileOnTileMapLocation(Vector2 location);
    public WorldSlice getSlice(Rectangle sliceArea);
    public WorldBaseStats getBaseStats();
    public boolean executeAction(Action action);
    public void update();
}
