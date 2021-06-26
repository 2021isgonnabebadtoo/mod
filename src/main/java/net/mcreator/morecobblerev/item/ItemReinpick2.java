
package net.mcreator.morecobblerev.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.morecobblerev.procedure.ProcedureAfsfRightClickedInAir;
import net.mcreator.morecobblerev.ElementsMoreCobblerev;

import java.util.Set;
import java.util.HashMap;

@ElementsMoreCobblerev.ModElement.Tag
public class ItemReinpick2 extends ElementsMoreCobblerev.ModElement {
	@GameRegistry.ObjectHolder("morecobblerev:reinpick2")
	public static final Item block = null;
	public ItemReinpick2(ElementsMoreCobblerev instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("REINPICK2", 5, 3000, 8f, 0f, 10)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 5);
				return ret.keySet();
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureAfsfRightClickedInAir.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setUnlocalizedName("reinpick2").setRegistryName("reinpick2").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("morecobblerev:reinpick2", "inventory"));
	}
}
