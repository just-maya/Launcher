package me.justmaya.launcher.launcher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class LaunchMobs {

    public void launchMobs(Player player, Material material, Double velocity) {
        Location loc = player.getEyeLocation();
        Vector direction = loc.getDirection();

        ItemStack item = new ItemStack(material);
    }
}
