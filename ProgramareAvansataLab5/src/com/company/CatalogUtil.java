package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        return (Catalog) objectInputStream.readObject();
    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String path = doc.getLocation();
        File file = new File(doc.getLocation());
        try {
            URI uri = new URI(path);
            desktop.browse(uri);
            return;
        } catch (URISyntaxException e) {
            System.out.println("This is invalid URI... Trying to load file...");
        }
        try{
            desktop.open(new File(path));
            return;
        }catch (IOException e){
            System.out.println("This not a file nor a URI");
        }
    }

}

