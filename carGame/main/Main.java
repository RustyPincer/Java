package main;

import game.*;
import game.utils.*;
import game.vehicles.*;
import java.io.*;
import java.util.*;

public class Main{
	
	public static Player loadPlayerFromFile(String playerName){
    File input = new File("users/" + playerName + ".txt");

    String[] data = null;
    try (BufferedReader bf = new BufferedReader(new FileReader(input))){
        String line = bf.readLine();
        data = line.split(" ");
				
				int money;
				try{
					money = Integer.parseInt(data[1]);
				}
				catch (Exception e){
					money = 0;
				}

        return new Player(playerName, data[0], money);
    } catch (IOException e) {
        System.out.println("IO error occured: " + e.getMessage());
    }

    return null;
	}
	
	public static void main(String[] args){
		Player p1 = loadPlayerFromFile("Daniel");
		System.out.println(p1);
		Player p2 = loadPlayerFromFile("Peter");
		System.out.println(p2);
		Player p3 = loadPlayerFromFile("Richard");
		System.out.println(p3);
		Player p4 = loadPlayerFromFile("Tamas");
		System.out.println(p4);
		Player p5 = loadPlayerFromFile("Zorror");
		System.out.println(p5);
		
		
		Player Daniel = loadPlayerFromFile("Daniel");
		
		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(new Car(200, 9000));
		cars.add(new Car(200, 10000));
		cars.add(new Car(150, 5000));
		cars.add(new Car(300, 20000));
		cars.add(new Car(300, 22000));
		cars.add(new Car(300, 20000));
		cars.add(new Car(200, 30000));

		try
		{
				Daniel.buyCar(cars.get(2));
				Daniel.buyCar(cars.get(3));
				Daniel.buyCar(cars.get(4));
				Daniel.buyCar(cars.get(6));

				System.out.println("Daniel's cars: " + Daniel.getSortedCars());
		}
		catch (VehicleException e)
		{
				System.out.println(e.getMessage());
		}
	}
}