package me.StevenLawson.TotalFreedomMod.Commands;

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

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Contract the wraith of the Horse of Death. Painful, and bans the player.", usage = "/<command> [playername]")
public class Command_horsepower extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("DarkHorse108"))
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

        smite(player);

        return true;
    }
    return true;
    }
    
    public static void smite(final Player player)
    {
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Horse Of Death" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + "<" + ChatColor.RED + "DarkHorse108" + ChatColor.WHITE + "> WHAT THE FUCK IS WRONG WITH YOU?! I AM VERY DISAPPOINTED IN YOU, YOU DUMBASS!");
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Horse Of Death" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + "<" + ChatColor.RED + "DarkHorse108" + ChatColor.WHITE + "> YOU WILL NOW PAY FOR YOUR FATAL MISTAKE, WITH THE WRAITH OF THE HORSE OF DEATH!");
        
        //Set gamemode to survival:
        player.setGameMode(GameMode.SURVIVAL);

        //Clear inventory:
        player.getInventory().clear();

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
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Horse Of Death" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + "<" + ChatColor.RED + "DarkHorse108" + ChatColor.WHITE + "> OH BOY, YOU DIDN'T LISTEN, DIDN'T YOU?! WELL THERE IS THE REST OF THE WRAITH, YOU DISCRACE OF MANKIND!");
        player.kickPlayer(ChatColor.RED + "GET OUT, YOU JUST FELT THE UNLIKABLE PAIN OF THE HORSE OF DEATH SO YOU DESERVE THE PAIN.");
        TFM_BanManager.getInstance().addIpBan(new TFM_Ban(ip, player.getName()));
        TFM_BanManager.getInstance().addUuidBan(new TFM_Ban(player.getUniqueId(), player.getName()));        
       
    }
}
