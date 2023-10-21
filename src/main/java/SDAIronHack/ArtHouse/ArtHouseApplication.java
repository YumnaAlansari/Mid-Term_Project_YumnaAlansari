package SDAIronHack.ArtHouse;

import SDAIronHack.ArtHouse.Model.ArtHouseLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtHouseApplication { //implements CommandLineRunner

	@Autowired
	ArtHouseLibrary artHouseLibrary;
	public static void main(String[] args) {

		SpringApplication.run(ArtHouseApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {

	}

	 */
}
