package me.kapehh.PlayerRespawnM;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnMListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        PlayerRespawnM.getRespawnMCollection().process(event.getPlayer(), event);
    }
}
