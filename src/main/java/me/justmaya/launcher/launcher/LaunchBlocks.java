package me.justmaya.launcher.launcher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class LaunchBlocks {

    public Boolean checkForBlock(Player player, Double velocity, String arg) {
        Material material;
        try {
            material = Material.valueOf(arg.toUpperCase());
        } catch (IllegalArgumentException ignored) { return false; }

        if (material.isBlock()) {
            launchFallingBlock(player, material, velocity);
            return true;
        } else if (material.isItem()) {
            new LaunchItems().launchArmorStand(player, material, velocity);
            return true;
        }
        return false;
    }

    public void launchFallingBlock(Player player, Material material, Double velocity) {
        Location loc = player.getEyeLocation();
        Vector direction = loc.getDirection();
        FallingBlock fallingBlock = player.getWorld().spawnFallingBlock(loc, material, (byte) 0);

        Vector fallingBlockVelocity = direction.multiply(velocity);
        fallingBlock.setVelocity(fallingBlockVelocity);
    }

}
