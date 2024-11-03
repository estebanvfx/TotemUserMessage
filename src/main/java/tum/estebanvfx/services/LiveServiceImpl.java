package tum.estebanvfx.services;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class LiveServiceImpl implements LiveService {
    private final Logger logger;

    public LiveServiceImpl(Logger logger) {
        this.logger = logger;
    }


    @Override
    public void regenerateHealth(Player player, double health) {
        final double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

        //logica para regenerar vida
        if (health > 0){
            if ((player.getHealth() + (health * 2)) > maxHealth){
                player.setHealth(maxHealth);
            }else {
                player.setHealth((player.getHealth() + (health * 2)));
            }
            logger.info("Regenerando vida para el jugador " + player.getName());
            player.sendMessage("¡¡¡¡¡¡¡¡ ¡Has recuperado " + health + " corazones! ¡¡¡¡¡¡¡¡");
        }else{
            double recoveredLife = ((maxHealth - player.getHealth())/2);
            player.setHealth(maxHealth);
            logger.info("Regenerando vida para el jugador " + player.getName());
            player.sendMessage("¡¡¡¡¡¡¡¡ ¡Has regenerado " + recoveredLife + " corazones! ¡¡¡¡¡¡¡¡");
        }
    }
}
