package net.mcreator.morecobblerev.procedure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import net.mcreator.morecobblerev.item.ItemAaaaaaaaaaaaa;
import net.mcreator.morecobblerev.ElementsMoreCobblerev;

@ElementsMoreCobblerev.ModElement.Tag
public class ProcedureTest1 extends ElementsMoreCobblerev.ModElement {
	public ProcedureTest1(ElementsMoreCobblerev instance) {
		super(instance, 21);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Test1!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Test1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Test1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Test1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Test1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAaaaaaaaaaaaa.block, (int) (1)))
				: false)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemAaaaaaaaaaaaa.block, (int) (1)).getItem(), -1, (int) 1, null);
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("morecobblerev", "ew_roject"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
	}
}
