package fr.susmod.ModItems;

import fr.susmod.Susmod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import fr.susmod.CustomSounds.CustomSounds;



public class SusSword extends SwordItem {
    public SusSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient) {
            target.playSound(CustomSounds.SWORD, 1.0f, 1.0f);
        }


        return super.postHit(stack, target, attacker);
    }
}
