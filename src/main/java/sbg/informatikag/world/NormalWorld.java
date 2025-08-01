package sbg.informatikag.world;

import java.util.LinkedHashMap;
import java.util.Vector;

import sbg.informatikag.Rectangle;
import sbg.informatikag.Vector2;
import sbg.informatikag.entities.Entity;
import sbg.informatikag.entities.EntityFightingSystem;
import sbg.informatikag.entities.actors.Actor;
import sbg.informatikag.entities.actors.actions.Action;
import sbg.informatikag.world.tiles.FloorTile;
import sbg.informatikag.world.tiles.Tile;

public class NormalWorld implements World {

    LinkedHashMap<Vector2, Tile> tileMap;
    WorldBaseStats baseStats;
    Vector2 worldBounds;

    public NormalWorld(Vector2 bound, WorldBaseStats baseStats) {
        this.tileMap = new LinkedHashMap<Vector2, Tile>();
        this.worldBounds = bound;
        for (int y = 0; y < this.worldBounds.getY(); y++) {
            for (int x = 0; x < this.worldBounds.getX(); x++) {
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

    public WorldBaseStats getBaseStats() {
        return this.baseStats;
    }

    @Override
    public boolean executeAction(Action action) {
        switch (action) {
            case Action.MoveAction ma -> {
                Vector2 startTileLocation = ma.entityTileMapLocation();
                Vector2 targetTileLocation = new Vector2(startTileLocation.getX() + ma.xChange(),
                        startTileLocation.getY() + ma.yChange());
                Tile targetTile = this.tileMap.get(targetTileLocation);
                if (targetTile.getEntityOnTile() == null) {
                    this.tileMap.get(targetTileLocation).setEntityOnTile(this.tileMap.get(startTileLocation).getEntityOnTile());
                    this.tileMap.get(startTileLocation).setEntityOnTile(null);
                    return true;
                }
                if (this.executeAction(new Action.FightAction(startTileLocation, targetTileLocation))) {
                    this.tileMap.get(targetTileLocation).setEntityOnTile(this.tileMap.get(startTileLocation).getEntityOnTile());
                    this.tileMap.get(startTileLocation).setEntityOnTile(null);
                    return true;
                }
            }
            case Action.FightAction fa -> {
                Entity entity1 = this.tileMap.get(fa.entity1Location()).getEntityOnTile();
                Entity entity2 = this.tileMap.get(fa.entity2Location()).getEntityOnTile();
                EntityFightingSystem
            }
            default -> {
                return false;
            }
        }
        return false;
    }

    @Override
    public void update() {
        for (int y = 0; y < this.worldBounds.getY(); y++) {
            for (int x = 0; x < this.worldBounds.getX(); x++) {
                Tile tile = this.tileMap.get(new Vector2(x, y));
                Entity entity = tile.getEntityOnTile();
                if ((entity == null) ^ !(entity instanceof Actor)) {
                    continue;
                }
                int viewRange = this.baseStats.viewRange() + entity.getBaseStats().extraViewRange();
                WorldSlice visibleWorldSlice = new WorldSlice(this, new Rectangle(
                        new Vector2(x - viewRange, y - viewRange), new Vector2(x + viewRange, y + viewRange)));
                Action action = ((Actor) entity).nextAction(visibleWorldSlice);
            }
        }
    }

}
