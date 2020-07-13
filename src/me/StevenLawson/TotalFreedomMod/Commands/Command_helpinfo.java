package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(
        description = "Exclusive command that is only available for VideoFreedom. Gives info on help.",
        usage = "/<command>",
        aliases = "infohelp")
public class Command_helpinfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        {
            playerMsg(ChatColor.DARK_GREEN + "You want help? Here's what you can do.");
            playerMsg(ChatColor.GREEN + "You can ask help from a" + ChatColor.GOLD + "Super" + ChatColor.AQUA + "Admin" + ChatColor.GREEN + "+ or other players.");
            playerMsg(ChatColor.GREEN + "");
        }
        return true;
    }
}
