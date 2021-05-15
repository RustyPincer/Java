package game.vehicles;

import game.utils.*;
import game.*;

public class Car extends Vehicle implements Comparable<Car>{
	private final int maxSpeed,price;
	
	private Player owner;
		
	public Player getOwner()
	{
		return owner;
	}

	public void setOwner(Player newOwner)
	{
		this.owner = newOwner;
	}
	
	public Car(int maxSpeed, int price){
		this.maxSpeed = maxSpeed;
		this.price = price;
		this.owner = null;
	}
	
	public int getPrice(){return price;}
	
	@Override
	public void accelerate(double delta) throws VehicleException{
		if (getCurrentSpeed()+delta<=maxSpeed){
			accelerateCurrentSpeed(delta);
		}
	}
	
	@Override
	public String toString(){
		return id + ": maxSpeed=" + maxSpeed + " price=" + price;
	}
	
	@Override
	public int compareTo(Car that)
	{
			int compareResult = Integer.compare(this.maxSpeed, that.maxSpeed);

			if (compareResult == 0)
			{
					return Integer.compare(this.price, that.price);
			}
			else return compareResult;
	}
}