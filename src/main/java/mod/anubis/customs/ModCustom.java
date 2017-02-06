package mod.anubis.customs;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by winston_wang on 2017/2/5.
 */
public class ModCustom {
    public static class crafting{
        public String[][] furnace_recipes;
        public String[][][] worktable_recipes;
        public crafting(String[][] furnace_recipes,String[][][] worktable_recipes){
            this.furnace_recipes = furnace_recipes;
            this.worktable_recipes = worktable_recipes;
        }
    }
    public String name;
    public String[][] items;
    public crafting crafting;
    public ModCustom(String name,String[][] items,crafting crafting){
        this.name = name;
        this.items = items;
        this.crafting = crafting;
    }
    public void registers(){
        for(int i = 0;i < items.length;i++){
            Item item = new Item().setUnlocalizedName(items[i][0]).setRegistryName(items[i][1]).setCreativeTab(CreativeTabs.MATERIALS);
            GameRegistry.register(item);
            String name = GameData.getItemRegistry().getNameForObject(item).toString();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
        }
        for(int i = 0;i<crafting.furnace_recipes.length;i++){
            GameRegistry.addSmelting(new ItemStack(Item.getByNameOrId(crafting.furnace_recipes[i][0])),new ItemStack(Item.getByNameOrId(crafting.furnace_recipes[i][1])),Float.parseFloat(crafting.furnace_recipes[i][2]));
        }
        for(int i = 0;i<crafting.worktable_recipes.length;i++){
            ArrayList<String> items_1 = new ArrayList<String>();
            ArrayList<String> items_2 = new ArrayList<String>();
            for (int n = 0; n < crafting.worktable_recipes[i][1][3].split(";").length; n++) {
                try{
                items_1.add(crafting.worktable_recipes[i][1][3].split(";")[n].split("-")[0]);
                items_2.add(crafting.worktable_recipes[i][1][3].split(";")[n].split("-")[1]);
                }catch (Exception e){
                    break;
                }
            }
            ArrayList<Item> item = new ArrayList<Item>();
            ArrayList<Character> item_c = new ArrayList<Character>();
            for (int n = 0; n < items_1.size(); n++) {
                System.out.println(n);
                System.out.println(items_1.get(n));
                try{
                    char[] c_array = items_1.get(n).toCharArray();
                    item_c.add(c_array[0]);
                    item.add(Item.getByNameOrId(items_2.get(n)));
                    System.out.println(c_array[0]);
                }catch (Exception e){
                    break;
                }
            }
            ArrayList<Object> item_both = new ArrayList<Object>();
            for (int n = 0; n < item.size(); n++) {
                try{
                    item_both.add(item_c.get(n));
                    item_both.add(item.get(n));
                }catch (Exception e){
                    break;
                }
            }
            System.out.println(Arrays.toString(items));
            System.out.println(Arrays.toString(item.toArray()));
            System.out.println(Arrays.toString(item_c.toArray()));
            System.out.println(Arrays.toString(item_both.toArray()));
            Object[] mtls = new Object[]{crafting.worktable_recipes[i][1][0], crafting.worktable_recipes[i][1][1], crafting.worktable_recipes[i][1][2]};
            Object[] both = ArrayUtils.addAll(mtls, item_both.toArray());
            GameRegistry.addRecipe(new ItemStack(Item.getByNameOrId(crafting.worktable_recipes[i][0][0])), both);
        }
    }
}
