package org.example.entities;

public class Player {

private int maxHealth;
private int currentHealth;
private int attackPower;
private boolean hasFled;
private boolean hasHealed;

public Player(int maxHealth, int attackPower) {
	this.maxHealth = 20;
	this.currentHealth = maxHealth;
	this.attackPower = attackPower;
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

public int getAttackPower() {
	return attackPower;
}

public void setAttackPower(int attackPower) {
	this.attackPower = attackPower;
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
}
