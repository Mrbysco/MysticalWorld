package mysticmods.mysticalworld.items;

import mysticmods.mysticalworld.MysticalWorld;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

import java.util.List;

// TODO: Resynchronize with Patchouli
@SuppressWarnings("NullableProblems")
public class GuideItem extends Item {
  private static final ResourceLocation ENCYCLOPEDIA = new ResourceLocation(MysticalWorld.MODID, "world_guide");

  public GuideItem(Item.Properties properties) {
    super(properties);
  }

  public static Book getBook() {
    return BookRegistry.INSTANCE.books.get(ENCYCLOPEDIA);
  }

  @Override
  public Component getName(ItemStack stack) {
    Book book = getBook();
    return (book != null ? new TranslatableComponent(book.name) : super.getName(stack));
  }

  @Override
  public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
    super.appendHoverText(stack, worldIn, tooltip, flagIn);
    Book book = getBook();
/*    if (book != null && book.contents != null) {
      tooltip.add(book.getSubtitle().withStyle(ChatFormatting.GRAY));
    }*/
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
    ItemStack stack = playerIn.getItemInHand(handIn);
    Book book = getBook();
    if (book == null) {
      return InteractionResultHolder.fail(stack);
    } else {
/*      if (playerIn instanceof ServerPlayer) {
        NetworkHandler.sendToPlayer(new MessageOpenBookGui(book.id, null), (ServerPlayer) playerIn);
        SoundEvent sfx = PatchouliSounds.getSound(book.openSound, PatchouliSounds.book_open);
        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), sfx, SoundSource.PLAYERS, 1.0F, (float) (0.7D + Math.random() * 0.4D));
      }*/

      return InteractionResultHolder.success(stack);
    }
  }
}
