package com.example.examplemod.Player;

import com.example.examplemod.Chat;
import com.example.examplemod.Effects.*;
import com.example.examplemod.World.FindOres;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
//import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class PlayerTick {
    private static boolean enabled = false;

    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {
        // Check fullbright effect
        if (Fullbright.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 99999, 255));
        }
        else {
            event.player.removeEffect(MobEffects.NIGHT_VISION);
        }

        // Check jumpboost effect
        if (JumpBoost.get_state()) {
            int level = JumpBoost.get_level();
            event.player.addEffect(new MobEffectInstance(MobEffects.JUMP, 99999, level));
        }
        else {
            event.player.removeEffect(MobEffects.JUMP);
        }

        // Check movement speed effect
        if (MovementSpeed.get_state()) {
            int level = MovementSpeed.get_level();
            event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 99999, level));
        }
        else {
            event.player.removeEffect(MobEffects.MOVEMENT_SPEED);
        }

        // Check dig speed effect
        if (DigSpeed.get_state()) {
            int level = DigSpeed.get_level();
            event.player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 99999, level));
        }
        else {
            event.player.removeEffect(MobEffects.DIG_SPEED);
        }

        // Check strength effect
        if (Strength.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999));
        }
        else {
            event.player.removeEffect(MobEffects.DAMAGE_BOOST);
        }

        // Check resistance effect
        if (Resistance.get_state()) {
            int level = Resistance.get_level();
            event.player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 99999, level));
        }
        else {
            event.player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
        }

        // Check slow falling effect
        if (SlowFalling.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 99999));
        }
        else {
            event.player.removeEffect(MobEffects.SLOW_FALLING);
        }

        // Check water breathing effect
        if (WaterBreathing.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 99999));
        }
        else {
            event.player.removeEffect(MobEffects.WATER_BREATHING);
        }

        // Check regeneration effect
        if (Regeneration.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 99999, 255));
        }
        else {
            event.player.removeEffect(MobEffects.REGENERATION);
        }

        // Check levitation effect
        if (Levitation.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 99999));
        }
        else {
            event.player.removeEffect(MobEffects.LEVITATION);
        }

        // Check fire resistance effect
        if (FireResistance.get_state()) {
            event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 99999));
        }
        else {
            event.player.removeEffect(MobEffects.FIRE_RESISTANCE);
        }

        // Check find ores
        if (FindOres.get_state()) {
            boolean found_someting = false;

            double posX = event.player.position().x;
            double posY = event.player.position().y;
            double posZ = event.player.position().z;

            BlockPos pos1 = new BlockPos(posX-5, posY-5, posZ-5);
            BlockPos pos2 = new BlockPos(posX+5, posY+5, posZ+5);
            for (BlockPos p1 : BlockPos.betweenClosed(pos1, pos2)) {
                if (event.player.level.getBlockState(p1).getBlock() == Blocks.DIAMOND_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
                    Chat.SendMessage("Found diamond ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                    found_someting = true;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.ANCIENT_DEBRIS) {
                    Chat.SendMessage("Found ancient debris at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                    found_someting = true;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.IRON_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_IRON_ORE) {
                    Chat.SendMessage("Found iron ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                    found_someting = true;
                }
                else if (event.player.level.getBlockState(p1).getBlock() == Blocks.EMERALD_ORE || event.player.level.getBlockState(p1).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
                    Chat.SendMessage("Found emerald ore at " + p1.getX() + " " + p1.getY() + " " + p1.getZ());
                    found_someting = true;
                }
            }
            if (found_someting) {
                FindOres.disable();
                Chat.SendMessage("Ores finder is now disabled");
            }
        }
    }

//    public static void enable_radar(boolean option) {
//        enabled = option;
//        if (option) {
//            Chat.SendMessage("Blocks radar is now enabled");
//            found_someting = false;
//        }
//        else Chat.SendMessage("Blocks radar is now disabled");
//    }
}
