package club.palmtrww.Fullbright;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * A lightweight, barebones Forge mod I created to allow easy switch between default
 * and fullbright gamma settings.
 *
 * @author hjongh
 */
@Mod(modid = Fullbright.MODID, name = Fullbright.MODNAME, version = Fullbright.VERSION)
public class Fullbright{
    public static final String MODID = "Fullbright";
    public static final String MODNAME = "Fullbright";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide="club.palmtrww.Fullbright.ClientProxy", serverSide="club.palmtrww.Fullbright.ServerProxy")
    public static CommonProxy proxy;

    @Instance
    public static Fullbright instance = new Fullbright();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}