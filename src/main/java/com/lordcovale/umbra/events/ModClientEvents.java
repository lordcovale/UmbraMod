package com.lordcovale.umbra.events;


import com.lordcovale.umbra.umbra;
import com.lordcovale.umbra.util.RegistryHandler;
import net.minecraft.advancements.criterion.ChangeDimensionTrigger;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resources.IResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Dimension;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = umbra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {


    @SubscribeEvent
    public static void onAttackWithPick(AttackEntityEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.TENEBROUS_PICK.get()) {
            if (event.getTarget().isAlive()) {

                if (player.getEntityWorld().isRemote) {
                    String msg = TextFormatting.LIGHT_PURPLE + "The Living Blood energizes the Tenebrous in your tool.";
                    player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                }
                //10% of attacks with the pick will unleash the Umbral energy
                Random rnd = new Random();

                if (rnd.nextFloat() <= 0.10f){
                    if (player.getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "The Umbral tool has absorbed enough Blood, It has drug you through the rift with it!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());


                    }


                }
            }
        }

    }
}
