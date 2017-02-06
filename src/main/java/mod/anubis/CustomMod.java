package mod.anubis;

import com.google.gson.Gson;
import mod.anubis.customs.ModCustom;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CUSTOM_MOD_DIR = new File(event.getModConfigurationDirectory().getParentFile(), "/CustomMods/");
        if(!CUSTOM_MOD_DIR.exists()){
            event.getModLog().warn("CustomMods folder not found. Creating empty folder.");
            event.getModLog().warn("You should get some content packs and put them in the CustomMods folder.");
            CUSTOM_MOD_DIR.mkdirs();
        }
        File flist[] = CUSTOM_MOD_DIR.listFiles();
        if (flist != null || flist.length != 0) {
            for (File f : flist) {
                if (!f.isDirectory()) {
                    MOD_JSONS_FILE.add(f);
                }
            }
        }
        Gson gson = new Gson();
        for(int i = 0;i<MOD_JSONS_FILE.size();i++){
            String fileName = MOD_JSONS_FILE.get(i).getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if(suffix.equals("json")){
                StringBuilder result = new StringBuilder();
                try{
                    BufferedReader br = new BufferedReader(new FileReader(MOD_JSONS_FILE.get(i)));
                    String s = null;
                    while((s = br.readLine())!=null){
                        result.append(System.lineSeparator()+s);
                    }
                    br.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                ModCustom mod = gson.fromJson(result.toString(), ModCustom.class);
                MOD_JSONS.add(mod);
                event.getModLog().info("Load the CustomMod:"+mod.name);
                mod.registers();
            }
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
