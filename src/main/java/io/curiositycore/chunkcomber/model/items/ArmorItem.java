package io.curiositycore.chunkcomber.model.items;

import org.bukkit.enchantments.Enchantment;

public interface ArmorItem extends EnchantedItem{
    int getProtectionLevel();
    Enchantment[] getProtectionType();
}
