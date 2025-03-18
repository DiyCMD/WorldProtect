package io.github.diycmd.world_protect;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;

public class Main extends JavaPlugin {
    Set<World> protectWorlds = new HashSet<>();

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).silentLogs(true));
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable();

        // Register commands
        Command cmd = new Command(this.protectWorlds);
        cmd.register();

        // Register events
        new Event(this);
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();
    }
}
