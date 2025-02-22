package mysticmods.mysticalworld.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import mysticmods.mysticalworld.entity.SproutEntity;
import mysticmods.mysticalworld.init.ModLoot;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class IsColor implements LootItemCondition {
  private final boolean inverse;
  private final int variant;

  public IsColor(boolean inverseIn, String color) {
    this.inverse = inverseIn;
    this.variant = SproutEntity.StringToVariant(color);
  }

  @Override
  public boolean test(LootContext lootContext) {
    int variant;
    Entity looted = lootContext.getParamOrNull(LootContextParams.THIS_ENTITY);
    if (looted instanceof SproutEntity) {
      SproutEntity sprout = (SproutEntity) looted;
      variant = sprout.getEntityData().get(SproutEntity.variant);
    } else {
      variant = 0;
    }

    boolean flag = variant == this.variant;

    return flag == !this.inverse;
  }

  @Override
  public LootItemConditionType getType() {
    return ModLoot.IS_COLOR;
  }

  public static class ColorSerializer implements Serializer<IsColor> {
    @Override
    public void serialize(JsonObject json, IsColor value, JsonSerializationContext context) {
      json.addProperty("inverse", value.inverse);
      json.addProperty("color", SproutEntity.VariantToString(value.variant));
    }

    @Override
    public IsColor deserialize(JsonObject json, JsonDeserializationContext context) {
      return new IsColor(GsonHelper.getAsBoolean(json, "inverse", false), GsonHelper.getAsString(json, "color", "green"));
    }
  }

  public static LootItemCondition.Builder builder(String variant) {
    return () -> new IsColor(false, variant);
  }
}

