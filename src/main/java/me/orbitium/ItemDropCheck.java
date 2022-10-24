package me.orbitium;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropCheck implements Listener {

    @EventHandler
    void onItemDrop(PlayerDropItemEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getPlayer().isOp())
            return;

        if (OFItemChecker.isItemBlocked(event.getItemDrop().getItemStack().getType())) {
            event.getItemDrop().remove();
            OFItemChecker.log(event.getPlayer(), event.getItemDrop().getItemStack().getType());
        }
    }
}
