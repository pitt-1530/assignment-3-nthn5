package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public void bpm140() {
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(List.of(140, 150, 160)));
    }

    @Test
    public void bpm100() {
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(List.of(100, 110, 120)));
    }

    @Test
    public void bpm90() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(List.of(80, 90, 95)));
    }

    @Test
    public void validTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("valid title"));
    }

    @Test
    public void invalidTitleSpecialChars() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("invalid@title"));
    }

    @Test
    public void invalidTitleTooLong() { 
        assertFalse(PlaylistRecommender.isValidTrackTitle("this title is fs more than thirty characters long so it aint valid"));
    }

    @Test
    public void normalizeVolumeNegative10() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }

    @Test
    public void normalizeVolume150() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
    }

    @Test
    public void normalizeVolume75() {
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));
    }
}
