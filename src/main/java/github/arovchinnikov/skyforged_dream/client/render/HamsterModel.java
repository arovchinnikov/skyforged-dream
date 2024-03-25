package github.arovchinnikov.skyforged_dream.client.render;

import github.arovchinnikov.skyforged_dream.common.entity.creature.HamsterAnimation;
import github.arovchinnikov.skyforged_dream.common.entity.creature.HamsterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class HamsterModel<T extends HamsterEntity> extends SinglePartEntityModel<T> {
	private final ModelPart body;
	private final ModelPart marshroom;
	private final ModelPart marshroom2;
	private final ModelPart marshroom3;
	public HamsterModel(ModelPart root) {
		this.body = root.getChild("body");
		this.marshroom = root.getChild("marshroom");
		this.marshroom2 = root.getChild("marshroom2");
		this.marshroom3 = root.getChild("marshroom3");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -3.0F, -4.0F, 10.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 1.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 21).cuboid(-3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 9.0F, new Dilation(0.0F))
		.uv(21, 21).cuboid(-4.0F, -3.0F, -5.0F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(25, 14).cuboid(-3.0F, -3.0F, 5.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(25, 11).cuboid(-4.0F, -2.0F, 5.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -6.0F, 4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(21, 24).cuboid(-4.0F, -0.5F, -1.0F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -4.5F, -5.0F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(29, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, 0.0F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(29, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -1.0F, 0.0F));

		ModelPartData back_right_leg = body.addChild("back_right_leg", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -0.5F, 4.0F));

		ModelPartData front_left_leg = body.addChild("front_left_leg", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -0.5F, -3.0F));

		ModelPartData back_left_leg = body.addChild("back_left_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -0.5F, 4.0F));

		ModelPartData front_right_leg = body.addChild("front_right_leg", ModelPartBuilder.create().uv(0, 14).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -0.5F, -3.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -1.8333F, -1.1667F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 10).cuboid(0.0F, -0.8333F, -0.1667F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(3, 24).cuboid(-1.0F, 0.1667F, -0.1667F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.1667F, 6.1667F));

		ModelPartData marshroom = modelPartData.addChild("marshroom", ModelPartBuilder.create().uv(0, 20).cuboid(2.0F, -7.0F, -3.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 27).cuboid(1.0F, -7.0F, -2.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F))
		.uv(25, 18).cuboid(-1.0F, -8.0F, -2.0F, 6.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 21).cuboid(0.0F, -9.0F, -2.0F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(29, 1).cuboid(1.0F, -10.0F, -2.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(25, 7).cuboid(2.0F, -8.0F, -5.0F, 0.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(2.0F, -9.0F, -4.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 25).cuboid(2.0F, -10.0F, -3.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

		ModelPartData marshroom2 = modelPartData.addChild("marshroom2", ModelPartBuilder.create().uv(4, 20).cuboid(2.0F, -7.0F, -3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 28).cuboid(1.0F, -7.0F, -2.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(25, 17).cuboid(-1.0F, -8.0F, -2.0F, 6.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(0.0F, -9.0F, -2.0F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(29, 0).cuboid(1.0F, -10.0F, -2.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 25).cuboid(2.0F, -8.0F, -5.0F, 0.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(2.0F, -9.0F, -4.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(4, 24).cuboid(2.0F, -10.0F, -3.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 24.0F, 5.0F));

		ModelPartData marshroom3 = modelPartData.addChild("marshroom3", ModelPartBuilder.create().uv(25, 16).cuboid(-1.0F, -8.0F, -2.0F, 6.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(0.0F, -9.0F, -2.0F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(25, 19).cuboid(1.0F, -10.0F, -2.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(21, 23).cuboid(2.0F, -8.0F, -5.0F, 0.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(2.0F, -9.0F, -4.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(2.0F, -10.0F, -3.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 26.0F, 2.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(HamsterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.animateMovement(HamsterAnimation.WALK, limbAngle, limbDistance, 2f, 2.5f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		marshroom.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		marshroom2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		marshroom3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return body;
	}
}