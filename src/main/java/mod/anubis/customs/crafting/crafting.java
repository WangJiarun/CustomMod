package mod.anubis.customs.crafting;

/**
 * Created by winston_wang on 2017/2/7.
 */
public class Crafting{
    public String[][] furnaceRecipes;
    public String[][][] worktableRecipes;
    public Crafting(String[][] furnaceRecipes,String[][][] worktableRecipes){
        this.furnaceRecipes = furnaceRecipes;
        this.worktableRecipes = worktableRecipes;
    }
}
