package me.orbitium;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftCheck implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getWhoClicked().isOp())
            return;

        for (ItemStack itemStack : event.getInventory().getContents()) {
            if (OFItemChecker.isItemBlocked(itemStack.getType())) {
                itemStack.setAmount(0);
                event.setCurrentItem(new ItemStack(Material.AIR));
                event.setCancelled(true);
                OFItemChecker.log((Player) event.getWhoClicked(), itemStack.getType());

            }
        }
    }
}
