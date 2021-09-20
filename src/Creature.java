public class Creature implements Fighter{
    private String name;
    private int hp, agility, power, xp, gold;

    public Creature(String name, int hp, int agility, int power, int xp, int gold) {
        this.name = name;
        this.hp = hp;
        this.agility = agility;
        this.power = power;
        this.xp = xp;
        this.gold = gold;
    }

    @Override
    public int attack(){
        if(agility * 3 > ((int) (Math.random() * 10))){
            if(((int)(Math.random() * 100)) > 33){
                return power * 2; //critical
            }
            return power; //default
        }
        return 0; //miss
    }

    public String getName() {
        return name;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return getName() + ": здоровье = " + getHp();
    }
}
