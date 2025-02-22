package mysticmods.mysticalworld.client.model.armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;

/*public class BeetleArmorModel extends ArmorBaseModel {
  private final ModelPart headAnchor;
  private final ModelPart bodyAnchor;
  public final ModelPart armR;
  public final ModelPart armL;
  private final ModelPart legR;
  private final ModelPart bootR;
  private final ModelPart legL;
  private final ModelPart bootL;

  public BeetleArmorModel(EquipmentSlot slot) {
    super(slot, -1f, 1.0f, 64, 64);
    this.texHeight = 64;
    this.texWidth = 64;

    ModelPart[] slots = {head, body, rightArm, leftArm, leftLeg, leftLeg, rightLeg, rightLeg};

    for (ModelPart renderer : slots) {
      renderer.cubes.clear();
    }

    headAnchor = new ModelPart(this);
    headAnchor.setPos(-1.5F, -6.5F, -5.0F);
    headAnchor.texOffs(0, 11).addBox(-1.0F, 7.0F, 0.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
    headAnchor.texOffs(6, 11).addBox(-2.75F, 2.0F, 2.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
    headAnchor.texOffs(0, 30).addBox(-2.75F, 2.0F, 8.25F, 8.0F, 2.0F, 1.0F, 0.0F, false);
    headAnchor.texOffs(6, 11).addBox(4.75F, 2.0F, 2.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
    headAnchor.texOffs(0, 0).addBox(-3.0F, -2.0F, 0.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);

    ModelPart bottom_horn_piece_r1 = new ModelPart(this);
    bottom_horn_piece_r1.setPos(1.5F, -5.25F, 3.25F);
    headAnchor.addChild(bottom_horn_piece_r1);
    setRotationAngle(bottom_horn_piece_r1, -0.3927F, 0.0F, 0.0F);
    bottom_horn_piece_r1.texOffs(0, 16).addBox(-1.0F, -2.75F, -1.75F, 2.0F, 7.0F, 2.0F, 0.0F, false);
    bottom_horn_piece_r1.texOffs(0, 25).addBox(-1.0F, -2.75F, 0.25F, 2.0F, 2.0F, 3.0F, 0.0F, false);

    bodyAnchor = new ModelPart(this);
    bodyAnchor.setPos(-4.0F, 1.5F, -3.0F);
    bodyAnchor.texOffs(0, 46).addBox(-0.25F, 0.0F, 0.75F, 8.0F, 2.0F, 4.0F, 0.0F, false);
    bodyAnchor.texOffs(0, 46).addBox(0F, 6.0F, 0.75F, 8.0F, 2.0F, 4.0F, 0.0F, false);
    bodyAnchor.texOffs(8, 20).addBox(0.25F, -1.75F, 0.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);
    bodyAnchor.texOffs(8, 20).addBox(5.75F, -1.75F, 0.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);
    bodyAnchor.texOffs(0, 53).addBox(-0.5F, -1.0F, 5.0F, 9.0F, 10.0F, 1.0F, 0.0F, false);
    bodyAnchor.texOffs(0, 40).addBox(1.0F, 5.0F, 0.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);
    bodyAnchor.texOffs(0, 33).addBox(-0.5F, -1.0F, -0.5F, 9.0F, 6.0F, 1.0F, 0.0F, false);

    armR = new ModelPart(this);
    armR.setPos(7.75F, -5.5F, -2.0F);
    armR.texOffs(18, 18).addBox(-10.25F, 13.5F, -0.25F, 3.0F, 1.0F, 4.0F, 0.0F, true);
    armR.texOffs(18, 18).addBox(-10.25F, 12.0F, -0.25F, 3.0F, 1.0F, 4.0F, 0.0F, true);
    armR.texOffs(14, 40).addBox(-11.25F, 15.0F, -0.5F, 3.0F, 1.0F, 5.0F, 0.0F, true);
    armR.texOffs(38, 0).addBox(-11.25F, 11.0F, -0.5F, 2.0F, 4.0F, 5.0F, 0.0F, true);
    armR.texOffs(12, 22).addBox(-11.0F, 9.25F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
    armR.texOffs(22, 0).addBox(-11.25F, 3.25F, -0.5F, 3.0F, 6.0F, 5.0F, 0.0F, true);
    armR.texOffs(15, 11).addBox(-7.75F, 3.25F, 0.75F, 1.0F, 1.0F, 2.0F, 0.0F, true);

    ModelPart right_bottom_horn_r1 = new ModelPart(this);
    right_bottom_horn_r1.setPos(-11.25F, 3.0F, 3.5F);
    armR.addChild(right_bottom_horn_r1);
    setRotationAngle(right_bottom_horn_r1, 0.0F, 0.0F, -0.3927F);
    right_bottom_horn_r1.texOffs(22, 11).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);
    right_bottom_horn_r1.texOffs(10, 27).addBox(0.0F, -2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);

    armL = new ModelPart(this);
    armL.setPos(-7.75F, -5.5F, -2.0F);
    armL.texOffs(18, 18).addBox(6.5F, 13.5F, -0.25F, 3.0F, 1.0F, 4.0F, 0.0F, false);
    armL.texOffs(18, 18).addBox(6.5F, 12.0F, -0.25F, 3.0F, 1.0F, 4.0F, 0.0F, false);
    armL.texOffs(14, 40).addBox(8.25F, 15.0F, -0.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);
    armL.texOffs(38, 0).addBox(9.25F, 11.0F, -0.5F, 2.0F, 4.0F, 5.0F, 0.0F, false);
    armL.texOffs(12, 22).addBox(10.0F, 9.25F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    armL.texOffs(22, 0).addBox(7.75F, 3.25F, -0.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);
    armL.texOffs(15, 11).addBox(6.5F, 3.25F, 0.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

    ModelPart left_bottom_horn_r1 = new ModelPart(this);
    left_bottom_horn_r1.setPos(11.25F, 3.0F, 3.5F);
    armL.addChild(left_bottom_horn_r1);
    setRotationAngle(left_bottom_horn_r1, 0.0F, 0.0F, 0.3927F);
    left_bottom_horn_r1.texOffs(22, 11).addBox(0.0F, -2.0F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
    left_bottom_horn_r1.texOffs(10, 27).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

    legR = new ModelPart(this);
    legR.setPos(1.6284F, 6.652F, 0.0F);
    legR.texOffs(28, 11).addBox(-4F, -6.402F, -2.5F, 3.0F, 4.0F, 5.0F, 0.0F, true);
    legR.texOffs(19, 29).addBox(-3.9784F, 1.098F, -2.25F, 4.0F, 1.0F, 4.0F, 0.0F, true);
    legR.texOffs(19, 29).addBox(-3.9784F, -0.402F, -2.25F, 4.0F, 1.0F, 4.0F, 0.0F, true);
    legR.texOffs(16, 23).addBox(-1F, -5.152F, -2.25F, 1.0F, 2.0F, 4.0F, 0.0F, true);
    legR.texOffs(39, 11).addBox(-3.4784F, -0.902F, -2.5F, 3.0F, 4.0F, 1.0F, 0.0F, true);

    bootR = new ModelPart(this);
    bootR.setPos(0.025F, 11.5F, -2.75F);
    bootR.texOffs(20, 57).addBox(-2.125F, -0.9F, 0.0F, 4.0F, 2.0F, 5.0F, 0.0F, true);
    bootR.texOffs(20, 46).addBox(-2.125F, -1.9F, 3.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);

    ModelPart right_boot_plate_r1 = new ModelPart(this);
    right_boot_plate_r1.setPos(0.0F, 0.0F, 0.0F);
    bootR.addChild(right_boot_plate_r1);
    setRotationAngle(right_boot_plate_r1, -1.9635F, 0.0F, 0.0F);
    right_boot_plate_r1.texOffs(20, 34).addBox(-1.875F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, true);


    legL = new ModelPart(this);
    legL.setPos(-1.6284F, 0.152F, 0.0F);
    legL.texOffs(19, 29).addBox(-0F, 7.598F, -2.25F, 4.0F, 1.0F, 4.0F, 0.0F, false);
    legL.texOffs(19, 29).addBox(-0F, 6.098F, -2.25F, 4.0F, 1.0F, 4.0F, 0.0F, false);
    legL.texOffs(16, 23).addBox(-0.0216F, 1.348F, -2.25F, 1.0F, 2.0F, 4.0F, 0.0F, false);
    legL.texOffs(39, 11).addBox(0.5F, 5.598F, -2.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);
    legL.texOffs(28, 11).addBox(0.9784F, 0.098F, -2.5F, 3.0F, 4.0F, 5.0F, 0.0F, false);

    bootL = new ModelPart(this);
    bootL.setPos(-0.025F, 11.5F, -2.75F);
    bootL.texOffs(20, 57).addBox(-1.75F, -0.9F, 0.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
    bootL.texOffs(20, 46).addBox(-1.75F, -1.9F, 3.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

    ModelPart left_boot_plate_r1 = new ModelPart(this);
    left_boot_plate_r1.setPos(0.0F, 0.0F, 0.0F);
    bootL.addChild(left_boot_plate_r1);
    setRotationAngle(left_boot_plate_r1, -1.9635F, 0.0F, 0.0F);
    left_boot_plate_r1.texOffs(20, 34).addBox(-1.125F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

    headAnchor.visible = slot == EquipmentSlot.HEAD;
    bodyAnchor.visible = slot == EquipmentSlot.CHEST;
    armL.visible = slot == EquipmentSlot.CHEST;
    armR.visible = slot == EquipmentSlot.CHEST;
    legR.visible = slot == EquipmentSlot.LEGS;
    legL.visible = slot == EquipmentSlot.LEGS;
    bootL.visible = slot == EquipmentSlot.FEET;
    bootR.visible = slot == EquipmentSlot.FEET;
    hat.visible = false;

    head.addChild(headAnchor);
    body.addChild(bodyAnchor);
    rightArm.addChild(armR);
    leftArm.addChild(armL);
    leftLeg.addChild(legL);
    leftLeg.addChild(bootL);
    rightLeg.addChild(legR);
    rightLeg.addChild(bootR);
  }

  public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
    modelRenderer.xRot = x;
    modelRenderer.yRot = y;
    modelRenderer.zRot = z;
  }
}*/
