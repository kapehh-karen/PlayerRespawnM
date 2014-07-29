package me.kapehh.PlayerRespawnM;

import me.kapehh.PlayerRespawnM.manager.PlayerRespawnMCollection;
import me.kapehh.main.pluginmanager.config.EventPluginConfig;
import me.kapehh.main.pluginmanager.config.EventType;
import me.kapehh.main.pluginmanager.config.PluginConfig;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnMConfig {
    private static final String PERM_PREFFIX = "PlayerRespawnM.respawn.";
    private PluginConfig pluginConfig;

    public PlayerRespawnMConfig(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @EventPluginConfig(EventType.LOAD)
    public void onLoad() {
        FileConfiguration cfg = pluginConfig.getConfig();
        Logger logger = PlayerRespawnM.getInstance().getLogger();
        Set<String> strPerms = cfg.getKeys(false);
        HashMap<String, World> map = new HashMap<String, World>();
        for (String k : strPerms) {
            String worldName = cfg.getString(k);
            World world = Bukkit.getWorld(worldName);
            if (world != null) {
                map.put(PERM_PREFFIX + k, world);
            } else {
                logger.warning("World not found: " + worldName);
            }
        }
        PlayerRespawnM.setRespawnMCollection(new PlayerRespawnMCollection(map));
    }
}
