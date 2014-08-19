package me.kapehh.PlayerRespawnM.manager;

import me.kapehh.PlayerRespawnM.PlayerRespawnM;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnMCollection {
    private static final String PERM_PREFFIX = "PlayerRespawnM.respawn.";
    private Map<String, World> mapRespawnWorld;

    public PlayerRespawnMCollection() {
        init();
    }

    public void init() {
        HashMap<String, World> map = new HashMap<String, World>();
        for (World world : Bukkit.getWorlds()) {
            if (world != null) {
                map.put(PERM_PREFFIX + world.getName(), world);
            }
        }
        mapRespawnWorld = map;
    }

    public Location process(Player player) {
        Permission permission = PlayerRespawnM.getPermission();
        Set<String> keys = mapRespawnWorld.keySet();
        for (String k : keys) {
            if (permission.has(player, k)) {
                World world = mapRespawnWorld.get(k);
                return world.getSpawnLocation();
            }
        }
        return null;
    }
}
