package hunger;

import arc.*;
import arc.util.*;
import hunger.data.PlayerData;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.Gamemode;
import mindustry.mod.*;

public class HungerGames extends Plugin{

    @Override
    public void init(){
        Log.info("I hunger for shredded cheese");

        Events.on(WorldLoadEndEvent.class, e -> {
            // Check PVP
            var pvp = Vars.state.rules.mode() == Gamemode.pvp;
            
            if (!pvp) {
                Log.err("Bruh this is not PVP are you stupid or what");
                Vars.net.closeServer();
                return;
            }

            PlayerData.clear();
        });

        Events.on(PlayerJoin.class, e -> {
            if (!PlayerData.contains(e.player)) {
                PlayerData.put(e.player);
            }
        });
    }

    @Override
    public void registerServerCommands(CommandHandler handler){
    }

    @Override
    public void registerClientCommands(CommandHandler handler){

    }
}
