public class Battle {
    public void fight(Creature hero, Creature enemy, FightCallback fightCallback) {
        Thread battleField = new Thread(() -> {
            int turn = 1;
            boolean isBattleEnd = false;
            while(!isBattleEnd){
                System.out.println("Ход битвы: " + turn);
                if (turn % 2 == 0) {
                    isBattleEnd = attackTo(enemy, hero, fightCallback);
                } else {
                    isBattleEnd = attackTo(hero, enemy, fightCallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                turn++;
            }

        });
        battleField.start();
    }

    private boolean attackTo(Creature attacker, Creature defender, FightCallback fightCallback) {
        //Наносим урон
        int damage = attacker.attack();
        if (damage != 0) {
            defender.setHp(defender.getHp() - damage);
            System.out.println(attacker.getName() + " атаковал монстра " + defender.getName() + " на " + damage + " урона");
        } else {
            System.out.println(attacker.getName() + " промазал своим ударом по " + defender.getName());
        }

        //Проверяем смерти
        if(defender.getHp() <= 0 && defender instanceof Hero){
            //Это смерть героя
            System.out.println("... И вот история нашего героя окончена ...");
            fightCallback.fightLost();
            return true;
        } else if (defender.getHp() <= 0){
            //Это смерть монстра
            System.out.println(defender.getName() + " повержен!\n" +
                    "Вы получили " + defender.getGold() + " золота и " + defender.getXp() + " опыта");
            attacker.setGold(attacker.getGold() + defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            fightCallback.fightWin();
            return true;
        } else{
            //Если произошел промах
            return false;
        }
    }
}
