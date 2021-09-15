package cz.bakterio.vanishplugin.commands;

import cz.bakterio.vanishplugin.VanishPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class VanishCommand implements CommandExecutor {

    public static final LinkedList<Player> players = new LinkedList<>();
    private static VanishPlugin plugin;

    public VanishCommand(VanishPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!p.hasPermission("vanish")) {
                p.sendMessage("You don't have permissions to hide yourself, haha, cry more ;)");
                return true;
            }

            if (players.contains(p)) {
                turnOFF(p);
                players.remove(p);
                p.sendMessage("You are " + ChatColor.YELLOW + "visible" + ChatColor.RESET + " to other players.");
            } else {
                turnON(p);
                players.add(p);
                p.sendMessage("You are " + ChatColor.YELLOW + "invisible" + ChatColor.RESET + " to other players.");
            }
        }

        return true;
    }

    public static void turnON(Player p) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            onlinePlayers.hidePlayer(plugin, p);
        }
    }

    public static void turnOFF(Player p) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            onlinePlayers.showPlayer(plugin, p);
        }
    }
}
