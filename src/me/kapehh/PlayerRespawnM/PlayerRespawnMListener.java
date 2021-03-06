package me.kapehh.PlayerRespawnM;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnMListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            return;
        }

        Location location = PlayerRespawnM.getRespawnMCollection().process(player);
        if (location != null) {
            event.setRespawnLocation(location);

            // TODO: Remove
            //System.out.println("Player '" + event.getPlayer().getName() + "' set respawn: " + location);
        }
    }

    /*@EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Location location = PlayerRespawnM.getRespawnMCollection().process(event.getPlayer());
        if (location != null) {
            event.getPlayer().teleport(location);
        }
    }*/

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            return;
        }

        Location location = PlayerRespawnM.getRespawnMCollection().process(player);
        if (location != null) {
            event.getPlayer().teleport(location);

            // TODO: Remove
            //System.out.println("Player '" + event.getPlayer().getName() + "' tp to: " + location);
        }
    }
}
