package sbg.informatikag.world.tiles;

import sbg.informatikag.entities.Entity;

public class FloorTile implements Tile {

    Entity entityOnTile;

    @Override
    public Entity getEntityOnTile() {
        return entityOnTile;
    }

    @Override
    public void setEntityOnTile(Entity entityOnTile) {
        this.entityOnTile = entityOnTile;
    }

    public FloorTile(Entity entityOnTile) {
        this.setEntityOnTile(entityOnTile);
    }

}
