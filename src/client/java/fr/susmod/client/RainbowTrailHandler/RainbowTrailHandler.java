package fr.susmod.client.RainbowTrailHandler;

import fr.susmod.ModItems.ModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.Vec3d;
import java.awt.Color;

public class RainbowTrailHandler {

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null && player.getInventory().getArmorStack(0).getItem() == ModItems.PIEDS) {
                spawnRainbowTrail(player);
            }
        });
    }

    private static void spawnRainbowTrail(PlayerEntity player) {

        Vec3d pos = player.getPos();
        for (int i = 0; i < 7; i++) {
            float red = (float) Math.sin((player.age + i) * 0.1) * 0.5f + 0.5f;
            float green = (float) Math.sin((player.age + i) * 0.1 + 2) * 0.5f + 0.5f;
            float blue = (float) Math.sin((player.age + i) * 0.1 + 4) * 0.5f + 0.5f;
            player.getWorld().addParticle(new DustParticleEffect(new Color(red, green, blue).getRGB(), 1.0f),
                    pos.getX(), pos.getY() + 0.1, pos.getZ(), 0, 0, 0);
        }
    }
}