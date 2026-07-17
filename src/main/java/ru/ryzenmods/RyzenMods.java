package ru.ryzenmods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import ru.ryzenmods.client.util.MCUtil;
import ru.ryzenmods.client.util.player.Player;
import ru.ryzenmods.render.WaterMarkRenderer;


public class RyzenMods implements ModInitializer, MCUtil {
	public static KeyBinding toggleSprintKey;
	public static KeyBinding toggleFastExpKey;
	public static KeyBinding a123;
	public static Player plr;
	public static boolean isSprintToggled = false;
	public static boolean isFastExpToggled = false;
	public static boolean showStatus = false;
	public static boolean showStatus_HAND = false;
	private static final String KEY_CATEGORY = "key.categories.toggle_sprint";
	private static final String KEY_NAME_SPRINT = "key.toggle_sprint.toggle";
	private static final String KEY_NAME_EXP = "key.toggle_sprint.toggle_fastexp";

	public void onInitialize() {
		HudRenderCallback.EVENT.register(new WaterMarkRenderer());
		toggleSprintKey = new KeyBinding("key.toggle_sprint.toggle", InputUtil.Type.KEYSYM, 342, "key.categories.toggle_sprint");
		toggleFastExpKey = new KeyBinding("key.toggle_sprint.toggle_fastexp", InputUtil.Type.KEYSYM, 344, "key.categories.toggle_sprint");
		a123 = new KeyBinding("key.toggle_sprint.toggle_toggle", InputUtil.Type.KEYSYM, 343, "key.categories.toggle_sprint");
		KeyBindingHelper.registerKeyBinding(toggleSprintKey);
		KeyBindingHelper.registerKeyBinding(toggleFastExpKey);
		KeyBindingHelper.registerKeyBinding(a123);
		HudRenderCallback.EVENT.register((context, tickDelta) -> {
			if (mc.world != null && mc.player != null && showStatus_HAND) {
				TextRenderer textRenderer = mc.textRenderer;
				Text text = Text.literal("FastExp toggled");
				int x = 10;
				int y = 33;
				int y1 = 23;
				int color = -1;

				if (showStatus) {
					context.drawText(textRenderer, text, x, y, color, true);
				} else {
					context.drawText(textRenderer, text, x, y1, color, true);
				}



			}
		});
		HudRenderCallback.EVENT.register((context, tickDelta) -> {
			if (mc.world != null && mc.player != null && showStatus) {
				TextRenderer textRenderer = mc.textRenderer;
				Text text = Text.literal("Sprint toggled");
				int x = 10;
				int y = 23;
				int color = -1;

				context.drawText(textRenderer, text, x, y, color, true);

			}
		});


	}

	public static void onTick() {
		if (mc.world != null && mc.player != null) {
			while (toggleFastExpKey.wasPressed()) {
				isFastExpToggled = !isFastExpToggled;
				showStatus_HAND = isFastExpToggled;
				if (isFastExpToggled) {
					ClientTickEvents.END_CLIENT_TICK.register(client -> {
						if (mc.player != null && mc.world != null) {
							if (mc.options.useKey.isPressed()) {
								if (mc.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
									mc.player.networkHandler.sendPacket(
											new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, mc.player.getYaw(), mc.player.getPitch())
									);
								}

								if (mc.player.getOffHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
									mc.player.networkHandler.sendPacket(
											new PlayerInteractItemC2SPacket(Hand.OFF_HAND, 0, mc.player.getYaw(), mc.player.getPitch())
									);
								}
							}
						}
					});
				}
			}

					while (toggleSprintKey.wasPressed()) {
						isSprintToggled = !isSprintToggled;
						showStatus = isSprintToggled;
						boolean isMovingForward = mc.player.input.hasForwardMovement();
						boolean swim = mc.player.isSwimming();

						if (isMovingForward && mc.player.getHungerManager().getFoodLevel() > 6) {
							mc.options.sprintKey.setPressed(true);
							mc.player.setSprinting(true);
						} else {
							mc.options.sprintKey.setPressed(false);
							mc.player.setSprinting(false);
						}
						if (swim) {
							mc.options.sprintKey.setPressed(true);
							mc.player.setSprinting(true);
						}
					}

				}
			}
		}


