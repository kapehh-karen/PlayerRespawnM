package me.kapehh.PlayerRespawnM;

import me.kapehh.PlayerRespawnM.manager.PlayerRespawnMCollection;
import me.kapehh.main.pluginmanager.checker.PluginChecker;
import me.kapehh.main.pluginmanager.config.PluginConfig;
import me.kapehh.main.pluginmanager.vault.PluginVault;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Karen on 29.07.2014.
 */
public class PlayerRespawnM extends JavaPlugin {
    private static PlayerRespawnMCollection respawnMCollection;
    private static PlayerRespawnM instance;
    private static Permission permission;

    public static PlayerRespawnMCollection getRespawnMCollection() {
        return respawnMCollection;
    }

    public static void setRespawnMCollection(PlayerRespawnMCollection respawnMCollection) {
        PlayerRespawnM.respawnMCollection = respawnMCollection;
    }

    public static PlayerRespawnM getInstance() {
        return instance;
    }

    public static Permission getPermission() {
        return permission;
    }

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PluginManager") == null) {
            getLogger().info("PluginManager not found!!!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        PluginChecker pluginChecker = new PluginChecker(this);
        if (!pluginChecker.check("Vault")) {
            return;
        }

        instance = this;
        permission = PluginVault.setupPermissions();
        respawnMCollection = new PlayerRespawnMCollection();
        getServer().getPluginManager().registerEvents(new PlayerRespawnMListener(), this);
    }
}
