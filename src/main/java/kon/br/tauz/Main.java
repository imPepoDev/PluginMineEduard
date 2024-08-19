package kon.br.tauz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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

                if (command.getName().equalsIgnoreCase("gm") || command.getName().equalsIgnoreCase("gamemode")) {

                    // Verifica se o player possui a permissão para usar o comando /gm
                    if (!p.hasPermission("gamemode.use")) {
                        p.sendMessage(ChatColor.RED + "Você não possui permissão para usar este comando");
                    }
                    else {
                        // Cria uma variavel temporária para analisar o primeiro argumento pós uso do comando
                        String action = args[0];

                        // Verifica se o argumento é 1 ou creative e seta o GameMode creative
                        if (action.equalsIgnoreCase("1") || action.equalsIgnoreCase("creative")) {
                            p.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para CRIATIVO");
                            p.setGameMode(GameMode.CREATIVE);
                        }
                        // Verifica se o argumento é 0 ou survive e seta o GameMode survive
                        else if (action.equalsIgnoreCase("0") || action.equalsIgnoreCase("survive")) {
                            p.sendMessage(ChatColor.GREEN + "Seu modo de jogo foi alterado para SURVIVE");
                            p.setGameMode(GameMode.SURVIVAL);
                        }
                    }

                }



            }

            else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + " Você não é um player");
            }

            return false;
        }

}