package net.martz0.testmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent BANANA = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(2f)
            .build();
}
