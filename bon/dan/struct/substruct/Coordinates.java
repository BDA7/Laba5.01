package bon.dan.struct.substruct;

public class Coordinates {
    private float x; //Значение поля должно быть больше -331
    private float y; //Значение поля должно быть больше -320

    public Coordinates(float x, float y) throws Exception {
        this.setX(x);
        this.setY(y);
    }

    public float getX() {
        return x;
    }

    private void setX(float x) throws Exception {
        if (x <= -331)
            throw new Exception("Invalid x coord (must be > -331)");
        this.x = x;
    }

    public float getY() {
        return y;
    }

    private void setY(float y) throws Exception {
        if (y <= -320)
            throw new Exception("Invalid y coord (must be > -320)");
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
