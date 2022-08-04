package dev.realz.swordsmod.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class SwordsClient {


    public static void registerKeys() {
        KeyBinding abilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.rswords.abilities",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.rswords.swordsmod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (abilityKey.wasPressed()) {
                client.player.sendMessage(Text.literal("You've pressed the key!"), false);
            }
        });
    }
}
