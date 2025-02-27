package fr.susmod.ModItems;

import fr.susmod.ModArmor.Pieds;
import fr.susmod.ModArmor.SusArmorMaterial;
import fr.susmod.Susmod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Susmod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        Registry.register(Registries.ITEM_GROUP, SUSMOD_GROUP_KEY, SUSMOD_GROUP);
        ItemGroupEvents.modifyEntriesEvent(SUSMOD_GROUP_KEY).register((itemGroup) -> itemGroup.add(ModItems.SUS_SWORD));
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(SUSMOD_GROUP_KEY).register((itemGroup) -> itemGroup.add(ModItems.SUS_INGOT));
        ItemGroupEvents.modifyEntriesEvent(SUSMOD_GROUP_KEY).register((itemGroup) -> itemGroup.add(ModItems.PIEDS));


    }

    public static final RegistryKey<Item> SUS_SWORD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Susmod.MOD_ID, "sus_sword"));
    public static final Item SUS_SWORD = register(
            "sus_sword",
            settings -> new SusSword(ToolMaterial.DIAMOND, 200, -2.4f, settings),
            new Item.Settings()
    );
    public static final Item SUS_INGOT = register("sus_ingot", Item::new, new Item.Settings());

    public static final RegistryKey<ItemGroup> SUSMOD_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Susmod.MOD_ID, "item_group"));
    public static final ItemGroup SUSMOD_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SUS_SWORD)).displayName(Text.translatable("itemGroup.susmod")).build();


    public static final Item PIEDS = register(
            "pieds",
            settings -> new Pieds(SusArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(SusArmorMaterial.BASE_DURABILITY))
    );

}
