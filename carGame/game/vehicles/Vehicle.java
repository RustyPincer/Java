package game.vehicles;

import game.utils.*;

public abstract class Vehicle{
	private static int idCounter = 0;
	protected int id = idCounter++;
	
	private double currentSpeed;
	
	public double getCurrentSpeed(){return currentSpeed;}
	
	protected final void accelerateCurrentSpeed(double delta) throws VehicleException{
		if (currentSpeed + delta < 0) throw new VehicleException("Current Speed would be negative!!!");
		
		currentSpeed += delta;
	}
	
	public abstract void accelerate(double delta) throws VehicleException;
}