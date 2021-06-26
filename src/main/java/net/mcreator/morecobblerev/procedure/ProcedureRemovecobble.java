package net.mcreator.morecobblerev.procedure;

import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import net.mcreator.morecobblerev.ElementsMoreCobblerev;

import java.util.function.Supplier;
import java.util.Map;

@ElementsMoreCobblerev.ModElement.Tag
public class ProcedureRemovecobble extends ElementsMoreCobblerev.ModElement {
	public ProcedureRemovecobble(ElementsMoreCobblerev instance) {
		super(instance, 8);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Removecobble!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayerMP) {
			Container _current = ((EntityPlayerMP) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (0))).decrStackSize((int) (64));
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
