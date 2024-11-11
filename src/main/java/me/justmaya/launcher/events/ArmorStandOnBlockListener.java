package me.justmaya.launcher.events;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Statistic;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorStandOnBlockListener implements Listener {

    @EventHandler
    public void onArmorStandLand(EntityMoveEvent event) {
        if (!(event.getEntity() instanceof ArmorStand)) return;

        ArmorStand armorStand = (ArmorStand) event.getEntity();

        if (!armorStand.isOnGround()) return;

        armorStand.setHealth(0); // Kill the ArmorStand
        ItemStack itemToDrop = armorStand.getHelmet();
        armorStand.getWorld().dropItem(armorStand.getLocation(), itemToDrop);

    }
}
