package committee.nova.mods.avaritia.client.render.entity;

import committee.nova.mods.avaritia.Static;
import committee.nova.mods.avaritia.common.entity.HeavenArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/4/20 18:54
 * Version: 1.0
 */
@OnlyIn(Dist.CLIENT)
public class HeavenArrowRender extends ArrowRenderer<HeavenArrowEntity> {

    private static final ResourceLocation tex = new ResourceLocation(Static.MOD_ID, "textures/entity/heavenarrow.png");


    public HeavenArrowRender(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HeavenArrowEntity entity) {
        return tex;
    }


}
