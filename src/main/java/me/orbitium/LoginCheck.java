package me.orbitium;

import me.orbitium.OFItemChecker;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class LoginCheck implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        if (OFItemChecker.checkOPPlayers && event.getPlayer().isOp())
            return;
        Bukkit.getScheduler().runTaskLater(OFItemChecker.getInstance(), () -> {
            for (ItemStack itemStack : event.getPlayer().getInventory().getContents()) {
                if (itemStack != null && OFItemChecker.isItemBlocked(itemStack.getType())) {
                    itemStack.setAmount(0);
                    OFItemChecker.log(event.getPlayer(), itemStack.getType());
                }
            }
        }, 1L);
    }

}
