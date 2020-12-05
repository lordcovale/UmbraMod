package com.lordcovale.umbra.util;


import net.minecraft.world.Teleporter;
import net.minecraft.world.server.ServerWorld;

public class CustomTeleport extends Teleporter {

    public CustomTeleport(ServerWorld worldIn) {
        super(worldIn);
    }
}