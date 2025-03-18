package io.github.diycmd.world_protect;

import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.World;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.CommandTree;
import dev.jorel.commandapi.arguments.LiteralArgument;
import dev.jorel.commandapi.arguments.WorldArgument;
import dev.jorel.commandapi.executors.CommandExecutionInfo;
import dev.jorel.commandapi.executors.CommandExecutor;
import dev.jorel.commandapi.executors.ResultingCommandExecutor;

public class Command {
    private Set<World> protectWorlds;

    public Command(Set<World> protectWorlds) {
        this.protectWorlds = protectWorlds;
    }

    public void register() {
        CommandTree cmd = new CommandTree("wp");

        cmd.setPermission(CommandPermission.OP);

        CommandExecutor listProtected = (sender, args) -> {
            sender.sendMessage("以下のワールドが保護されてるよ！");
            for (World world : this.protectWorlds) {
                sender.sendMessage(ChatColor.GREEN + world.getName());
            }
        };

        CommandExecutionInfo protectInfo = (info) -> {
            info.sender().sendMessage(
                ChatColor.GREEN + "on" + ChatColor.RESET + "->保護！\n"
                    + ChatColor.GREEN + "off" + ChatColor.RESET + "->解除！\n"
                    + ChatColor.GREEN + "toggle" + ChatColor.RESET + "->切り替え！");
        };

        @SuppressWarnings("null")
        ResultingCommandExecutor protect2on = (sender, args) -> {
            World world = (World) args.get("dimension");

            if (this.protectWorlds.contains(world)) {
                sender.sendMessage(world.getName() + "は既に保護されてるよ！");
                return 0;
            }

            this.protectWorlds.add(world);
            sender.sendMessage(world.getName() + "を保護したよ！");
            return 1;
        };

        @SuppressWarnings("null")
        ResultingCommandExecutor protect2off = (sender, args) -> {
            World world = (World) args.get("dimension");

            if (!this.protectWorlds.contains(world)) {
                sender.sendMessage(world.getName() + "は既に保護されてないよ！");
                return 0;
            }

            this.protectWorlds.remove(world);
            sender.sendMessage(world.getName() + "の保護を解除したよ！");
            return 1;
        };

        @SuppressWarnings("null")
        CommandExecutor toggleProtect = (sender, args) -> {
            World world = (World) args.get("dimension");

            if (this.protectWorlds.contains(world)) {
                this.protectWorlds.remove(world);
                sender.sendMessage(world.getName() + "の保護を解除したよ！");
            } else {
                this.protectWorlds.add(world);
                sender.sendMessage(world.getName() + "を保護したよ！");
            }
        };

        cmd.executes(listProtected);

        cmd.then(
            new WorldArgument("dimension").executes(protectInfo)
                .then(new LiteralArgument("on").executes(protect2on))
                .then(new LiteralArgument("off").executes(protect2off))
                .then(new LiteralArgument("toggle").executes(toggleProtect)));

        cmd.register();
    }
}
