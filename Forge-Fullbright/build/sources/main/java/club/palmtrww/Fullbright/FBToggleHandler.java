package club.palmtrww.Fullbright;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FBToggleHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(KeyInputEvent event)
    {
        // make local copy of key binding object
        KeyBinding hotkey = ClientProxy.hotkey;

        // check if the hotkey has been pressed
        if (hotkey.isPressed())
        {
            //in case user starts with a gamma that is not normal
            if (Minecraft.getMinecraft().gameSettings.gammaSetting != 1.0 && Minecraft.getMinecraft().gameSettings.gammaSetting != 15.0)
            {
                Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Set gamma to default value." ));
            }
            else
            {
                //Switch the fullbright setting
                Minecraft.getMinecraft().gameSettings.gammaSetting = (((Minecraft.getMinecraft().gameSettings.gammaSetting+13)%28) + 1);
            }
        }
    }
}