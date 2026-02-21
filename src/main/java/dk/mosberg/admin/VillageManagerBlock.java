package dk.mosberg.admin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

/**
 * Custom block for the Village Manager, with loot table key override.
 */
public class VillageManagerBlock extends Block {
    public VillageManagerBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    // No override for getLootTableKey; use default Block behavior
}
