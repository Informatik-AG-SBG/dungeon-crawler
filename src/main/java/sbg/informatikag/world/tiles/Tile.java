package sbg.informatikag;

import sbg.informatikag.entities.Entity;

public interface Tile {
    public Entity getEntityOnTile();

    public void setEntityOnTile(Entity entityOnTile);
}
