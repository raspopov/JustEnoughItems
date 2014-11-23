package mezz.jei.recipes.crafting;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import mezz.jei.api.gui.IGuiItemStacks;
import mezz.jei.util.Log;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShapedOreRecipeGui extends CraftingRecipeGui {

	@Override
	public void setGuiItemStacks(@Nonnull IGuiItemStacks guiItemStacks, @Nonnull Object recipe, @Nullable ItemStack focusStack) {
		ShapedOreRecipe shapedOreRecipe = (ShapedOreRecipe)recipe;

		int width;
		int height;
		try {
			width = ObfuscationReflectionHelper.getPrivateValue(ShapedOreRecipe.class, shapedOreRecipe, "width");
			height = ObfuscationReflectionHelper.getPrivateValue(ShapedOreRecipe.class, shapedOreRecipe, "height");
		} catch (Exception e) {
			Log.error("Error loading recipe", e);
			return;
		}

		setInput(guiItemStacks, shapedOreRecipe.getInput(), focusStack, width, height);
		setOutput(guiItemStacks, shapedOreRecipe.getRecipeOutput(), focusStack);
	}

}
