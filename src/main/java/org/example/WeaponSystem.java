package org.example;

import org.example.entities.Player;

public class WeaponSystem {
private final Player player;
private boolean weaponFresh = false;
private static boolean allowUsedWeaponOverHit = false;

public WeaponSystem(Player player) {
    this.player = player;
}

public static void setAllowUsedWeaponOverHit(boolean allow) {
    allowUsedWeaponOverHit = allow;
}

public boolean canUseWeaponAgainst(int enemyHealth) {
    return weaponFresh ||
            allowUsedWeaponOverHit ||
            enemyHealth <= player.getWeaponPower();
}

public void equipWeapon(int power) {
    player.setWeaponPower(power);
    weaponFresh = true;
    System.out.println("You have found a weapon! Your attack power is now: " + power);
}

public CombatResult useWeaponAgainst(int enemyHealth) {
    weaponFresh = false;

    if (player.getWeaponPower() > enemyHealth) {
        return new CombatResult(true, 0, enemyHealth);
    } else if (player.getWeaponPower() == enemyHealth) {
        return new CombatResult(true, 0, player.getWeaponPower());
    } else {
        int damage = enemyHealth - player.getWeaponPower();
        return new CombatResult(true, damage, player.getWeaponPower());
    }
}

public record CombatResult(boolean success, int playerDamage, int newWeaponPower) {
}
}