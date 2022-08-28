package com.spotify.steps;

import com.spotify.pages.GuestPage;
import com.spotify.pages.HomePage;
import com.spotify.pages.LoginPage;

public class TestSteps {
    GuestPage guestPage = new GuestPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    public void loginSpotify(){
        guestPage.closePopUp();
        guestPage.clickLoginButton();
        loginPage.loginSpotify();
        homePage.isHomePage();
        homePage.loginControl();
    }

    public void createPlaylist(){
        homePage.createPlaylist();
    }

    public void changePlaylistName(){
        homePage.changePlayListName();
    }

    public void playlistNameControl(){

        homePage.isPlaylistNameChanged();
    }

    public void clickSearchButton(){
        homePage.clickSearchButton();
    }

    public void sendKeySearchBox(){
        homePage.sendKeysearchBox();
    }

    public void clickSongsTab(){
        homePage.clickSongsTab();
    }

    public void addSongToPlayList() {
        homePage.addSongs();
    }

    public void clickPlayList() {
        homePage.clickPlayList();
    }

    public void playSecondSong() {
        homePage.playSecondSong();
    }

    public void waitTenSecond() {
        homePage.waitTenSecond();
    }
    public void stopSong(){
        homePage.stopSong();
    }

    public void deleteThirdSong() {
        homePage.deleteThirdSong();
    }

    public void deletePlayList() {
        homePage.deletePlayList();
    }

    public void controlDeletedPlaylist() {
        homePage.controlDeletedPlayList();
    }
}
