package com.bogdan.LinkedList_challenge;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Paris", "Rammstein");
        album.addSong("Sonne", 4.3);
        album.addSong("Keine lust", 4.1);
        album.addSong("Feuer frei", 3.6);
        album.addSong("Mutter", 4.16);
        album.addSong("Du hast", 4.03);
        album.addSong("Haifisch", 4.57);
        album.addSong("Ich will", 4.36);
        album.addSong("Engel", 4.18);
        album.addSong("Pussy", 4.20);
        album.addSong("Mein hertz brennt", 4.42);

        albums.add(album);

        album = new Album("Rammstein", "Rammstein");
        album.addSong("Auslander", 3.52);
        album.addSong("Deutchland", 4.52);
        album.addSong("Sex", 3.48);
        album.addSong("Puppe", 4.22);
        album.addSong("Diamant", 4.10);
        album.addSong("Tatto", 4.44);
        album.addSong("Weit weg", 4.09);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Reise, reise",playlist);
        albums.get(0).addToPlaylist("Keine lust",playlist);
        albums.get(0).addToPlaylist("Dalai lama",playlist);
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(7, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist){

        Scanner scanner = new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("Playlist is empty!");
            return;
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else{
                        System.out.println("You have reached the end of the playlist.");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now palying "+listIterator.previous().toString());
                    }else{
                        System.out.println("You have reached the top of the playlist");
                        forward=true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying "+listIterator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("We are at the start of the playlist");
                        }
                    }else if(!forward){
                        if(listIterator.hasNext()){
                            forward=true;
                            System.out.println("Now replaying "+listIterator.next().toString());
                        }else{
                            System.out.println("We are at the end of the palylist");
                        }
                    }
                    break;
                case 4:
                    printlist(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() >0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else{
                        System.out.println("Playlist is empty");
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: press\n");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list song in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printlist(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.listIterator();
        System.out.println("\n===============================\n");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n===============================");
    }
}
