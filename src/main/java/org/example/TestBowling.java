package org.example;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBowling {
    Games games;
    @Before
    public void setUp() {
        games = new Games();
    }

    @Test
    public void rollZeroScoreIsZero() {

        games.roll(0);
        assertEquals(0,games.score());

    }
    @Test
    public void openFrameAddPins() {

        games.roll(3);
        games.roll(5);
        assertEquals(8,games.score());
    }
    @Test
    public void spareAddsNextBall() {

        games.roll(4);
        games.roll(6);
        games.roll(3);
        games.roll(0);
        assertEquals(16,games.score());

    }
    @Test
    public void aTenInTwoFramesIsNotASpare() {

        games.roll(3);
        games.roll(6);
        games.roll(4);
        games.roll(2);
        assertEquals(15,games.score());

    }
    @Test
    public void aStrikeAddsNextBall() {
        games.roll(10);
        games.roll(3);
        games.roll(2);
        assertEquals(20,games.score());

    }
    @Test
    public void perfectGameScoreIs300() {
        for(int i = 0 ; i < 12 ; i++) games.roll(10);
        assertEquals(300,games.score());
    }

}
