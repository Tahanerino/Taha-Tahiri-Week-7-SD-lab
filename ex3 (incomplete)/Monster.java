public abstract class Monster {
    protected int health;

    public Monster(int health) {
        this.health = health;
    }

    public abstract void attack(Monster opponent);

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }
}