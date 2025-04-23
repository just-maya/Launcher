package me.justmaya.launcher.launcher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class LaunchItems {

    public void launchArmorStand(Player player, Material material, Double velocity) {
        Location loc = player.getEyeLocation();
        Vector direction = loc.getDirection();
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        ItemStack item = new ItemStack(material);

        armorStand.setVisible(false);
        armorStand.setHelmet(item);

        Vector armorStandVelocity = direction.multiply(velocity);
        armorStand.setVelocity(armorStandVelocity);
    }
}
