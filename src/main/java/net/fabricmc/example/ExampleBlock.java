package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExampleBlock extends Block {

    public ExampleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {


        if (!world.isClient) {
            player.sendMessage(Text.of("Hello, world!"), false);
            player.sendMessage(Text.of(world.asString()), false);
            player.sendMessage(Text.of(player.toString()), false);
            player.sendMessage(Text.of(hand.toString()), false);
        }


        return ActionResult.SUCCESS;
    }
}
