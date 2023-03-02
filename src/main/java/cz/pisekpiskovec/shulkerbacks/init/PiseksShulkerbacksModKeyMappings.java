
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cz.pisekpiskovec.shulkerbacks.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import cz.pisekpiskovec.shulkerbacks.network.PutOnMessage;
import cz.pisekpiskovec.shulkerbacks.PiseksShulkerbacksMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PiseksShulkerbacksModKeyMappings {
	public static final KeyMapping PUT_ON = new KeyMapping("key.piseks_shulkerbacks.put_on", GLFW.GLFW_KEY_U, "key.categories.inventory");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(PUT_ON);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == PUT_ON.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						PiseksShulkerbacksMod.PACKET_HANDLER.sendToServer(new PutOnMessage(0, 0));
						PutOnMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
