package org.example;

import org.example.entities.Card;
import org.example.entities.Player;

public class CombatSystem {
private final Player player;
private final WeaponSystem weaponSystem;
private final InputHandler inputHandler;

public CombatSystem(Player player, WeaponSystem weaponSystem, InputHandler inputHandler) {
    this.player = player;
    this.weaponSystem = weaponSystem;
    this.inputHandler = inputHandler;
}


public boolean handleCombat(Card enemyCard) {
    String enemyName = enemyCard.toString();
    int enemyHealth = enemyCard.getValue();

    System.out.println("You approach " + enemyName + ".");
    int attackChoice = inputHandler.getCombatChoice();

    if (attackChoice == 1) {
        return performBareHandedAttack(enemyHealth);
    } else {
        return performWeaponAttack(enemyHealth);
    }
}

private boolean performBareHandedAttack(int enemyHealth) {
    System.out.println("You attack the enemy with your bare hands.");

    int damage = enemyHealth;
    if (player.hasAttackPower()) {
        damage -= Constants.BARE_HANDED_BONUS;
    }
    int newHealth = player.getCurrentHealth() - damage;
    player.setCurrentHealth(newHealth);
    if (player.getCurrentHealth() <= 0) {
        handlePlayerDefeat();
        return false;
    } else {
        System.out.println("You slay the monster but take " + damage + " damage.");
        System.out.println("You have " + player.getCurrentHealth() + " health left.");
        return true;
    }
}

private boolean performWeaponAttack(int enemyHealth) {
    if (!weaponSystem.canUseWeaponAgainst(enemyHealth)) {
        System.out.println("Your weapon is already bound to slay weaker foes. You must fight barehanded.");
        return performBareHandedAttack(enemyHealth);
    }

    System.out.println("You attack the enemy with a weapon.");
    WeaponSystem.CombatResult result = weaponSystem.useWeaponAgainst(enemyHealth);
    if (result.playerDamage() > 0) {
        int newHealth = player.getCurrentHealth() - result.playerDamage();
        player.setCurrentHealth(newHealth);
        if (player.getCurrentHealth() <= 0) {
            handlePlayerDefeat();
            return false;
        } else {
            System.out.println("You have defeated the enemy, but you took " + result.playerDamage() + " damage.");
            System.out.println("You have " + player.getCurrentHealth() + " health left.");
        }
    } else {
        if (player.getWeaponPower() > result.newWeaponPower()) {
            System.out.println("You have defeated the enemy, and your weapon is now weaker. Attack Power is now: " + result.newWeaponPower());
        } else {
            System.out.println("You have defeated the enemy.");
        }
    }

    player.setWeaponPower(result.newWeaponPower());
    return true;
}

    private void handlePlayerDefeat() {
        System.out.println("You have been defeated.");
        UI ui = new UI();
        System.out.println("Your final score is: " + ui.calculateFinalScore());
        System.exit(0);
    }


public void handleHealing(int healAmount) {
    if (!player.hasHealed()) {
        int newHealth = Math.min(player.getCurrentHealth() + healAmount, player.getMaxHealth());
        player.setCurrentHealth(newHealth);
        player.setHasHealed(true);
        System.out.println("You have healed yourself. Current health: " + player.getCurrentHealth());
    } else {
        System.out.println("You have already healed yourself in this room. The potion turns to dust.");
    }
}
}