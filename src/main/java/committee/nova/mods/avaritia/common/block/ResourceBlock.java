package committee.nova.mods.avaritia.common.block;

import committee.nova.mods.avaritia.api.common.block.BaseBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/2 6:55
 * Version: 1.0
 */
public class ResourceBlock extends BaseBlock {
    public ResourceBlock(MapColor color, SoundType soundType) {
        super(color, soundType, 25f, 1000f, true);
    }


    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos) {
        return 20.0f;
    }


}
