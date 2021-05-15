package game.vehicles;

import game.utils.*;

public class Train extends Vehicle{
	@Override
	public void accelerate(double delta) throws VehicleException{
		accelerateCurrentSpeed(delta < 0 ? delta/10 : delta);
	}
}