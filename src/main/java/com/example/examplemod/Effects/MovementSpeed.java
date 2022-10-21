package com.example.examplemod.Effects;


import net.minecraft.client.gui.components.Button;

public class MovementSpeed {
    private static boolean enabled = false;
    private static int level = 1;


    public static boolean get_state() {
        return enabled;
    }

    // Turn off effect
    public static void turn_off(Button button) {
        enabled = false;
    }

    // Get effect level
    public static int get_level() {
        return level;
    }

    // Set effect level one
    public static void set_level_one(Button button) {
        enabled = true;
        level = 0;
    }

    public static void set_level_two(Button button) {
        enabled = true;
        level = 1;
    }

    public static void set_level_three(Button button) {
        enabled = true;
        level = 2;
    }

    public static void set_level_four(Button button) {
        enabled = true;
        level = 3;
    }
}
