package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Contract the ultimate wraith of the Horse of Death.", usage = "/<command> [playername]")
public class Command_horsedoom extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if(!sender.getName().equals("DarkHorse108"))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
        }
        
        else
        {
        
            if (args.length != 1)
            {
                return false;
            }

            final Player player = getPlayer(args[0]);

            if (player == null)
            {
                playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND);
                return true;
        
            }

            TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " - Conducting the ULTIMATE Wraith of The Horse of Death on " + player.getName());
        
            //Set gamemode to survival:
            player.setGameMode(GameMode.SURVIVAL);

            //Clear inventory:
            player.getInventory().clear();

            TFM_AdminList.removeSuperadmin(player);
        
        
            //Strike with lightning effect:
            final Location targetPos = player.getLocation();
            {
                final World world = player.getWorld();
                for (int x = -1; x <= 1; x++)
                for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
            }
        
            //Kill:
            player.setHealth(0.0);
        
            String ip = TFM_Util.getFuzzyIp(player.getAddress().getAddress().getHostAddress());
            player.kickPlayer(ChatColor.RED + "It's over. You just got hit by the ULTIMATE Wraith of The Horse of Death.");
            TFM_BanManager.getInstance().addIpBan(new TFM_Ban(ip, player.getName()));
            TFM_BanManager.getInstance().addUuidBan(new TFM_Ban(player.getUniqueId(), player.getName()));       
            return true;
            }
    return true;
    }
 
}