package mod.anubis;

import com.google.gson.Gson;
import mod.anubis.customs.ModCustom;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.util.ArrayList;

@Mod(
        modid = CustomMod.MOD_ID,
        name = CustomMod.MOD_NAME,
        version = CustomMod.VERSION
)
public class CustomMod {
    public static final String MOD_ID = "custom_mod";
    public static final String MOD_NAME = "Custom-Mod";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static final ArrayList<File> MOD_JSONS_FILE = new ArrayList<File>();
    public static final ArrayList<ModCustom> MOD_JSONS = new ArrayList<ModCustom>();
    public static File CUSTOM_MOD_DIR;
    @SidedProxy(
            serverSide = "mod.anubis.CommonProxy",
            clientSide = "mod.anubis.ClientProxy"
    )
    public static CommonProxy proxy = new CommonProxy();
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
