package org.example.entities;

public class Player {

public boolean hasFled;
private int maxHealth;
private int currentHealth;
private boolean attackPower;
private int weaponPower;
private boolean hasHealed;

public Player(int maxHealth, int attackPower) {
	this.maxHealth = 20;
	this.currentHealth = maxHealth;
	this.attackPower = false;
	this.hasFled = false;
	this.hasHealed = false;
}

public int getMaxHealth() {
	return maxHealth;
}

public void setMaxHealth(int maxHealth) {
	this.maxHealth = maxHealth;
}

public int getCurrentHealth() {
	return currentHealth;
}

public void setCurrentHealth(int currentHealth) {
	this.currentHealth = currentHealth;
}


public int getWeaponPower() {
	return weaponPower;
}

public void setWeaponPower(int weaponPower) {
	this.weaponPower = weaponPower;
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

public boolean getAttackPower(){
	return attackPower;
}
public void setAttackPower(boolean attackPower) {
	this.attackPower = attackPower;
}
}
