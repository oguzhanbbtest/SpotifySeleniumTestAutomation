package com.spotify.test;
import com.spotify.driver.Driver;
import com.spotify.steps.TestSteps;
import org.junit.jupiter.api.Test;

public class SpotifyTest extends Driver {
        TestSteps step;

    @Test
    public void spotifyTest(){
        stepIn();
        step.loginSpotify();
        step.createPlaylist();
        step.changePlaylistName();
        step.playlistNameControl();
        step.clickSearchButton();
        step.sendKeySearchBox();
        step.clickSongsTab();
        step.addSongToPlayList();
        step.clickPlayList();
        step.playSecondSong();
        step.waitTenSecond();
        step.stopSong();
        step.deleteThirdSong();
        step.deletePlayList();
        step.controlDeletedPlaylist();
    }



    public void stepIn(){
        step = new TestSteps();
    }

}
