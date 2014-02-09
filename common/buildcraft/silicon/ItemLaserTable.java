package buildcraft.silicon;

import buildcraft.core.ItemBlockBuildCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLaserTable extends ItemBlockBuildCraft {

	public ItemLaserTable(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
			case 0:
				return "tile.assemblyTableBlock";
			case 1:
				return "tile.assemblyWorkbenchBlock";
			case 2:
				return "tile.integrationTableBlock";
		}
		return super.getUnlocalizedName();
	}

	@Override
	public int getMetadata(int meta) {
		return meta <= 2 ? meta : 0;
	}
}
