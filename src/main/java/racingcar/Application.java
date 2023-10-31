package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
    	int attemptNum;
    	List<Integer> carRecord;
    	List<String> carName;
    	CheckExceptions checkException = new CheckExceptions();
    	Player player = new Player();
    	player.inputCarName();
    	carName = player.carName;
    	checkException.checkCarNameLength(carName);
    	checkException.checkNotNull(carName);
    	player.inputAttemptNumber();
    	attemptNum = player.attemptNumber;
    	checkException.checkNumber(attemptNum);
    	carRecord = player.carRecord();
    	
    	System.out.println("\n실행 결과");
    	PrintResult racingGame = new PrintResult();
    	for(int i = 0; i < attemptNum; i++) {
    		Car driveStop = new Car();
    		carRecord = driveStop.driveCar(player.totalCar, carRecord); //랜덤값 판단하여 전진
    		racingGame.viewRaceCar(player.totalCar, carRecord, carName);
    		System.out.println();
    	}
    	racingGame.racingWinner(carRecord, carName);
    }
}