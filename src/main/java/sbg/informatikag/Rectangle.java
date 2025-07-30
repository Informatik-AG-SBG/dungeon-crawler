package sbg.informatikag;

public class Rectangle implements CollisionObject {

    Vector2 start;
    public Vector2 getStart() {
        return start;
    }

    public void setStart(Vector2 start) {
        this.start = start;
    }

    Vector2 end;

    public Vector2 getEnd() {
        return end;
    }

    public void setEnd(Vector2 end) {
        this.end = end;
    }

    @Override
    public boolean collides(Vector2 location) {
        return (((location.getX() >= this.getStart().getX()) && (location.getY() >= this.getStart().getY())) && ((location.getX() <= this.getEnd().getX()) && (location.getY() <= this.getEnd().getX())));
    }

    @Override
    public boolean collides(Rectangle rectangle) {
        return (((rectangle.getStart().getX() >= this.getStart().getX()) && (rectangle.getStart().getY() >= this.getStart().getY())) && ((rectangle.getEnd().getX() <= this.getEnd().getX()) && (rectangle.getEnd().getY() <= this.getEnd().getX())));
    }
}
