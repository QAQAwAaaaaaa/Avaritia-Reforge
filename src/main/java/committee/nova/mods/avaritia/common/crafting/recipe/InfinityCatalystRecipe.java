package committee.nova.mods.avaritia.common.crafting.recipe;

import com.google.gson.JsonObject;
import committee.nova.mods.avaritia.init.handler.SingularityRegistryHandler;
import committee.nova.mods.avaritia.init.registry.ModItems;
import committee.nova.mods.avaritia.init.registry.ModRecipeTypes;
import committee.nova.mods.avaritia.util.SingularityUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/7/10 12:41
 * Version: 1.0
 */
public class InfinityCatalystRecipe extends ShapelessExtremeCraftingRecipe {
    private boolean ingredientsLoaded = false;

    public InfinityCatalystRecipe(ResourceLocation recipeId, ItemStack output) {
        super(recipeId, NonNullList.create(), output);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        if (!this.ingredientsLoaded) {
            // add Singularity
            SingularityRegistryHandler.getInstance().getSingularities()
                    .stream()
                    .filter(singularity -> singularity.getIngredient() != Ingredient.EMPTY)
                    .limit(74)
                    .map(SingularityUtils::getItemForSingularity)
                    .map(Ingredient::of)
                    .forEach(super.getIngredients()::add);

            List<ItemStack> othersList = new ArrayList<>();


            // add others
            othersList.add(new ItemStack(Blocks.EMERALD_BLOCK));
            othersList.add(new ItemStack(ModItems.crystal_matrix_ingot.get()));
            othersList.add(new ItemStack(ModItems.neutronium_ingot.get()));
            othersList.add(new ItemStack(ModItems.cosmic_meatballs.get()));
            othersList.add(new ItemStack(ModItems.ultimate_stew.get()));
            othersList.add(new ItemStack(ModItems.endest_pearl.get()));
            othersList.add(new ItemStack(ModItems.record_fragment.get()));

            othersList.stream()
                    .map(Ingredient::of)
                    .forEach(super.getIngredients()::add);


            this.ingredientsLoaded = true;
        }

        return super.getIngredients();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.INFINITY_CATALYST_RECIPE.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.INFINITY_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<InfinityCatalystRecipe> {
        @Override
        public InfinityCatalystRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            return new InfinityCatalystRecipe(recipeId, new ItemStack(ModItems.infinity_catalyst.get()));
        }

        @Override
        public InfinityCatalystRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            return new InfinityCatalystRecipe(recipeId, new ItemStack(ModItems.infinity_catalyst.get()));
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, InfinityCatalystRecipe recipe) {
        }
    }
}
