package mod.anubis.customs.crafting;

/**
 * Created by winston_wang on 2017/2/7.
 */
public class crafting{
    public String[][] furnace_recipes;
    public String[][][] worktable_recipes;
    public crafting(String[][] furnace_recipes,String[][][] worktable_recipes){
        this.furnace_recipes = furnace_recipes;
        this.worktable_recipes = worktable_recipes;
    }
}
