package me.justmaya.launcher;

import me.justmaya.launcher.commands.LaunchCommand;
import me.justmaya.launcher.events.ArmorStandOnBlockListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Launcher extends JavaPlugin {

    @Override
    public void onEnable() {
        commands();
        events();
    }

    private void commands() {
        Objects.requireNonNull(getCommand("launch")).setExecutor(new LaunchCommand());
    }

    private void events() {
        Bukkit.getServer().getPluginManager().registerEvents(new ArmorStandOnBlockListener(), this);
    }
}
