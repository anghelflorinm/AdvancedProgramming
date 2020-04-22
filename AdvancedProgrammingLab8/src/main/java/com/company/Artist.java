package com.company;

public class Artist implements Comparable{
    private int id;
    private String name;
    private String country;
    private  float score;

    public Artist(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return (int)(this.getScore() - ((Artist)o).getScore());
    }
}
