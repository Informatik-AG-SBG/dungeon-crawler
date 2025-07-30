package sbg.informatikag.entities.actors;

import sbg.informatikag.entities.EntityBaseStats;
import sbg.informatikag.entities.actors.actions.Action;
import sbg.informatikag.entities.actors.actions.MoveAction;
import sbg.informatikag.numbervalues.RandomNumberValue;
import sbg.informatikag.world.WorldSlice;

public class RandomMoveTestActor implements Actor {

    EntityBaseStats baseStats;

    public RandomMoveTestActor(EntityBaseStats baseStats) {
        this.baseStats = baseStats;
    }

    @Override
    public EntityBaseStats getBaseStats() {
        return this.baseStats;
    }

    @Override
    public Action nextAction(WorldSlice visibleWorldSlice) {
        return new MoveAction(this, new RandomNumberValue(this.baseStats.moveSpeed() / -2, this.baseStats.moveSpeed() / 2), new RandomNumberValue(this.baseStats.moveSpeed() / -2, this.baseStats.moveSpeed() / 2));
    }
}
