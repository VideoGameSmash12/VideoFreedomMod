package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "If the owner must, he will forcefully ban the super admin out of anger.", usage = "/<command> <playername>")
public class Command_videodoom extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("TheSuspense76"))
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
                sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
                return true;
            }

            TFM_Util.adminAction(sender.getName(), "Destroying " + player.getName() + " in full-force.", true);
            TFM_Util.bcastMsg(player.getName() + " shall die this very day!", ChatColor.RED);

            final String ip = player.getAddress().getAddress().getHostAddress().trim();

            // remove from superadmin
                if (TFM_AdminList.isSuperAdmin(player))
            {
                TFM_Util.adminAction(sender.getName(), "Erasing " + player.getName() + " from the superadmin list and existance.", true);
                TFM_AdminList.removeSuperadmin(player);
            }

            // remove from whitelist
            player.setWhitelisted(false);

            // deop
            player.setOp(false);

            // ban IPs
            for (String playerIp : TFM_PlayerList.getInstance().getEntry(player).getIps())
            {
                TFM_BanManager.getInstance().addIpBan(new TFM_Ban(playerIp, player.getName()));
            }

            // ban name
            TFM_BanManager.getInstance().addUuidBan(new TFM_Ban(player.getUniqueId(), player.getName()));

            // set gamemode to survival
            player.setGameMode(GameMode.SURVIVAL);

            // clear inventory
            player.closeInventory();
            player.getInventory().clear();

            // ignite player
            player.setFireTicks(10000);

            // generate explosion
            player.getWorld().createExplosion(player.getLocation(), 4F);

            // Shoot the player in the sky
            player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

            new BukkitRunnable()
            {
                @Override
                public void run()
               {
                    // strike lightning
                    player.getWorld().strikeLightning(player.getLocation());

                    // kill (if not done already)
                    player.setHealth(0.0);
               }
            }.runTaskLater(plugin, 2L * 20L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    // message
                    TFM_Util.adminAction(sender.getName(), "Slicing " + player.getName() + "'s head off, IP: " + ip, true);
                    // generate explosion
                    player.getWorld().createExplosion(player.getLocation(), 4F);
                
                
                    // kick player
                    player.kickPlayer(ChatColor.DARK_RED + "The anger is real. Get out of my sight. You disgust me.");
                }
            }.runTaskLater(plugin, 3L * 20L);

            return true;
        }
 
        return false;

    }
}