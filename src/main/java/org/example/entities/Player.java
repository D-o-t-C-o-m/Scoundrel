package org.example.entities;

import org.example.Constants;

public class Player {
private boolean hasFled;
private int maxHealth;
private int currentHealth;
private boolean attackPower;
private int weaponPower;
private boolean hasHealed;


public Player(int maxHealth, int weaponPower) {
	this.maxHealth = maxHealth;
	this.currentHealth = maxHealth;
	this.weaponPower = weaponPower;
	this.attackPower = false;
	this.hasFled = false;
	this.hasHealed = false;
}


public Player() {
	this(Constants.DEFAULT_MAX_HEALTH, Constants.DEFAULT_WEAPON_POWER);
}


public int getMaxHealth() {
	return maxHealth;
}


public void setMaxHealth(int maxHealth) {
	this.maxHealth = maxHealth;
	if (currentHealth > maxHealth) {
		currentHealth = maxHealth;
	}
}

public int getCurrentHealth() {
	return currentHealth;
}

public void setCurrentHealth(int currentHealth) {
	this.currentHealth = Math.min(Math.max(0, currentHealth), maxHealth);
}

public int getWeaponPower() {
	return weaponPower;
}

public void setWeaponPower(int weaponPower) {
	this.weaponPower = Math.max(0, weaponPower);
}

public boolean hasFled() {
	return hasFled;
}

public void setHasFled(boolean hasFled) {
	this.hasFled = hasFled;
}

public boolean hasHealed() {
	return hasHealed;
}

public void setHasHealed(boolean hasHealed) {
	this.hasHealed = hasHealed;
}

public boolean hasAttackPower() {
	return attackPower;
}

}