package tum.estebanvfx;


import org.bukkit.plugin.java.JavaPlugin;
import tum.estebanvfx.commands.LiveCommand;
import tum.estebanvfx.services.EventServiceIpml;
import tum.estebanvfx.services.LiveService;
import tum.estebanvfx.services.LiveServiceImpl;
import tum.estebanvfx.services.EventService;
import tum.estebanvfx.listener.EventListener;

public class Main extends JavaPlugin {
    private LiveService liveService;
    private EventService eventService;


    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("Inicando Plugin!");
        startService();
        commandRegister();
        registerEventsListener();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("Deshabilitando Plugin!");
    }

    private void startService() {
        liveService = new LiveServiceImpl(getLogger());
        eventService = new EventServiceIpml();
    }

    private void commandRegister() {
        LiveCommand liveCommand = new LiveCommand(liveService);
        getCommand("live").setExecutor(liveCommand);
    }

    public void registerEventsListener(){
        EventListener eventListener = new EventListener(eventService);
        getServer().getPluginManager().registerEvents(eventListener, this);
    }
}
