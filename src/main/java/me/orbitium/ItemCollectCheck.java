package me.orbitium;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemCollectCheck implements Listener {

    @EventHandler
    public void onItemCollect(EntityPickupItemEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getEntity().isOp())
            return;
        if (OFItemChecker.isItemBlocked(event.getItem().getItemStack().getType())) {
            event.setCancelled(true);
            event.getItem().remove();
            OFItemChecker.log((Player) event.getEntity(), event.getItem().getItemStack().getType());
        }
    }
}
