package com.example.examplemod.Effects;

import net.minecraft.client.gui.components.Button;

public class SlowFalling {
    private static boolean enabled = false;

    public static void toggle(Button button) {
        enabled = !enabled;
    }

    public static boolean get_state() {
        return enabled;
    }
}
