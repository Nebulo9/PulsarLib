package fr.nebulo9.pulsarlib.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtil {
    private final ScoreboardManager scManager;

    private Scoreboard mainScoreboard;

    public ScoreboardUtil() {
        scManager = Bukkit.getScoreboardManager();
        mainScoreboard = scManager.getMainScoreboard();
    }

    public Objective addObjective(String name,String criteria,String displayName) {
        return mainScoreboard.registerNewObjective(name,criteria,displayName);
    }

    public void removeObjective(String name) {
        mainScoreboard.getObjective(name).unregister();
    }

    public Team addTeam(String id) {
        return mainScoreboard.registerNewTeam(id);
    }

    public void addLine(Objective objective,String teamId,String content,int score) {
        mainScoreboard.getTeam(teamId).addEntry(content);
        objective.getScore(content).setScore(score);
    }

    public void removeLine(String teamId, String content) {
        mainScoreboard.resetScores(content);
        mainScoreboard.getTeam(teamId).removeEntry(content);
    }

    public void apply(Player player) {
        player.setScoreboard(mainScoreboard);
    }
}
