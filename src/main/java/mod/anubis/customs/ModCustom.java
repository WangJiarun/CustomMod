package mod.anubis.customs;

import mod.anubis.customs.crafting.Recipe;
import mod.anubis.customs.crafting.crafting;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by winston_wang on 2017/2/5.
 */
public class ModCustom {
    public String name;
    public String[][] items;
    public mod.anubis.customs.crafting.crafting crafting;
    public ModCustom(String name,String[][] items,crafting crafting){
        this.name = name;
        this.items = items;
        this.crafting = crafting;
    }
    public void registers(){
        for(int i = 0;i < items.length;i++){
            Item item = new Item().setUnlocalizedName(items[i][0]).setRegistryName(items[i][1]).setCreativeTab(CreativeTabs.MATERIALS);
            GameRegistry.register(item);
        }
        Recipe.furnaceRecipes(crafting.furnace_recipes);
        Recipe.worktableRecipes(crafting.worktable_recipes);
    }
}
