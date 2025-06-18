package com.theweirdestfrog.tutorialmod.block.custom;

import com.theweirdestfrog.tutorialmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderAnnoyanceBlock extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;


    public EnderAnnoyanceBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.ENDER_DRAGON_DEATH, SoundSource.BLOCKS, 1f, 1f);
        player.move(MoverType.PLAYER, new Vec3(1.0, 1.0, 1.0));
        player.addItem(new ItemStack(ModItems.RAW_TIN.get(), 5));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(!level.isClientSide && entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == ModItems.TIN_INGOT.get()) {
                itemEntity.setItem(new ItemStack(Items.ACACIA_DOOR, itemEntity.getItem().getCount()));
            }
        } else {
            entity.move(MoverType.SELF, new Vec3(0, 5, 0));
        }


        super.stepOn(level, pos, state, entity);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        boolean flag = level.hasNeighborSignal(pos);
        if (flag != state.getValue(POWERED)) {
            if (flag) {
                level.playSound(null, pos, SoundEvents.ENDER_DRAGON_DEATH, SoundSource.BLOCKS, 1, 1);
            }

            level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)), 3);
        }
    }
}
