package com.lordcovale.umbra.items;

import com.lordcovale.umbra.tools.ModItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class CustomPickaxeItem extends PickaxeItem {

    public CustomPickaxeItem(ModItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder.addToolType(ToolType.PICKAXE, tier.getHarvestLevel()));

    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
