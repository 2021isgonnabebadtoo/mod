
package net.mcreator.morecobblerev.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.morecobblerev.gui.GuiPray;
import net.mcreator.morecobblerev.MoreCobblerev;
import net.mcreator.morecobblerev.ElementsMoreCobblerev;

import java.util.Random;

@ElementsMoreCobblerev.ModElement.Tag
public class BlockKlaa extends ElementsMoreCobblerev.ModElement {
	@GameRegistry.ObjectHolder("morecobblerev:klaa")
	public static final Block block = null;
	public BlockKlaa(ElementsMoreCobblerev instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("klaa"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("morecobblerev:klaa", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.TNT);
			setUnlocalizedName("klaa");
			setSoundType(SoundType.METAL);
			setHardness(0.05F);
			setResistance(0.5F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
			super.randomDisplayTick(state, world, pos, random);
			EntityPlayer entity = Minecraft.getMinecraft().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			int i = x;
			int j = y;
			int k = z;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0, d1, d2, d3, d4, d5);
				}
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).openGui(MoreCobblerev.instance, GuiPray.GUIID, world, x, y, z);
			}
			return true;
		}
	}
}
