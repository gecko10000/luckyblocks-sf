package io.github.thebusybiscuit.slimefunluckyblocks.surprises.unlucky;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import io.github.thebusybiscuit.slimefunluckyblocks.surprises.LuckLevel;
import io.github.thebusybiscuit.slimefunluckyblocks.surprises.Surprise;

public final class VoidHoleSurprise implements Surprise {
	
	@Override
	public String getName() {
		return "Void Hole";
	}

	@Override
	public void activate(Random random, Player p, Location l) {
		Location location = p.getLocation();
		int bX = location.getBlockX();
		int bZ = location.getBlockZ();
		for (int x = bX - 1; x <= bX + 1; x++) {
			for (int z = bZ - 1; z <= bZ + 1; z++) {
				for (int y = location.getBlockY() + 1; y >= location.getWorld().getMinHeight(); y--) {
					l.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
				}
			}
		}
	}

	@Override
	public LuckLevel getLuckLevel() {
		return LuckLevel.UNLUCKY;
	}

}
