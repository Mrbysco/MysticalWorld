package mysticmods.mysticalworld.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;

import java.util.Random;

@SuppressWarnings("deprecation")
public class PetrifiedFlowerBlock extends FlowerBlock {
  public PetrifiedFlowerBlock(BlockBehaviour.Properties propertiesIn) {
    super(MobEffects.JUMP, 50, propertiesIn);
  }

  // TODO: Convert this into a supports_stonepetal_block tag
  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
    return state.is(Tags.Blocks.STONE) || state.is(Blocks.GRAVEL) || state.is(Tags.Blocks.ORES);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
    VoxelShape voxelshape = this.getShape(stateIn, worldIn, pos, CollisionContext.empty());
    Vec3 vector3d = voxelshape.bounds().getCenter();
    double d0 = (double) pos.getX() + vector3d.x;
    double d1 = (double) pos.getZ() + vector3d.z;

    for (int i = 0; i < 3; ++i) {
      if (rand.nextBoolean()) {
        worldIn.addParticle(ParticleTypes.ASH, d0 + rand.nextDouble() / 5.0D, (double) pos.getY() + (0.5D - rand.nextDouble()), d1 + rand.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
      }
    }

  }

  @Override
  public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
    if (!worldIn.isClientSide) {
      if (entityIn instanceof LivingEntity) {
        LivingEntity livingentity = (LivingEntity) entityIn;
        livingentity.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 2));
      }
    }
  }
}
