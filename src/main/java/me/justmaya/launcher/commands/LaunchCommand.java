package me.justmaya.launcher.commands;

import me.justmaya.launcher.launcher.LaunchBlocks;
import me.justmaya.launcher.launcher.LaunchTNT;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player)) return false;
        if (strings.length == 0) return false;

        String arg = strings[0].toLowerCase();
        double velocity = 1.0;

        if (strings.length > 1 && !strings[1].isEmpty()) {
            velocity = Double.parseDouble(strings[1]);
        }

        if ("tnt".equals(arg)) {
            new LaunchTNT().launchTNT((Player) sender, velocity);
            return true;
        } else {
            return new LaunchBlocks().checkForBlock((Player) sender, velocity, arg);
        }
    }

    @Override
    public @Nullable List<String>
    onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length != 1) return null;

        List<String> tabList = new ArrayList<String>();
        tabList.add("TNT");

        for (Material material: Material.values()) {
            if (material.isBlock()) {
                tabList.add(material.name());
            }
        }

        String input = strings[0].toLowerCase();
        return tabList.stream().filter(value -> value.toLowerCase().startsWith(input)).collect(Collectors.toList());
    }
}
