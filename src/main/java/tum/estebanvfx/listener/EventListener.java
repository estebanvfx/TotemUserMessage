package tum.estebanvfx.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import tum.estebanvfx.services.EventService;


public class EventListener implements Listener {
    private final EventService eventService;

    public EventListener(EventService eventService) {
        this.eventService = eventService;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerTotemUse(EntityResurrectEvent event){
        eventService.handleTotemUse(event);
    }

}
