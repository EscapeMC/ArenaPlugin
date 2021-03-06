package com.github.escapemc.arenaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.escapemc.arenaplugin.bases.Team;
import com.github.escapemc.arenaplugin.bases.TeamType;
import com.github.escapemc.arenaplugin.teams.BlueTeam;

public class CommandTeam implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Team.onlinePlayers = Bukkit.getOnlinePlayers().toString();
		Player p = (Player) sender;
		
		if(args.length == 0) {
			
			sender.sendMessage(ChatColor.AQUA + "/arena_team [check/assign/clear]");
			
		}else if(args[0].equalsIgnoreCase("check")) {
			
			if(Team.redTeam.contains(args[1])) {
					
				sender.sendMessage(ChatColor.RED + args[1] + " is on the Red Team.");
				
			}else if(Team.blueTeam.contains(args[1])) {
					
				sender.sendMessage(ChatColor.BLUE + args[1] + " is on the Blue Team.");
					
			}else{
				
				sender.sendMessage(ChatColor.AQUA + args[1] + " is not on a Team.");
				
			}

		}else if(args[0].equalsIgnoreCase("assign")) {
						
			if(args[2].equalsIgnoreCase("blue")) {
				
				if(Team.onlinePlayers.contains(args[1])) {
						
					Team.addToTeam(TeamType.BLUE, p, args[1]);
					for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						
						if(Team.blueTeam.contains(player.getName())) {
							
							player.setCustomName(player.getName() + ChatColor.BLUE + "(Blue)");
							
						}
						
					}
						
				}
					
			}else if(args[2].equalsIgnoreCase("red")) {
					
				if(Team.onlinePlayers.contains(args[1])) {
						
					Team.addToTeam(TeamType.RED, p, args[1]);
					for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						
						if(Team.redTeam.contains(player.getName())) {
							
							player.setCustomName(player.getName() + ChatColor.RED + "(Red)");
							
						}
					
					}
						
				}
					
			}
				
		}

		if(args[0].equalsIgnoreCase("remove")) {
			
			if(args.length == 1) {
				
				sender.sendMessage(ChatColor.AQUA + "You must specify a team to remove the player from.");
				
			}
							
			else if(args[2].equalsIgnoreCase("red")) {
				
				if(Team.redTeam.contains(args[1])) {
					
				Team.removeFromTeam(TeamType.RED, p, args[1]);
				
				}else{
					
					sender.sendMessage(ChatColor.AQUA + args[1] + " is not on that team!");
					
				}
				
			}
			
			else if(args[2].equalsIgnoreCase("blue")) {
				
				if(Team.blueTeam.contains(args[1])) {
					
				Team.removeFromTeam(TeamType.BLUE, p, args[1]);
				
				}else{
					
					sender.sendMessage(ChatColor.AQUA + args[1] + " is not on that team!");
					
				}
				
			}
				
		}				

		if(args[0].equalsIgnoreCase("clear")) {
			
			Team.clearTeams();
			sender.sendMessage(ChatColor.AQUA + "Cleared the Teams!");
			
		}
			
		return false;

	}

}
