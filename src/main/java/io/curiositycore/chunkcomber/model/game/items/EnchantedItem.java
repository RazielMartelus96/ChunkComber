package io.curiositycore.chunkcomber.model.game.items;

import org.bukkit.enchantments.Enchantment;

public interface EnchantedItem {
    Enchantment getEnchantment();
    void removeEnchantment(Enchantment enchantmentToRemove);
}
