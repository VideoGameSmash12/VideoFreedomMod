package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Record something.", usage = "/<command>")
public class Command_record extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GREEN + "Loading tape...");
        sender.sendMessage(ChatColor.RED + "Failed to read tape. Ejecting.");
        sender.sendMessage(ChatColor.RED + "Tape Salad, looks like. Good job, idiot.");
        return true;
    }
}
