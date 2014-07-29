package me.kapehh.PlayerRespawnM.manager;

import me.kapehh.PlayerRespawnM.PlayerRespawnM;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.*;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnMCollection {
    private Map<String, World> mapRespawnWorld;

    public PlayerRespawnMCollection(Map<String, World> stringList) {
        mapRespawnWorld = stringList;
    }

    public void process(Player player, PlayerRespawnEvent event) {
        Permission permission = PlayerRespawnM.getPermission();
        Set<String> keys = mapRespawnWorld.keySet();
        for (String k : keys) {
            if (permission.has(player, k)) {
                World world = mapRespawnWorld.get(k);
                event.setRespawnLocation(world.getSpawnLocation());
                break;
            }
        }
    }
}
