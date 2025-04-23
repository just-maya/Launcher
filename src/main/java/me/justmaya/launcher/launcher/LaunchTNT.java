package me.justmaya.launcher.launcher;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class LaunchTNT {

    public void launchTNT(Player player, Double velocity) {
        Location loc = player.getEyeLocation();
        Vector direction = loc.getDirection();
        TNTPrimed tnt = (TNTPrimed) player.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
        tnt.setFuseTicks(80);

        Vector tntVelocity = direction.multiply(velocity);
        tnt.setVelocity(tntVelocity);
    }
}
