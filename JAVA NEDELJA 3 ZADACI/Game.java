
public class Game {

    public static void main(String[] args) {

        Player p = new Player(2, 2, 4, 4, 100);

        Enemy e1 = new Enemy(4, 3, 3, 3, 30);
        Enemy e2 = new Enemy(10, 10, 2, 2, 20);

        if (checkCollision(p, e1)) {
            decreaseHealth(p, e1);
        }

        if (checkCollision(p, e2)) {
            decreaseHealth(p, e2);
        }

        System.out.println("Health igraca: " + p.getHealth());
    }

    static boolean checkCollision(Player p, Enemy e) {

        return p.getX() < e.getX() + e.getWidth()
                && p.getX() + p.getWidth() > e.getX()
                && p.getY() < e.getY() + e.getHeight()
                && p.getY() + p.getHeight() > e.getY();
    }

    static void decreaseHealth(Player p, Enemy e) {

        int noviHealth = p.getHealth() - e.getDamage();

        if (noviHealth < 0) {
            noviHealth = 0;
        }

        p.setHealth(noviHealth);
    }
}


class Player {

    private int x;
    private int y;
    private int width;
    private int height;
    private int health;

    public Player(int x, int y, int width, int height, int health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }
    }
}


class Enemy {

    private int x;
    private int y;
    private int width;
    private int height;
    private int damage;

    public Enemy(int x, int y, int width, int height, int damage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDamage(damage);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage >= 0 && damage <= 100) {
            this.damage = damage;
        }
    }
}