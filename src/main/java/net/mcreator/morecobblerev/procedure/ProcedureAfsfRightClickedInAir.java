package net.mcreator.morecobblerev.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.morecobblerev.gui.GuiTest;
import net.mcreator.morecobblerev.MoreCobblerev;
import net.mcreator.morecobblerev.ElementsMoreCobblerev;

@ElementsMoreCobblerev.ModElement.Tag
public class ProcedureAfsfRightClickedInAir extends ElementsMoreCobblerev.ModElement {
	public ProcedureAfsfRightClickedInAir(ElementsMoreCobblerev instance) {
		super(instance, 10);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AfsfRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AfsfRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AfsfRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AfsfRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AfsfRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(MoreCobblerev.instance, GuiTest.GUIID, world, x, y, z);
	}
}
