package racingcar;

import java.util.List;

public class Controller {
	Input input;
	CarService service;
	List<Car> cars;
	List<String> winner;
	String carName;
	int count;
	public Controller(){
		input = new Input();
		service = new CarService();
	}
	public void startGame(){
		Output.printStart();
		carName = input.readCarName();
		Output.printTryCount();
		count = input.readCount();
	}
	public void makeCar(){
		cars = service.makeCarList(carName);
	}
	public void setCarMove(){
		cars = service.setCarMoved(cars, count);
	}
	public void setWinner(){
		winner = service.pickWinnerInCarList(cars);
		Output.printWinner(winner);
	}
}
