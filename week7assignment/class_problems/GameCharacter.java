public class GameCharacter {
    private int health;
    private final int maxHealth;

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health -= amount;
            if (this.health < 0) {
                this.health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health += amount;
            if (this.health > this.maxHealth) {
                this.health = this.maxHealth;
            }
        }
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        c.takeDamage(30);
        System.out.println("After takeDamage(30): health = " + c.getHealth());
        c.heal(50);
        System.out.println("After heal(50): health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After takeDamage(150): health = " + c.getHealth());
    }
}