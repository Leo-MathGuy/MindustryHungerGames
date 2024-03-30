package hunger.data;

import arc.struct.ObjectMap;
import mindustry.gen.Player;
import mindustry.type.Item;

public class PlayerData {
    private static ObjectMap<Player, PlayerData> deeta = new ObjectMap<>();

    public final Player player;

    private boolean spectate = false;
    private Inventory<Item> itemInv;

    private PlayerData(Player p) {
        this.player = p;
        this.itemInv = new Inventory<Item>();
    }

    // OBJECT

    public boolean playing() {
        return this.spectate == false;
    }

    public String toString() {
        return "PlayerData{player: " + (Object) this.player + ", spectate: " + this.spectate;
    }

    // STATIC

    public static void put(Player p) {
        PlayerData data = new PlayerData(p);
    	
    	deeta.put(p, data);
    }

    public static void clear() {
        deeta.clear();
    }

    public static boolean contains(Player p) {
        return deeta.containsKey(p);
    }
}