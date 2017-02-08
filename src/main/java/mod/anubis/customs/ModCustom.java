package mod.anubis.customs;

import mod.anubis.customs.crafting.Recipe;
import mod.anubis.customs.crafting.Crafting;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by winston_wang on 2017/2/5.
 */
public class ModCustom {
    public String Name;
    public String[][] Items;
    public mod.anubis.customs.crafting.Crafting Crafting;
    public ModCustom(String Name,String[][] Items,Crafting Crafting){
        this.Name = Name;
        this.Items = Items;
        this.Crafting = Crafting;
    }
    public void registers(){
        for(int i = 0;i < Items.length;i++){
            Item item = new Item().setUnlocalizedName(Items[i][0]).setRegistryName(Items[i][1]).setCreativeTab(CreativeTabs.MATERIALS);
            GameRegistry.register(item);
        }
        Recipe.furnaceRecipes(Crafting.furnaceRecipes);
        Recipe.worktableRecipes(Crafting.worktableRecipes);
    }
}
