package epicsquid.mysticalworld.materials;

import epicsquid.mysticallib.event.RegisterContentEvent;
import epicsquid.mysticallib.types.OneTimeSupplier;
import epicsquid.mysticalworld.MysticalWorld;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreIngredient;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Used to add the various metals and metal components used in Mystical World and sub mods
 */
public abstract class Material implements IMaterial {
  private Item ingot;
  private Item nugget;
  private Item dust;
  private Item dustTiny;
  private Block block;
  private Block ore;
  private final float hardness;
  private final String oredictNameSuffix;
  private final float experience;
  private final int level;
  private final int minXP;
  private final int maxXP;
  private final Item.ToolMaterial material;
  private boolean hasTool;
  private OneTimeSupplier<Ingredient> repair;

  private Item axe;
  private Item hoe;
  private Item pickaxe;
  private Item shovel;
  private Item sword;

  public Material(@Nonnull String oredictNameSuffix, float hardness, float experience, int level, int minXP, int maxXP, Item.ToolMaterial material, boolean hasTool, String repair) {
    this.oredictNameSuffix = oredictNameSuffix;
    this.hardness = hardness;
    this.experience = experience;
    this.level = level;
    this.minXP = minXP;
    this.maxXP = maxXP;
    this.material = material;
    this.hasTool = hasTool;
    this.repair = new OneTimeSupplier<>(() -> new OreIngredient(repair));
  }

  public OneTimeSupplier<Ingredient> getRepairIngredient() {
    return this.repair;
  }

  @Override
  public boolean hasTool() {
    return hasTool;
  }

  @Override
  public Item.ToolMaterial getMaterial() {
    return material;
  }

  @Override
  public float getHardness() {
    return hardness;
  }

  @Override
  public float getExperience() {
    return experience;
  }

  @Override
  @Nonnull
  public String getOredictNameSuffix() {
    return oredictNameSuffix;
  }

  @Override
  @Nullable
  public Item getItem() {
    return ingot;
  }

  @Override
  @Nonnull
  public Item setItem(@Nonnull Item item) {
    this.ingot = item;
    return this.ingot;
  }

  @Override
  @Nullable
  public Item getDust() {
    return dust;
  }

  @Override
  @Nonnull
  public Item setDust(@Nonnull Item dust) {
    this.dust = dust;
    return this.dust;
  }

  @Override
  @Nullable
  public Item getDustTiny() {
    return dustTiny;
  }

  @Override
  @Nonnull
  public Item setDustTiny(@Nonnull Item dustTiny) {
    this.dustTiny = dustTiny;
    return this.dustTiny;
  }

  @Override
  @Nullable
  public Block getBlock() {
    return block;
  }

  @Override
  @Nonnull
  public Block setBlock(@Nonnull Block block) {
    this.block = block;
    block.setHarvestLevel("pickaxe", getLevel());
    return this.block;
  }

  @Override
  @Nullable
  public Item getNugget() {
    return nugget;
  }

  @Override
  @Nonnull
  public Item setNugget(@Nonnull Item nugget) {
    this.nugget = nugget;
    return this.nugget;
  }

  @Override
  @Nullable
  public Block getOre() {
    return ore;
  }

  @Override
  @Nonnull
  public Block setOre(@Nonnull Block ore) {
    this.ore = ore;
    return this.ore;
  }

  @Override
  public abstract boolean isEnabled();

  @Override
  public boolean hasGrindables() {
    return true;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public int getMinXP() {
    return minXP;
  }

  @Override
  public int getMaxXP() {
    return maxXP;
  }

  @Override
  public abstract void initMaterial(@Nonnull RegisterContentEvent event);

  @Override
  public abstract void initOreDictionary();

  public Item getAxe() {
    return axe;
  }

  public Item setAxe(Item axe) {
    this.axe = axe;
    return axe;
  }

  public Item getHoe() {
    return hoe;
  }

  public Item setHoe(Item hoe) {
    this.hoe = hoe;
    return hoe;
  }

  public Item getPickaxe() {
    return pickaxe;
  }

  public Item setPickaxe(Item pickaxe) {
    this.pickaxe = pickaxe;
    return pickaxe;
  }

  public Item getShovel() {
    return shovel;
  }

  public Item setShovel(Item shovel) {
    this.shovel = shovel;
    return shovel;
  }

  public Item getSword() {
    return sword;
  }

  public Item setSword(Item sword) {
    this.sword = sword;
    return sword;
  }
}
