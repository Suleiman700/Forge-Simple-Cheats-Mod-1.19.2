package com.example.examplemod.World;

import com.example.examplemod.Chat;
import net.minecraft.client.gui.components.Button;

public class FindOres {
    private static boolean enabled = false;

    public static boolean get_state() {
        return enabled;
    }

    public static void toggle(Button button) {
        enabled = !enabled;
        Chat.SendMessage("Ores finder is now enabled, Looking for ores around you :)");
    }

    public static void disable() {
        enabled = false;
    }
}
