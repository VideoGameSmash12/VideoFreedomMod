package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "HEADSHOT! Time to bring out the pain!", usage = "/<command>")
public class Command_headshot extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("TheSuspense76")) {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
        }
        
        else
        {
            TFM_Util.bcastMsg(ChatColor.RED + "OOOH SHIT... VIDEO IS PISSED...");
            TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " - Destroying everyone on the server...");
            
            // OH GOD NO MERCY ON THE PLAYERS...
            
            for (Player player : server.getOnlinePlayers())
            {   
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");                
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg(ChatColor.RED + "I CAN'T WAIT TO FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                TFM_Util.bcastMsg("<" + sender.getName() + "> FUCK THIS CHAT!!!");
                
                player.setGameMode(GameMode.SURVIVAL);
                player.damage(50);
                player.setFoodLevel(0);
            }

            TFM_Util.bcastMsg(ChatColor.GREEN + sender.getName() + " is finally calmed... Don't piss him off ever again...");
        }
        return true;
    }
    
}
