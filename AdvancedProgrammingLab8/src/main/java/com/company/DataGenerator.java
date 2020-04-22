package com.company;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.SQLOutput;
import java.util.*;

public class DataGenerator {
    AlbumController albumController;
    ArtistController artistController;
    ChartsController chartsController;
    Faker faker;

    public DataGenerator() {
        faker = new Faker();
        artistController = new ArtistController();
        albumController = new AlbumController();
        chartsController = new ChartsController();
    }

    public void generate() {
        generateCharts();
    }

    public void generateCharts() {
        for (int i = 0; i < 10; i++) {
            String genre = faker.music().genre();
            chartsController.createChart(genre);
        }
    }

    public void generateArtists() {
        for (int i = 0; i < 20; i++) {
            String name = faker.artist().name().replaceAll("\\P{Print}", "").replaceAll("[\\(\\)\\'\\\"]+", " ");
            String country = faker.country().name().replaceAll("\\P{Print}", "").replaceAll("[\\(\\)\\'\\\"]+", " ");
            artistController.create(name, country);
        }
    }

    public void generateAlbums(){
        List<Artist> artists = artistController.getArtists();
        for(Artist artist : artists){
            for(int i = 0; i< 12; i++){
                int year = faker.number().numberBetween(1950, 2020);
                String title = faker.animal().name().toUpperCase();
                albumController.create(title, artist.getId(), year);
            }
        }
    }

    public void generateChartPositions(){
        List<Album> albums = albumController.getAlbums();
        List<ChartName> chartNames = chartsController.getCharts();
        Collections.shuffle(albums);
        for(Album album : albums){
            int chartIndex = faker.number().numberBetween(0, chartNames.size()-1);
            chartsController.insertChartPosition(chartNames.get(chartIndex).getChartId(), album.getId());
        }
    }

    public void computeArtistsRanking(){
        List<Artist> artists = artistController.getArtists();
        for(Artist artist : artists){
            artist.setScore(artistController.computeScore(artist.getId()));
        }
        artists.sort(Collections.reverseOrder());
        int i = 1;
        for(Artist artist : artists){
            System.out.println(i + ". " + artist.getName() + " Scor: " + artist.getScore());
            i++;
        }
    }
}
