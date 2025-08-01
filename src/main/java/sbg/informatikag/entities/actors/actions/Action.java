package sbg.informatikag.entities.actors.actions;

import sbg.informatikag.Vector2;

public interface Action {
    public record MoveAction(Vector2 entityTileMapLocation, int xChange, int yChange) implements Action {
    }
    public record FightAction(Vector2 entity1Location, Vector2 entity2Location) implements Action {
    }
}
