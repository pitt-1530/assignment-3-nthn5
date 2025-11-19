package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        int avgBpm = 0;
        for (int bpm : bpms) {
            avgBpm += bpm;
        }
        avgBpm /= bpms.size();
        if (avgBpm >= 140) {
            return "HIGH";
        } else if (avgBpm >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null || title.length() > 30 || title.isEmpty()) {
            return false;
        }
        for (char c : title.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        return Math.clamp(volumeDb, 0, 100);
    }
}
