package racingcar;

import java.util.ArrayList;

public class GameHelper {

	public static void raceGame(ArrayList<Car> cars) {
		for(int i=0;i<cars.size();i++) {
			Car car = cars.get(i);
			car.move();
		}
		
	}
	public static void printResult(ArrayList<Car> cars) {

		for(int i=0;i<cars.size();i++) {
			Car car = cars.get(i);
			int position = car.getPosition();
			System.out.print(car.getName() + " : ");
			
			for(int j=0;j<position;j++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
		
	}
    public static void printWinners(ArrayList<Car> cars) {
        
    	int maxPosition = 0;
        
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        System.out.print("최종 우승자: ");
        
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getPosition() == maxPosition) {
                System.out.print(car.getName());
            }
        }
    }
}






