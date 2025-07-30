package sbg.informatikag;

public class Vector2 implements CollisionObject {

    int x = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int y = 0;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public boolean collides(Vector2 location) {
        return ((this.getX() == location.getX()) && (this.getY() == location.getY()));
    }

    @Override
    public boolean collides(Rectangle rectangle) {
        return (((this.getX() >= rectangle.getStart().getX()) && (this.getY() >= rectangle.getStart().getY())) && ((this.getX() <= rectangle.getEnd().getX()) && (this.getY() <= rectangle.getEnd().getX())));
    }
}
