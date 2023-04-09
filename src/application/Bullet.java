import application.GunGame.Enemy;

public class Bullet {
    private double x;
    private double y;

    public Bullet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void update() {
        y -= BULLET_SPEED;
    }

    public boolean intersects(Enemy enemy) {
        return x < enemy.getX() + ENEMY_SIZE &&
                x + BULLET_SIZE > enemy.getX() &&
                y < enemy.getY() + ENEMY_SIZE &&
                y + BULLET_SIZE > enemy.getY();
    }
}