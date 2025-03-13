package net.martz0.testmod.component;

import net.martz0.testmod.TestMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<Integer> TIMES_USED = register("times_used", builder -> builder
            .codec(Codecs.NON_NEGATIVE_INT)
    );

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TestMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        TestMod.LOGGER.info("Registering Data Component Types For " + TestMod.MOD_ID);
    }
}
