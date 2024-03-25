package github.arovchinnikov.skyforged_dream.common.entity.creature;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class HamsterAnimation {
	public static final Animation WALK = Animation.Builder.create(0.5f).looping()
		.addBoneAnimation("front_right_leg",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0.5f, -1f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("front_left_leg",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0.25f, -1f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.5f, -1f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("back_right_leg",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0.25f, 1f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(-0.25f, 0f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.25f, 1f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("back_left_leg",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0.25f, 1f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("tail",
			new Transformation(Transformation.Targets.ROTATE,
				new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("right_ear",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("right_ear",
			new Transformation(Transformation.Targets.ROTATE,
				new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -5f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -2f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("head",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.25f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("left_ear",
			new Transformation(Transformation.Targets.TRANSLATE,
				new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.15f, 0f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -0.15f, 0f),
					Transformation.Interpolations.LINEAR)))
		.addBoneAnimation("left_ear",
			new Transformation(Transformation.Targets.ROTATE,
				new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 5f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 2f),
					Transformation.Interpolations.LINEAR),
				new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 2f),
					Transformation.Interpolations.LINEAR)))
		.build();
}
