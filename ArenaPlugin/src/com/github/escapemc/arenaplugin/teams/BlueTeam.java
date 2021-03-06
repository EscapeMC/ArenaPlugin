package com.github.escapemc.arenaplugin.teams;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.github.escapemc.arenaplugin.bases.Team;

public class BlueTeam extends Team {

	public static void setBlueSpawn(double posX, double posY, double posZ, Player playerIn) {
		
		spawnX = posX;
		spawnY = posY;
		spawnZ = posZ;
				
		posX = playerIn.getLocation().getX();
		posY = playerIn.getLocation().getY();
		posZ = playerIn.getLocation().getZ();
		
		Player p = (Player) playerIn;
		Location loc = p.getLocation();
		
		World w = loc.getWorld();
		
		Location teleLocBlue = new Location(w, posX, posY, posZ);

		playerIn.sendMessage(ChatColor.BLUE + "Blue Team Spawn set to " + posX + " " + posY + " " + posZ);
		
	}
	
}
