package sbg.informatikag.entities.actors.actions;

import sbg.informatikag.entities.Entity;
import sbg.informatikag.numbervalues.NumberValue;

public record MoveAction(Entity targetEntity, NumberValue x, NumberValue y) implements Action {
}
