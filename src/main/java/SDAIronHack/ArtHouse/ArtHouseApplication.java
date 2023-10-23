package SDAIronHack.ArtHouse;

import SDAIronHack.ArtHouse.component.ArtHouseLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ArtHouseApplication { //implements CommandLineRunner

	@Autowired
	ArtHouseLibrary artHouseLibrary;
	public static void main(String[] args) {

		SpringApplication.run(ArtHouseApplication.class, args);
	}




	public void run(String... args) throws Exception {

        boolean exit = false;
		Scanner input = new Scanner(System.in);

		while (!exit) {
			artHouseLibrary.displayMenu();
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline

			switch (choice) {
				case 1:{
					artHouseLibrary.Cinema();
					break;
				}
				case 2:{
					artHouseLibrary.Music();
					break;
				}
				case 3:{
					artHouseLibrary.Theatre();
					break;
				}
				case 4:{
					System.out.println("Exiting the application.");
					input.close();
					System.exit(0);
					break;
				}
				default:
					System.out.println("Invalid choice. Please try again.");
			}


		}

	}

}
