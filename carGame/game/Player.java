package game;

import java.util.*;
import game.vehicles.*;
import game.utils.*;

public class Player{
	private String name, IPAddress;
	private int money;
	private ArrayList<Car> cars;
	
	public Player(String name, String IPAddress, int money){
		if (name == null) throw new IllegalArgumentException("null name!");
		if (IPAddress == null || IPAddress.length()==0 || IPAddress.matches(".*\\s.*")) throw new IllegalArgumentException("illegal IP address!");
		if (money<0) throw new IllegalArgumentException("negative money!");
		
		this.name = name;
		this.IPAddress = IPAddress;
		this.money = money;
		cars = new ArrayList<>();
	}
	
	public int getMoney(){return money;}
	
	@Override
	public String toString(){
		return name + "; "+ IPAddress + "; "+ money + "; " + cars;
	}
	
	@Override
	public boolean equals(Object that) 
	{
			if (that == null) return false;
			if (that == this) return true;

			if (that instanceof Player)
			{
					Player thatPlayer = (Player)that;
					return this.name.equals(thatPlayer.name) && this.money == thatPlayer.money && 
							this.cars.equals(thatPlayer.cars);
			}
			else return false;
	}

	@Override
	public int hashCode()
	{
			return Objects.hash(name, money, cars); // 1 pont
	}
	
	public void buyCar(Car car) throws VehicleException
	{
			if (money < car.getPrice())
			{
					throw new VehicleException("buyCar(): player doesnt have enough money");
			}
			if (car.getOwner() != null)
			{
					throw new VehicleException("buyCar(): car already has an owner");
			}

			car.setOwner(this);
			cars.add(car);
			money -= car.getPrice();
	}
	
	
	public ArrayList<Car> getSortedCars()
	{
			ArrayList<Car> sortedCars = new ArrayList<Car>(cars);
			Collections.sort(sortedCars);
			return sortedCars;
	}

}