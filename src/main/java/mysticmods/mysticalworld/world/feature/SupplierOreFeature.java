package mysticmods.mysticalworld.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.BitSet;
import java.util.Random;

/*public class SupplierOreFeature extends Feature<SupplierOreFeatureConfig> {
  public SupplierOreFeature(Codec<SupplierOreFeatureConfig> p_i231976_1_) {
    super(p_i231976_1_);
  }

  @Override
  public boolean place(WorldGenLevel reader, ChunkGenerator generator, Random rand, BlockPos pos, SupplierOreFeatureConfig config) {
    float f = rand.nextFloat() * (float) Math.PI;
    float f1 = (float) config.size / 8.0F;
    int i = Mth.ceil(((float) config.size / 16.0F * 2.0F + 1.0F) / 2.0F);
    double d0 = (double) pos.getX() + Math.sin((double) f) * (double) f1;
    double d1 = (double) pos.getX() - Math.sin((double) f) * (double) f1;
    double d2 = (double) pos.getZ() + Math.cos((double) f) * (double) f1;
    double d3 = (double) pos.getZ() - Math.cos((double) f) * (double) f1;
    int j = 2;
    double d4 = (double) (pos.getY() + rand.nextInt(3) - 2);
    double d5 = (double) (pos.getY() + rand.nextInt(3) - 2);
    int k = pos.getX() - Mth.ceil(f1) - i;
    int l = pos.getY() - 2 - i;
    int i1 = pos.getZ() - Mth.ceil(f1) - i;
    int j1 = 2 * (Mth.ceil(f1) + i);
    int k1 = 2 * (2 + i);

    for (int l1 = k; l1 <= k + j1; ++l1) {
      for (int i2 = i1; i2 <= i1 + j1; ++i2) {
        if (l <= reader.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, l1, i2)) {
          return this.doGenerate(reader, rand, config, d0, d1, d2, d3, d4, d5, k, l, i1, j1, k1);
        }
      }
    }

    return false;
  }

  private boolean doGenerate(LevelAccessor worldIn, Random random, SupplierOreFeatureConfig config, double p_207803_4_, double p_207803_6_, double p_207803_8_, double p_207803_10_, double p_207803_12_, double p_207803_14_, int p_207803_16_, int p_207803_17_, int p_207803_18_, int p_207803_19_, int p_207803_20_) {
    int i = 0;
    BitSet bitset = new BitSet(p_207803_19_ * p_207803_20_ * p_207803_19_);
    BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
    int j = config.size;
    double[] adouble = new double[j * 4];

    for (int k = 0; k < j; ++k) {
      float f = (float) k / (float) j;
      double d0 = Mth.lerp((double) f, p_207803_4_, p_207803_6_);
      double d2 = Mth.lerp((double) f, p_207803_12_, p_207803_14_);
      double d4 = Mth.lerp((double) f, p_207803_8_, p_207803_10_);
      double d6 = random.nextDouble() * (double) j / 16.0D;
      double d7 = ((double) (Mth.sin((float) Math.PI * f) + 1.0F) * d6 + 1.0D) / 2.0D;
      adouble[k * 4] = d0;
      adouble[k * 4 + 1] = d2;
      adouble[k * 4 + 2] = d4;
      adouble[k * 4 + 3] = d7;
    }

    for (int i3 = 0; i3 < j - 1; ++i3) {
      if (!(adouble[i3 * 4 + 3] <= 0.0D)) {
        for (int k3 = i3 + 1; k3 < j; ++k3) {
          if (!(adouble[k3 * 4 + 3] <= 0.0D)) {
            double d12 = adouble[i3 * 4] - adouble[k3 * 4];
            double d13 = adouble[i3 * 4 + 1] - adouble[k3 * 4 + 1];
            double d14 = adouble[i3 * 4 + 2] - adouble[k3 * 4 + 2];
            double d15 = adouble[i3 * 4 + 3] - adouble[k3 * 4 + 3];
            if (d15 * d15 > d12 * d12 + d13 * d13 + d14 * d14) {
              if (d15 > 0.0D) {
                adouble[k3 * 4 + 3] = -1.0D;
              } else {
                adouble[i3 * 4 + 3] = -1.0D;
              }
            }
          }
        }
      }
    }

    for (int j3 = 0; j3 < j; ++j3) {
      double d11 = adouble[j3 * 4 + 3];
      if (!(d11 < 0.0D)) {
        double d1 = adouble[j3 * 4];
        double d3 = adouble[j3 * 4 + 1];
        double d5 = adouble[j3 * 4 + 2];
        int l = Math.max(Mth.floor(d1 - d11), p_207803_16_);
        int l3 = Math.max(Mth.floor(d3 - d11), p_207803_17_);
        int i1 = Math.max(Mth.floor(d5 - d11), p_207803_18_);
        int j1 = Math.max(Mth.floor(d1 + d11), l);
        int k1 = Math.max(Mth.floor(d3 + d11), l3);
        int l1 = Math.max(Mth.floor(d5 + d11), i1);

        for (int i2 = l; i2 <= j1; ++i2) {
          double d8 = ((double) i2 + 0.5D - d1) / d11;
          if (d8 * d8 < 1.0D) {
            for (int j2 = l3; j2 <= k1; ++j2) {
              double d9 = ((double) j2 + 0.5D - d3) / d11;
              if (d8 * d8 + d9 * d9 < 1.0D) {
                for (int k2 = i1; k2 <= l1; ++k2) {
                  double d10 = ((double) k2 + 0.5D - d5) / d11;
                  if (d8 * d8 + d9 * d9 + d10 * d10 < 1.0D) {
                    int l2 = i2 - p_207803_16_ + (j2 - p_207803_17_) * p_207803_19_ + (k2 - p_207803_18_) * p_207803_19_ * p_207803_20_;
                    if (!bitset.get(l2)) {
                      bitset.set(l2);
                      blockpos$mutable.set(i2, j2, k2);
                      if (config.target.test(worldIn.getBlockState(blockpos$mutable), random)) {
                        BlockState state = config.getState();
                        if (state.getBlock() != Blocks.AIR) {
                          worldIn.setBlock(blockpos$mutable, state, 2);
                        }
                        ++i;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    return i > 0;
  }
}*/
