package cz.bakterio.vanishplugin.events;

import cz.bakterio.vanishplugin.VanishPlugin;
import cz.bakterio.vanishplugin.commands.VanishCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    VanishPlugin plugin;

    public JoinEvent(VanishPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : VanishCommand.players) {
            e.getPlayer().hidePlayer(plugin, p);
        }
    }
}
