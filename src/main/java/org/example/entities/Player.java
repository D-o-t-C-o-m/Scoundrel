package org.example.entities;

import org.example.Constants;
import java.util.ArrayList;
import java.util.List;

public class Player {
private boolean hasFled;
private int maxHealth;
private int currentHealth;
private boolean attackPower;
private int weaponPower;
private boolean hasHealed;
private List<String> inventory;

public Player(int maxHealth, int weaponPower) {
	this.maxHealth = maxHealth;
	this.currentHealth = maxHealth;
	this.weaponPower = weaponPower;
	this.attackPower = false;
	this.hasFled = false;
	this.hasHealed = false;
	this.inventory = new ArrayList<>();
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

public List<String> getInventory() {
	return inventory;
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

public void addItemToInventory(String item) {
	if (inventory.isEmpty()) {
		inventory.add(item);
	} else {
		System.out.println("You can only hold one item.");
	}
}
public void removeItemFromInventory() {
	if (!inventory.isEmpty()) {
		inventory.remove(0);
	} else {
		System.out.println("Your inventory is empty.");
	}
}


}