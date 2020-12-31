package com.lordcovale.umbra.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class UmbralActivatior extends Block {
    public UmbralActivatior() {
        super(Properties.create(Material.ANVIL)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
}
