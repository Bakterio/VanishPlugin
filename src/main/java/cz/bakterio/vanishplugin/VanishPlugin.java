package cz.bakterio.vanishplugin;

import cz.bakterio.vanishplugin.commands.VanishCommand;
import cz.bakterio.vanishplugin.events.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanishPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
    }

}
