package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
  private InputView inputView;
  private OutputView outputView;
  private Race race;

  public GameController(InputView inputView, OutputView outputView){
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void run(){
    String[] carNames = inputView.getCarNames();
    int moveCount = inputView.getMoveCount();

    List<Car> cars = createCars(carNames);
    race = new Race(cars);

    race.startRace(moveCount);
    String winners = race.getWinners();

    resultOutput(cars);
    outputView.printWinners(winners);
  }
  private List<Car> createCars(String[] carNames){
    List<Car> cars = new ArrayList<>();
    for(String carName : carNames){
      Car car = new Car(carName);
      cars.add(car);
    }
    return cars;
  }

  private void resultOutput(List<Car> cars){
    for(Car car: cars){
      outputView.printCarStatus(car.getName(), car.getPosition());
    }
  }
}
