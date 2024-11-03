package tum.estebanvfx.services;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityResurrectEvent;

public class EventServiceIpml implements EventService{
    @Override
    public void handleTotemUse(EntityResurrectEvent event) {
        if (event.getEntity() instanceof Player player && !event.isCancelled()){
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l"+player.getName()+"&r&e ha usado un tótem "));
            }
        }
    }
}
