package sbg.informatikag;

import sbg.informatikag.world.NormalWorld;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DungeonCrawler dungeonCrawler = new DungeonCrawler(new NormalWorld(new Vector2(20, 20)));
        System.out.println(dungeonCrawler);
    }
}
