package mod.anubis.customs.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by winston_wang on 2017/2/7.
 */
public class Recipe {
    public static void furnaceRecipes(String[][] furnace_recipes){
        for(int i = 0;i<furnace_recipes.length;i++){
            GameRegistry.addSmelting(new ItemStack(Item.getByNameOrId(furnace_recipes[i][0])),new ItemStack(Item.getByNameOrId(furnace_recipes[i][1])),Float.parseFloat(furnace_recipes[i][2]));
        }
    }
    public static void worktableRecipes(String[][][] worktable_recipes){
        for(int i = 0;i<worktable_recipes.length;i++){
            ArrayList<String> items_1 = new ArrayList<String>();
            ArrayList<String> items_2 = new ArrayList<String>();
            for (int n = 0; n < worktable_recipes[i][1][3].split(";").length; n++) {
                try{
                    items_1.add(worktable_recipes[i][1][3].split(";")[n].split("-")[0]);
                    items_2.add(worktable_recipes[i][1][3].split(";")[n].split("-")[1]);
                }catch (Exception e){
                    break;
                }
            }
            ArrayList<Item> item = new ArrayList<Item>();
            ArrayList<Character> item_c = new ArrayList<Character>();
            for (int n = 0; n < items_1.size(); n++) {
                try{
                    char[] c_array = items_1.get(n).toCharArray();
                    item_c.add(c_array[0]);
                    item.add(Item.getByNameOrId(items_2.get(n)));
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
            Object[] mtls = new Object[]{worktable_recipes[i][1][0], worktable_recipes[i][1][1], worktable_recipes[i][1][2]};
            Object[] both = ArrayUtils.addAll(mtls, item_both.toArray());

            GameRegistry.addRecipe(new ItemStack(Item.getByNameOrId(worktable_recipes[i][0][0])), both);
        }
    }
}
