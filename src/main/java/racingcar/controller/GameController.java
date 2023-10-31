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
    List<Car> cars = new ArrayList<>();
    for (String name : carNames){
      cars.add(new Car(name));
    }

    int moveCount = inputView.getMoveCount();

    race = new Race(cars);

    for(int move = 0; move < moveCount; move++){
      race.startRace(1);
      for(Car car : cars){
        outputView.printCarStatus(car.getName(), car.getPosition());
      }
      System.out.println();
    }

    String winners = race.getWinners();
    outputView.printWinners(winners);
  }
}
