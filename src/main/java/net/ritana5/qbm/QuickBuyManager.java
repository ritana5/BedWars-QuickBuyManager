package net.ritana5.qbm;

import net.ritana5.qbm.support.bedwars1058.BedWars1058;
import net.ritana5.qbm.support.bedwars2023.BedWars2023;
import net.ritana5.qbm.support.bwproxy1058.BWProxy1058;
import net.ritana5.qbm.support.bwproxy2023.BWProxy2023;
import net.ritana5.qbm.utils.Support;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public final class QuickBuyManager extends JavaPlugin {
    public static com.andrei1058.bedwars.api.BedWars bw1058Api;
    public static com.tomkeuper.bedwars.api.BedWars bw2023Api;
    public static Support support;
    public static QuickBuyManager instance;

    public QuickBuyManager() {
    }

    public static Logger log = Bukkit.getLogger();

    public void onEnable() {
        loadSupport();
        log = this.getLogger();
        instance = this;
    }

    private void loadSupport() {
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") != null) {
            new BedWars1058();
        } else if (Bukkit.getPluginManager().getPlugin("BedWars2023") != null) {
            new BedWars2023();
        } else if (Bukkit.getPluginManager().getPlugin("BedWarsProxy") != null) {
            new BWProxy1058();
        } else if (Bukkit.getPluginManager().getPlugin("BWProxy2023") != null) {
            new BWProxy2023();
        }
    }

    public void onDisable() {
    }

    public void initConfig(File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    }


    public static QuickBuyManager getInstance() {
        return instance;
    }

}