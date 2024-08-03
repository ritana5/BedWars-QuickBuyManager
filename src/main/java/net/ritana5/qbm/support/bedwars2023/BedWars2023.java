package net.ritana5.qbm.support.bedwars2023;

import com.tomkeuper.bedwars.api.BedWars;
import com.tomkeuper.bedwars.api.arena.IArena;
import net.ritana5.qbm.QuickBuyManager;
import net.ritana5.qbm.utils.Support;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static net.ritana5.qbm.QuickBuyManager.bw2023Api;
import static net.ritana5.qbm.QuickBuyManager.support;

public class BedWars2023 {
    public BedWars2023() {
        start();
    }

    public static boolean isMode(IArena arena) {
        return JavaPlugin.getPlugin(QuickBuyManager.class).groups.contains(arena.getGroup().toLowerCase());
    }

    public void start() {
        support = Support.BEDWARS2023;
        bw2023Api = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();

        bw2023Api.getAddonsUtil().registerAddon(new Addon());
    }
}