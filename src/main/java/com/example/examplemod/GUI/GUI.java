package com.example.examplemod.GUI;

import com.example.examplemod.Effects.*;
import com.example.examplemod.ExampleMod;
import com.example.examplemod.World.FindOres;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.components.VolumeSlider;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import javax.swing.plaf.SliderUI;
import java.awt.*;

public class GUI extends Screen {
    private final ResourceLocation texture = new ResourceLocation(ExampleMod.MODID, "textures/gui/stat_menu.png");

    public GUI(Component p_96550_) {
        super(p_96550_);
    }

    public GUI() {
        super(Component.translatable("unital.menu_screen.title"));
    }


    @Override
    public final void init() {
        addRenderableWidget(new Button(10, 10, 120, 20, Component.literal("Toggle Full Bright"), Fullbright::toggle));
        addRenderableWidget(new Button(135, 10, 120, 20, Component.literal("Toggle Strength"), Strength::toggle));
        addRenderableWidget(new Button(260, 10, 120, 20, Component.literal("Toggle Slow Falling"), SlowFalling::toggle));
        addRenderableWidget(new Button(385, 10, 120, 20, Component.literal("Toggle Water Breathing"), WaterBreathing::toggle));

        addRenderableWidget(new Button(10, 35, 120, 20, Component.literal("Toggle Regeneration"), Regeneration::toggle));
        addRenderableWidget(new Button(135, 35, 120, 20, Component.literal("Toggle Levitation"), Levitation::toggle));
        addRenderableWidget(new Button(260, 35, 120, 20, Component.literal("Toggle Fire Resistance"), FireResistance::toggle));

        addRenderableWidget(new Button(10, 70, 80, 20, Component.literal("Jump Boost Off"), JumpBoost::turn_off));
        addRenderableWidget(new Button(95, 70, 80, 20, Component.literal("Jump Boost 1"), JumpBoost::set_level_one));
        addRenderableWidget(new Button(180, 70, 80, 20, Component.literal("Jump Boost 2"), JumpBoost::set_level_two));
        addRenderableWidget(new Button(265, 70, 80, 20, Component.literal("Jump Boost 3"), JumpBoost::set_level_three));
        addRenderableWidget(new Button(350, 70, 80, 20, Component.literal("Jump Boost 4"), JumpBoost::set_level_four));

        addRenderableWidget(new Button(10, 95, 80, 20, Component.literal("Speed Off"), MovementSpeed::turn_off));
        addRenderableWidget(new Button(95, 95, 80, 20, Component.literal("Speed 1"), MovementSpeed::set_level_one));
        addRenderableWidget(new Button(180, 95, 80, 20, Component.literal("Speed 2"), MovementSpeed::set_level_two));
        addRenderableWidget(new Button(265, 95, 80, 20, Component.literal("Speed 3"), MovementSpeed::set_level_three));
        addRenderableWidget(new Button(350, 95, 80, 20, Component.literal("Speed 4"), MovementSpeed::set_level_four));

        addRenderableWidget(new Button(10, 120, 80, 20, Component.literal("Dig Speed Off"), DigSpeed::turn_off));
        addRenderableWidget(new Button(95, 120, 80, 20, Component.literal("Dig Speed 1"), DigSpeed::set_level_one));
        addRenderableWidget(new Button(180, 120, 80, 20, Component.literal("Dig Speed 2"), DigSpeed::set_level_two));
        addRenderableWidget(new Button(265, 120, 80, 20, Component.literal("Dig Speed 3"), DigSpeed::set_level_three));
        addRenderableWidget(new Button(350, 120, 80, 20, Component.literal("Dig Speed 4"), DigSpeed::set_level_four));

        addRenderableWidget(new Button(10, 145, 80, 20, Component.literal("Resistance Off"), Resistance::turn_off));
        addRenderableWidget(new Button(95, 145, 80, 20, Component.literal("Resistance 1"), Resistance::set_level_one));
        addRenderableWidget(new Button(180, 145, 80, 20, Component.literal("Resistance 2"), Resistance::set_level_two));
        addRenderableWidget(new Button(265, 145, 80, 20, Component.literal("Resistance 3"), Resistance::set_level_three));
        addRenderableWidget(new Button(350, 145, 80, 20, Component.literal("Resistance 4"), Resistance::set_level_four));

        addRenderableWidget(new Button(10, 180, 80, 20, Component.literal("Find Ores"), FindOres::toggle));
    }

//    @Override
//    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
////        this.renderBackground(p_96562_);
////        RenderSystem.setShader(GameRenderer::getPositionTexShader);
////        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
////        RenderSystem.setShaderTexture(0, texture);
////        blit(p_96562_, 0, 2, 0, 0, 192, 192);
////        super.render(p_96562_, p_96563_, p_96564_, p_96565_);
//    }

    private static void onPress(Button button) {
        System.out.println("Pressed");
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
