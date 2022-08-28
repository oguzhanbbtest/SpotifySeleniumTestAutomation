package com.spotify.pages;

import com.spotify.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Methods {

    private final Logger logger = LogManager.getLogger(HomePage.class);
    By homePage = By.xpath("//span[text()='Ana sayfa']");
    By usernameEl = By.cssSelector("figure[data-testid='user-widget-avatar'][title='Oguzhan']");

    By library = By.cssSelector("a[href='/collection']");

    By createPlaylist = By.xpath("//a[@class='Button-qlcn5g-0 gPMZVP']");
    By playlist = By.xpath("//button[@aria-label='1. Çalma Listem – Ayrıntıları düzenler']");
    By playlistName = By.xpath("//button[@aria-label='1. Çalma Listem – Ayrıntıları düzenler']");
    By playlistTextBox = By.xpath("//input[@data-testid='playlist-edit-details-name-input']");
    By playlistText = By.xpath("//input[@value='1. Çalma Listem']");
    By savePlayListName = By.xpath("//button[@data-testid='playlist-edit-details-save-button']");
    By newPlaylistName = By.xpath("//h1[text()='Spotify Listem']");
    By searchButton = By.xpath("//a[@href='/search']");
    By searchTextBox = By.xpath("//input[@placeholder='Ne dinlemek istiyorsun?']");
    By songsTab = By.xpath("//a[@href='/search/Daft%20Punk/tracks']");
    By firstSong = By.xpath( "(//div[@data-testid='tracklist-row'])[1]//button[@aria-haspopup=\"menu\"]");
    By secondSong = By.xpath( "(//div[@data-testid='tracklist-row'])[2]//button[@aria-haspopup=\"menu\"]");
    By thirdSong = By.xpath( "(//div[@data-testid='tracklist-row'])[3]//button[@aria-haspopup=\"menu\"]");
    By menuAddList = By.xpath("//span[text()='Çalma listesine ekle']");
    By menuPlaylist =By.xpath("//button//span[text()='Spotify Listem']");
    By songList = By.xpath("//li//a[@href=\"/playlist/2JH0ld3r0SUwE8UOpstjKD\"]");
    By songsPlayList = By.xpath("//div[@class=\"AINMAUImkAYJd4ertQxy\"]");
    By secondSongElm = By.xpath("(//button[@class=\"RfidWIoz8FON2WhFoItU\"])[2]");
    By durationTime = By.xpath("//div[@data-testid='playback-position']");
    By pauseButton = By.xpath("//button[@data-testid=\"control-button-playpause\"]");
    By playlistMenuDel = By.xpath("(//button[@aria-haspopup=\"menu\"])[4]");
    By songDeleteButton = By.xpath("//span[text()='Bu çalma listesinden kaldır']");
    By delete = By.xpath("//button//span[text()='Sil']");
    By deleteSSong = By.xpath("//span[@class=\"ButtonInner-sc-14ud5tc-0 jHsQoF encore-bright-accent-set\"]");
    By controlPlayList = By.xpath("//a//span[text()='Çalma listesi oluştur']");


   public void isHomePage(){
        String homePageText = getText(homePage);
        Assertions.assertEquals("Ana sayfa",homePageText);
        logger.info("[TEST PASSED]");
   }

   public void loginControl(){
       Assertions.assertTrue(isElementVisible(usernameEl,10));
       logger.info("[TEST PASSED]");
   }

   public void createPlaylist(){
       Assertions.assertTrue(isElementClickable(library,10));
       clickElement(library);
       Assertions.assertTrue(isElementClickable(createPlaylist,10));
       clickElement(createPlaylist);
       waitBySeconds(2);
       Assertions.assertTrue(isElementVisible(playlist,10),"you didnt create play list");

       logger.info("[TEST PASSED]");
   }

   public void changePlayListName(){

       Assertions.assertTrue(isElementClickable(playlistName,10));
       clickElement(playlistName);

       Assertions.assertTrue(isElementClickable(playlistTextBox,10));
       clickElement(playlistTextBox);

       findElementWait(playlistText).clear();
       findElementWait(playlistTextBox).sendKeys("Spotify Listem");

       Assertions.assertTrue(isElementClickable(savePlayListName,10));
       clickElement(savePlayListName);
   }

   public void isPlaylistNameChanged(){
       Assertions.assertEquals(findElementWait(newPlaylistName).getText(),"Spotify Listem","Playlist name didn't changed");
   }

   public void clickSearchButton(){
       Assertions.assertTrue(isElementClickable(searchButton,10));
       clickElement(searchButton);
   }

   public void sendKeysearchBox(){
       Assertions.assertTrue(isElementClickable(searchTextBox,10));
       clickElement(searchTextBox);
       sendKeys(searchTextBox,"Daft Punk");
   }

    public void clickSongsTab() {
       Assertions.assertTrue(isElementClickable(songsTab,10));
       clickElement(songsTab);
    }

    public void addSongs() {
        addSongfirst();
        addSongSecond();
        addSongThird();
    }

    public void addSongfirst(){
       hoverElement(firstSong);
       clickElement(firstSong);

       hoverElement(menuAddList);
       hoverElement(menuPlaylist);
       clickElement(menuPlaylist);
    }
    public void addSongSecond(){
        hoverElement(secondSong);
        Assertions.assertTrue(isElementClickable(secondSong,10));
        clickElement(secondSong);

        hoverElement(menuAddList);
        hoverElement(menuPlaylist);
        Assertions.assertTrue(isElementClickable(menuPlaylist,10));
        clickElement(menuPlaylist);
    }

    public void addSongThird(){
        hoverElement(thirdSong);
        Assertions.assertTrue(isElementClickable(thirdSong,10));
        clickElement(thirdSong);

        hoverElement(menuAddList);
        waitByMilliSeconds(330);
        hoverElement(menuPlaylist);
        waitByMilliSeconds(330);
        Assertions.assertTrue(isElementClickable(menuPlaylist,10));
        clickElement(menuPlaylist);
        waitBySeconds(5);
    }

    public void clickPlayList() {
       hoverElement(songsPlayList);
       Assertions.assertTrue(isElementClickable(songsPlayList,5));
       clickElement(songsPlayList);
    }

    public void playSecondSong(){
       scrollElement(secondSongElm);
       hoverElement(secondSongElm);
       clickElement(secondSongElm);
    }

    public void waitTenSecond() {
       waitBySeconds(13);
       stopSong();
    }

    public void stopSong(){
        // hoverElement(pauseButton);
        Assertions.assertTrue(isElementClickable(pauseButton,10));
        clickElementJs(pauseButton);
        // clickElement(pauseButton);
    }

    public void deleteThirdSong() {
       hoverElement(playlistMenuDel);
       Assertions.assertTrue(isElementClickable(playlistMenuDel,10));
       clickElement(playlistMenuDel);
       scrollElement(songDeleteButton);
       Assertions.assertTrue(isElementClickable(songDeleteButton,10));
       clickElement(songDeleteButton);
    }

    public void deletePlayList(){
       hoverElement(songsPlayList);
       Assertions.assertTrue(isElementClickable(songsPlayList,10));
       rightClick(songsPlayList);
       hoverElement(delete);
       Assertions.assertTrue(isElementClickable(delete,10));
       clickElement(delete);
       clickElementJs(deleteSSong);
    }

    public void controlDeletedPlayList(){
       Assertions.assertTrue(isElementVisible(controlPlayList,10));
    }
}
