package me.orbitium;

import me.orbitium.OFItemChecker;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class InventoryCheck implements Listener {

    @EventHandler
    public void onPlayerInventoryClose(InventoryCloseEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getPlayer().isOp())
            return;
        for (ItemStack itemStack : event.getPlayer().getInventory().getContents()) {
            if (itemStack != null && OFItemChecker.isItemBlocked(itemStack.getType())) {
                itemStack.setAmount(0);
                OFItemChecker.log((Player) event.getPlayer(), itemStack.getType());
            }
        }
    }
}
