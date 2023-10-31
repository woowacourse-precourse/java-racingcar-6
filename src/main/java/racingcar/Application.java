package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
    	ArrayList<Car> carList = new ArrayList<>();
    	String[] nameArr = Input.setCarName();
    	for(int i=0; i<nameArr.length; i++) {
    		Car car = new Car(nameArr[i]);
    		carList.add(car); 
    	}
    	
    	int attemptNum = Input.setAttemptNum();
    	ScoreBoard.moveCar(carList, attemptNum);
    	ArrayList<String> winner = Winner.resultWinner(carList, Move.carLocation);
    	System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}