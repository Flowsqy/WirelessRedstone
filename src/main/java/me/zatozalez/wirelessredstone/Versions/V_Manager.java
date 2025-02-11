package me.zatozalez.wirelessredstone.Versions;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Piston;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.inventory.ItemStack;

public class V_Manager {
    public static String minecraftVersion = "0.0.0";
    public static String pluginVersion = "0.0.0";
    public static String latestPluginVersion = "0.0.0";
    private static String api = "https://api.github.com/repos/ZatoZalez/WirelessRedstone/releases/latest";
    public static void setVersion(){
        String v = Bukkit.getVersion();
        v = v.substring(v.indexOf("(") + 1);
        v = v.substring(0, v.indexOf(")"));
        v = v.substring(4);
        minecraftVersion = (v.split("[.]")[0] + "." +  v.split("[.]")[1]);
        latestPluginVersion = minecraftVersion;
    }

    public static boolean isCompatible(){
        return true; // We live dangerously
    }

    public static ItemStack[] getItemStack(){
        switch(minecraftVersion) {
            case "1.16":
                return V_1_16.getItemStack();
            case "1.17":
                return V_1_17.getItemStack();
            case "1.18":
                return V_1_18.getItemStack();
            default:
                return V_1_19.getItemStack(); // We still live dangerously
        }
    }

    public static boolean cancelPistonEvent(BlockPhysicsEvent e, Block pistonBlock, Piston piston){
        switch(minecraftVersion) {
            case "1.16":
                return V_1_16.cancelPistonEvent(e, pistonBlock, piston);
            case "1.17":
                return V_1_17.cancelPistonEvent(e, pistonBlock, piston);
            case "1.18":
                return V_1_18.cancelPistonEvent(e, pistonBlock, piston);
            default:
                return V_1_19.cancelPistonEvent(e); // Guess what ? Life is a dangerous thing
        }
    }

}
