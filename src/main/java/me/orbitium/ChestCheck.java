package me.orbitium;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class ChestCheck implements Listener {

    @EventHandler
    public void checkChest(InventoryCloseEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getPlayer().isOp())
            return;

        if (event.getInventory().getType() == InventoryType.CHEST) {
            for (ItemStack itemStack : event.getView().getTopInventory().getContents()) {
                if (itemStack != null && OFItemChecker.isItemBlocked(itemStack.getType())) {
                    itemStack.setAmount(0);
                    OFItemChecker.log((Player) event.getPlayer(), itemStack.getType());
                }
            }
        }
    }
}
