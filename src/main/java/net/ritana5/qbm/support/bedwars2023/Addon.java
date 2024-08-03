package net.ritana5.qbm.support.bedwars2023;

import com.tomkeuper.bedwars.api.BedWars;
import net.ritana5.qbm.QuickBuyManager;
import net.ritana5.qbm.listeners.bedwars2023.BedWarsListener;
import net.ritana5.qbm.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static net.ritana5.qbm.utils.Utils.color;


public class Addon extends com.tomkeuper.bedwars.api.addon.Addon {

    public Addon() {
    }

    @Override
    public String getAuthor() {
        return QuickBuyManager.instance.getDescription().getAuthors().get(0);
    }

    @Override
    public Plugin getPlugin() {
        JavaPlugin.getPlugin(QuickBuyManager.class);
        return QuickBuyManager.getInstance();
    }

    @Override
    public String getVersion() {
        return QuickBuyManager.instance.getDescription().getVersion();
    }

    @Override
    public String getDescription() {
        return QuickBuyManager.instance.getDescription().getDescription();
    }

    @Override
    public String getName() {
        return QuickBuyManager.instance.getDescription().getName();
    }

    public void initConfig(File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        JavaPlugin.getPlugin(QuickBuyManager.class).groups = config.getStringList("arena-groups").stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public void load() {
        Bukkit.getPluginManager().enablePlugin(JavaPlugin.getPlugin(QuickBuyManager.class));

        File folder = new File("plugins/BedWars2023/Addons/QuickBuyManager");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File configFile = new File(folder, "config.yml");
        if (!configFile.exists()) {
            try {
                Files.copy(JavaPlugin.getPlugin(QuickBuyManager.class).getResource("config.yml"), configFile.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        initConfig(configFile);

        Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
        QuickBuyManager.bw2023Api = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
        JavaPlugin.getPlugin(QuickBuyManager.class).placeSound = QuickBuyManager.bw2023Api.getForCurrentVersion("STEP_WOOL", "BLOCK_CLOTH_STEP", "BLOCK_CLOTH_STEP");
        JavaPlugin.getPlugin(QuickBuyManager.class).initConfig(configFile);
        JavaPlugin.getPlugin(QuickBuyManager.class).getServer().getPluginManager().registerEvents(new BedWarsListener(), JavaPlugin.getPlugin(QuickBuyManager.class));
        Bukkit.getConsoleSender().sendMessage("[BedWars2023] " + color("The BedWars-Voidless addon was originally contributed to by Kiiya and Zuyte."));
        Utils.info("&4B&ce&6d&eW&aa&9r&5s&d-&1V&2o&1i&2d&1l&2e&1s&2s");
        QuickBuyManager.log.info("Plugin Version: " + JavaPlugin.getPlugin(QuickBuyManager.class).getDescription().getVersion());
        if (!(JavaPlugin.getPlugin(QuickBuyManager.class).getDescription().getVersion().equals("1.0-SNAPSHOT"))) {
            QuickBuyManager.log.info("WARNING: You are using an outdated version of the plugin! Please update at or (WIP)");
        } else {
            QuickBuyManager.log.info(("You are running on the latest release!"));
        }
        QuickBuyManager.log.info("Server Version: " + JavaPlugin.getPlugin(QuickBuyManager.class).getServer().getVersion() + "\n");
        Utils.info("Running on: &fBedWars&c2023&r");
    }

    public void unload() {
        Bukkit.getPluginManager().disablePlugin(JavaPlugin.getPlugin(QuickBuyManager.class));
    }
}
