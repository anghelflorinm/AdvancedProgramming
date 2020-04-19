package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Database database = Database.getInstance();
        ArtistController artistController = new ArtistController();
       // artistController.create("Smiley", "Romania");
        artistController.findByName("Smiley");
        AlbumController albumController = new AlbumController();
        albumController.create("Am pierdut!", 2, 2012);
        albumController.findByArtist(6);
    }
}
