package me.orbitium;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceCheck implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Bukkit.getScheduler().runTaskAsynchronously(OFItemChecker.getInstance(), () -> {
            if (OFItemChecker.checkOPPlayers && event.getPlayer().isOp())
                return;

            if (OFItemChecker.isItemBlocked(event.getBlock().getType()))
                Bukkit.getScheduler().runTaskLater(OFItemChecker.getInstance(), () -> event.getBlock().setType(Material.AIR), 1L);
        });
    }
}
