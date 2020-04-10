package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Database database = Database.getInstance();
        ArtistController artistController = new ArtistController();
        artistController.create("Horia Brenciu", "Romania");
        artistController.findByName("Horia Brenciu");
        AlbumController albumController = new AlbumController();
        albumController.create("Am castigat!", 2, 2012);
        albumController.findByArtist(2);
    }
}
