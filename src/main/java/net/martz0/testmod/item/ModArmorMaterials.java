package net.martz0.testmod.item;

import net.martz0.testmod.TestMod;
import net.martz0.testmod.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {

    public static final RegistryKey<EquipmentAsset> RAMA_CRYSTAL_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(TestMod.MOD_ID, "rama_crystal"));

    public static final ArmorMaterial RAMA_CRYSTAL_ARMOR = new ArmorMaterial(
            33,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 8,
                    EquipmentType.BOOTS, 3,
                    EquipmentType.BODY, 11
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.0F,
            ModTags.Items.RAMA_CRYSTAL_TOOL_MATERIALS,
            RAMA_CRYSTAL_ARMOR_MATERIAL_KEY
    );
}
