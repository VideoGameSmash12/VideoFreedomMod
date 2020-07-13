package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Op everyone on the server, optionally change everyone's gamemode at the same time.", usage = "/<command> [-c | -s]")
public class Command_opall extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.adminAction(sender.getName(), "Opping everyone on the server", false);

        boolean doSetGamemode = false;
        GameMode targetGamemode = GameMode.CREATIVE;
        if (args.length != 0)
        {
            if (args[0].equals("-c"))
            {
                doSetGamemode = true;
                targetGamemode = GameMode.CREATIVE;
                sender.sendMessage(ChatColor.GREEN + "Everyone has been OP'd and changed into Creative Mode.");
            }
            else if (args[0].equals("-s"))
            {
                doSetGamemode = true;
                targetGamemode = GameMode.SURVIVAL;
                sender.sendMessage(ChatColor.GREEN + "Everyone has been OP'd and changed into Survival Mode... and I wonder why you would do that...");
            }
        }

        for (Player player : server.getOnlinePlayers())
        {
            player.setOp(true);
            player.sendMessage(TotalFreedomMod.YOU_ARE_OP);

            if (doSetGamemode)
            {
                player.setGameMode(targetGamemode);
            }
        }

        return true;
    }
}
