package SDAIronHack.ArtHouse.component;

import SDAIronHack.ArtHouse.Service.impl.CinemaService;
import SDAIronHack.ArtHouse.Service.impl.MusicService;
import SDAIronHack.ArtHouse.Service.impl.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ArtHouseLibrary {

    @Autowired
    CinemaService cinemaService;
    @Autowired
    MusicService musicService;
    @Autowired
    TheatreService theatreService;

    Scanner input = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("\n************************************************");
        System.out.println("Welcome to Art House Management System Menu:");
        System.out.println("\n************************************************\n");

        System.out.println("We offer three different types of art!!");
        System.out.println("If you are interested in cinema and films, choose 1");
        System.out.println("If you are a music lover, choose 2");
        System.out.println("If you are a fan of theater and creativity, choose 3");


        System.out.println("To exit, choose 4\n");

        System.out.print("Please enter the number of the action you want to perform: \n");

    }


    public void Cinema(){

        // All, Id, Directory, release Year, category, Post, delete


    }
    public void Music(){}
    public void Theatre(){}
}
