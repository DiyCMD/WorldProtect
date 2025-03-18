package io.github.diycmd.world_protect;

import java.util.Set;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.md_5.bungee.api.ChatColor;

public class Event implements Listener {
    private Set<World> protectWorlds;

    public Event(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.protectWorlds = plugin.protectWorlds;
    }

    /**
     * Playerによるブロック破壊を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (this.protectWorlds.contains(event.getBlock().getWorld())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
        }
    }

    /**
     * Playerによるブロック設置を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (this.protectWorlds.contains(event.getBlock().getWorld())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
        }
    }

    /**
     * Playerによるアイテムドロップを禁止
     * 
     * @param event
     */
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (this.protectWorlds.contains(event.getItemDrop().getWorld())) {
            event.setCancelled(true);

            // 影響を与えたEntityにメッセージを送信
            event.getPlayer().sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
        }
    }

    /**
     * Entityによる爆発を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onBlockBreak(EntityExplodeEvent event) {
        if (this.protectWorlds.contains(event.getLocation().getWorld())) {
            event.setCancelled(true);
        }
    }

    /**
     * Entityによるアイテム回収を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onPickupItem(EntityPickupItemEvent event) {
        if (this.protectWorlds.contains(event.getItem().getWorld())) {
            event.setCancelled(true);

            // 影響を与えたEntityにメッセージを送信
            Entity entity = event.getEntity();
            if (entity != null && entity instanceof Player) {
                entity.sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
            }
        }
    }

    /**
     * Entityによるアイテムドロップを禁止
     * 
     * @param event
     */
    @EventHandler
    public void onEntityDropItem(EntityDropItemEvent event) {
        if (this.protectWorlds.contains(event.getItemDrop().getWorld())) {
            event.setCancelled(true);

            // 影響を与えたEntityにメッセージを送信
            Entity entity = event.getEntity();
            if (entity != null && entity instanceof Player) {
                entity.sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
            }
        }
    }

    /**
     * Entityがダメージを受ける事を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onDamageEvent(EntityDamageEvent event) {
        if (this.protectWorlds.contains(event.getEntity().getWorld())) {
            event.setCancelled(true);

            // 影響を与えたEntityにメッセージを送信
            Entity entity = event.getDamageSource().getCausingEntity();
            if (entity != null && entity instanceof Player) {
                entity.sendMessage(ChatColor.RED + "このワールドは保護されてるよ！");
            }
        }
    }

    /**
     * Entityによるブロック変更を禁止
     * 
     * @param event
     */
    @EventHandler
    public void onChangeBlock(EntityChangeBlockEvent event) {
        if (this.protectWorlds.contains(event.getBlock().getWorld())) {
            event.setCancelled(true);
        }
    }
}
