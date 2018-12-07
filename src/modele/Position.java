package modele;

public class Position {

    // Attributs

    private Integer x;

    private Integer y;

    // Constructeur

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    // Accesseurs


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
