package sbg.informatikag.entities.actors;

import sbg.informatikag.entities.Entity;
import sbg.informatikag.entities.actors.actions.Action;
import sbg.informatikag.world.WorldSlice;

public interface Actor extends Entity {
    public Action nextAction(WorldSlice visibleWorldSlice);
}
