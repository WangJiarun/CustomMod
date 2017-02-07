package mod.anubis.customs;

import mod.anubis.CustomMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by winston_wang on 2017/2/7.
 */
public class ModCustomClient extends ModCustom{
    public ModCustomClient(String name, String[][] items, mod.anubis.customs.crafting.crafting crafting){
        super(name,items,crafting);
    }
    public void registers(){
        for(int i = 0;i < items.length;i++){
            ModelLoader.setCustomModelResourceLocation(Item.getByNameOrId(CustomMod.MOD_ID+":"+items[i][1]), 0, new ModelResourceLocation(CustomMod.MOD_ID+":"+items[i][1], "inventory"));
        }
    }
}

