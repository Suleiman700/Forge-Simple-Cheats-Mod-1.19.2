package com.example.examplemod.Keys;

import com.example.examplemod.Chat;
import com.example.examplemod.GUI.GUI;
//import com.example.examplemod.Render.Gui;
import com.example.examplemod.Player.PlayerTick;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeysPresses {
    private static boolean ready_to_detect_keys = false;

    public void set_ready_to_detect_keys(Boolean option) {
        ready_to_detect_keys = option;
//        if (option) {
//            Chat.SendMessage("MOD is ready to detect your keys");
//        }
//        else {
//            Chat.SendMessage("MOD is not ready to detect your keys");
//        }
    }

    @SubscribeEvent
    public void onKeyInputEvent(InputEvent.Key event) {
        int pressed_key = event.getKey();

//        System.out.println(pressed_key);

        // INS
        if (pressed_key == 260) {
            Minecraft.getInstance().setScreen(new GUI());
            if (ready_to_detect_keys) {
                this.set_ready_to_detect_keys(false);
            }
            else {
                ready_to_detect_keys = true;
                this.set_ready_to_detect_keys(true);
            }
        }

//        if (ready_to_detect_keys || true) {
//            // F12
//            if (pressed_key == 301) {
//                PlayerTick.enable_radar(true);
//                //            int falls = Fall.get_counter();
//                //            float max_fall_distance = Fall.get_max_fall_distance();
//                //            int jumps = Jump.get_counter();
//                //            Chat.SendLine();
//                //            Chat.SendMessage("Mob kills: " + Death.mob_kills_counter() + " | Damage dealt: " + Attack.get_damage_dealt_to_mobs());
//                //            Chat.SendMessage("Jumps: " + jumps + " | Falls: " + falls + " | Max fall distance: " + max_fall_distance);
//                //            Chat.SendMessage("Blocks placed: " + BlockPlace.get_counter() + " | Blocks broken: " + BlockBreak.get_counter());
//                //            Chat.SendMessage("Deaths: " + Death.get_counter());
//                //            Chat.SendMessage("Items picked: " + ItemPickup.get_item_pickup_counter());
//                //            Chat.SendMessage("Diamond: " + Diamond.get_counter() + " | Gold: " + Gold.get_counter() + " | Iron: " + Iron.get_counter() + " | Coal: " + Coal.get_counter());
//                //            Chat.SendLine();
//                ready_to_detect_keys = false;
//            }
//
//            // F10
//            else if (pressed_key == 299) {
//                PlayerTick.enable_radar(false);
//                //            Attack.reset_damage_dealt_to_mobs_counter();
//                //            Jump.reset_counters();
//                //            Fall.reset_counters();
//                //            BlockPlace.reset_counters();
//                //            BlockBreak.reset_counters();
//                //            Death.reset_counter();
//                //            ItemPickup.reset_item_pickup_counter();
//                //            Diamond.reset_counter();
//                //            Gold.reset_counter();
//                //            Iron.reset_counter();
//                //            Coal.reset_counter();
//                //            Chat.SendMessage("Counters has been rested");
//                ready_to_detect_keys = false;
//            }
//        }



//        System.out.println(event.getKey());
//        if (Minecraft.getInstance().options.keyRight.isDown()) {
//            System.out.println("options.keyRight.isDown");
//        }

//        if (Minecraft.getInstance().player.input.up) {
//
//        }
    }

//    @SubscribeEvent
//    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
//
//    }
}
