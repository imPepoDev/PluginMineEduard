package kon.br.tauz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

        @Override
        public void onEnable() {
            Bukkit.getConsoleSender().sendMessage("Hello World");
        }
        @Override
        public void onDisable() {
            Bukkit.getConsoleSender().sendMessage("Bye World");
        }


        public boolean onCommand(CommandSender sender, Command command, String label,String args[]) {

            if (sender instanceof Player) {
                Player p = (Player) sender;
                // help Command
                if (command.getName().equalsIgnoreCase("ajuda")) {
                    sender.sendMessage(ChatColor.AQUA + "Salve godenot");
                }

                // heal Command
                if (command.getName().equalsIgnoreCase("heal")) {
                    // Transforma o CommandSender em um player

                    if (p.getHealth() < 20) {
                        p.setHealth(20);
                        p.setFireTicks(0);
                        p.sendMessage(ChatColor.GREEN + "Sua vida foi recuperada.'");
                    }

                    else {
                        p.sendMessage(ChatColor.RED + "Sua vida já está cheia");
                    }

                }

                if (command.getName().equalsIgnoreCase("feed")) {
                    if (p.getFoodLevel() < 20) {
                        p.setFoodLevel(20);
                        p.sendMessage(ChatColor.GREEN + "Sua fome foi recuperada.'");
                    }

                    else {
                        p.sendMessage(ChatColor.RED + "Sua fome já está cheia");
                    }
                }



            }

            else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + " Você não é um player");
            }

            return false;
        }

}