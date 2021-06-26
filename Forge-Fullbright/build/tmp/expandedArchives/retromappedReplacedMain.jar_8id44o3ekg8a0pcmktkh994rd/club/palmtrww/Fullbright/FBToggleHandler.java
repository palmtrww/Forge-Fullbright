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
        if (hotkey.func_151468_f())
        {
            //in case user starts with a gamma that is not normal
            if (Minecraft.func_71410_x().field_71474_y.field_74333_Y != 1.0 && Minecraft.func_71410_x().field_71474_y.field_74333_Y != 15.0)
            {
                Minecraft.func_71410_x().field_71474_y.field_74333_Y = 1;
                Minecraft.func_71410_x().field_71439_g.func_145747_a(new ChatComponentText("Set gamma to default value." ));
            }
            else
            {
                //Switch the fullbright setting
                Minecraft.func_71410_x().field_71474_y.field_74333_Y = (((Minecraft.func_71410_x().field_71474_y.field_74333_Y+13)%28) + 1);
            }
        }
    }
}