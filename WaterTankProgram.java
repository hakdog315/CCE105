import javax.swing.*;

abstract class WaterTank{
	int capacity;
	int currentlevel;
	
	WaterTank(int capacity){
		this.capacity = capacity;
		this.currentlevel=0;
	}
	
	abstract void fillTank(int liters) ;
	abstract void useWater(int liters);
	abstract void checkStatus();

}
class HomeTank extends WaterTank{
	public HomeTank() {
		super(200);
	}


	void fillTank(int liters) {
	if (currentlevel + liters > capacity) {
		JOptionPane.showMessageDialog(null, "Cannot Fill tank! Exceeds the capacity limit");
		currentlevel = capacity;
		JOptionPane.showMessageDialog(null, "Tank Full. System Ended");
		System.exit(0);
	}else {
		currentlevel += liters;
		JOptionPane.showMessageDialog(null, liters + " liters added! Current Level: " + currentlevel + "/" + capacity);	
	} 
		
	}

	void useWater(int liters) {
		if (currentlevel - liters < 0) {
			currentlevel=capacity;
			JOptionPane.showMessageDialog(null, "Tank Empty. System Ended");
			System.exit(0);
		}else {
			currentlevel-=liters;
			JOptionPane.showMessageDialog(null, liters + " liters used! Current level: " + currentlevel + "/" + capacity);
		}
		
	}

	void checkStatus() {
		if (currentlevel == 0) {
			JOptionPane.showMessageDialog(null, "Tank is Empty");
		} else if(currentlevel == capacity) {
			JOptionPane.showMessageDialog(null, "Tank is Full");
		} else {
			JOptionPane.showMessageDialog(null, "Tank is in use");
		}
		
	}
}

class BuildingTank extends WaterTank{
	public BuildingTank() {
		super(800);
	}

	
	void fillTank(int liters) {
		if (currentlevel + liters > capacity) {
			JOptionPane.showMessageDialog(null, "Cannot Fill tank! Exceeds the capacity limit");
			currentlevel = capacity;
			JOptionPane.showMessageDialog(null, "Tank Full. System Ended");
			System.exit(0);
		}else {
			currentlevel += liters;
			JOptionPane.showMessageDialog(null, liters + " liters added! Current Level: " + currentlevel + "/" + capacity);	
		} 
			
		}
	


	void useWater(int liters) {
		if (currentlevel - liters < 0) {
			currentlevel=capacity;
			JOptionPane.showMessageDialog(null, "Tank Empty. System Ended");
			System.exit(0);
		}else {
			currentlevel-=liters;
			JOptionPane.showMessageDialog(null, liters + " liters used! Current level: " + currentlevel + "/" + capacity);
		}
		
	}

@Override
	void checkStatus() {
	if (currentlevel == 0) {
		JOptionPane.showMessageDialog(null, "Tank is Empty");
	} else if(currentlevel == capacity) {
		JOptionPane.showMessageDialog(null, "Tank is Full");
	} else {
		JOptionPane.showMessageDialog(null, "Tank is in use");
	}
		
	}
}
	
	

public class WaterTankProgram {

	public static void main(String[] args) {
		String tankChoice = JOptionPane.showInputDialog("Enter type of tank: (1) HomeTank (2) BuildingTank");
		WaterTank tank;
		
		if(tankChoice.equals("1")) {
			tank = new HomeTank();
			JOptionPane.showMessageDialog(null, "User chooses Home Tank (200 liters capacity)");
		}else {
			tank = new BuildingTank();
			JOptionPane.showMessageDialog(null, "User chooses Building Tank (800 liters capacity)");
			
			
		}
		
		while (true) {
			String act = JOptionPane.showInputDialog(null, "Choose action: (1) Fill Tank (2) Use Water (3) Check Capacity");
			
			if (act.equals("1")) {
				int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill"));
				tank.fillTank(liters);
			}else if (act.equals("2")) {
				int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use"));
				tank.useWater(liters);
			}else if (act.equals("3")) {
				tank.checkStatus();
			}
			
		}
		}

	
	}

	

