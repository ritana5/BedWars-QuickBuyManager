package net.ritana5.qbm.listeners.bedwars2023;

import com.tomkeuper.bedwars.api.arena.GameState;
import com.tomkeuper.bedwars.api.arena.IArena;
import com.tomkeuper.bedwars.api.arena.team.TeamColor;
import com.tomkeuper.bedwars.api.events.gameplay.GameStateChangeEvent;
import net.ritana5.qbm.QuickBuyManager;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.material.Bed;
import org.bukkit.plugin.java.JavaPlugin;

public class BedWarsListener implements Listener {
    public BedWarsListener() {
    }

    @EventHandler
    public void onGameStart(GameStateChangeEvent event) {

    }
}
