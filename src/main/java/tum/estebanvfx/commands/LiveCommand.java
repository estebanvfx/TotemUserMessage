package tum.estebanvfx.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tum.estebanvfx.services.LiveService;

public class LiveCommand implements CommandExecutor {
    private final LiveService liveService;

    public LiveCommand(LiveService liveService) {
        this.liveService = liveService;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        double health = 0;
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Este comando sólo se por un jugador");
            return true;
        }

        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("live")){
            try {
                if (args.length > 0){
                    health = Double.parseDouble(args[0]);
                    liveService.regenerateHealth(player, health);
                }else{
                    health = 0;
                    liveService.regenerateHealth(player, health);
                }
                return true;
            } catch (Exception e) {
                commandSender.sendMessage("¡¡¡¡¡¡¡¡ ¡Error argumento no valido! ¡¡¡¡¡¡¡¡");
            }
        }

        return false;
    }
}
