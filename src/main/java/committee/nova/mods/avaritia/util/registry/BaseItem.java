package committee.nova.mods.avaritia.util.registry;

import net.minecraft.world.item.Item;

import java.util.function.Function;

/**
 * Author cnlimiter
 * CreateTime 2023/6/14 18:22
 * Name BaseItem
 * Description
 */

public class BaseItem extends Item {
    public BaseItem() {
        super(new Item.Properties());
    }

    public BaseItem(Function<Properties, Properties> properties) {
        super(properties.apply(new Properties()));
    }
}