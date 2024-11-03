package tum.estebanvfx.services;

import org.bukkit.event.entity.EntityResurrectEvent;

public interface EventService {
    void handleTotemUse(EntityResurrectEvent event);
}
