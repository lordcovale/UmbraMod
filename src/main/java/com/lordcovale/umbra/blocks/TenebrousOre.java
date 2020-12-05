package com.lordcovale.umbra.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TenebrousOre extends Block {
    public TenebrousOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.BASALT)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
    }
}
