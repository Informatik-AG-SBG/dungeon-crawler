package sbg.informatikag;

public interface CollisionObject {
    public boolean collides(Vector2 location);
    public boolean collides(Rectangle rectangle);
}
