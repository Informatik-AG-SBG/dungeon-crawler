package sbg.informatikag;

import sbg.informatikag.world.World;

public class DungeonCrawler {

    World world;


    public World getWorld() {
        return world;
    }

    public void setWorld(World world) throws NullPointerException {
        if (world == null) {
            throw new NullPointerException("World must not be Null");
        }
        this.world = world;
    }

    public DungeonCrawler(World world) {
        this.setWorld(world);
    }

}
