package committee.nova.mods.avaritia.init.compat;

import committee.nova.mods.avaritia.Static;
import committee.nova.mods.avaritia.common.block.CompressorBlock;
import committee.nova.mods.avaritia.common.tile.CompressorTileEntity;
import committee.nova.mods.avaritia.init.ModTooltips;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/5/15 23:21
 * Version: 1.0
 */
@WailaPlugin
public class JadeCompat implements IWailaPlugin {
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(ExampleComponentProvider.INSTANCE, CompressorBlock.class);
    }

    public enum ExampleComponentProvider implements IBlockComponentProvider {

        INSTANCE;

        @Override
        public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
            var compressor = (CompressorTileEntity) accessor.getBlockEntity();
            var recipe = compressor.getActiveRecipe();

            if (recipe != null) {
                var output = recipe.getResultItem(compressor.getLevel().registryAccess());
                tooltip.add(ModTooltips.CRAFTING.args(output.getCount(), output.getHoverName()).build());
            }
        }

        @Override
        public ResourceLocation getUid() {
            return new ResourceLocation(Static.MOD_ID, "compressor_jade");
        }

    }
}
