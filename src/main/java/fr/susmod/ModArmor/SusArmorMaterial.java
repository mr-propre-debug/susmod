package fr.susmod.ModArmor;

import fr.susmod.ModItems.ModItems;
import fr.susmod.Susmod;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class SusArmorMaterial {
    public static final int BASE_DURABILITY = 33;
    public static final RegistryKey<EquipmentAsset> SUS_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Susmod.MOD_ID, "pieds"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_DIAMOND_ARMOR,
            SUS_ARMOR_MATERIAL_KEY
    );
}
