package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

  private List<Car> cars = new ArrayList<Car>();
  private List<Integer> progressState = new ArrayList<Integer>();
  private int trialCount;
  private int currentCount;

  public void init() {
    View.printGameStart();
    List<String> inputedCars = View.inputCars();
    inputedCars.forEach(car -> cars.add(new Car(car)));

    for (int i = 0; i < inputedCars.size(); i++) {
      progressState.add(0);
    }

    View.printGameTrialCount();
    trialCount = View.inputGameTrialCount();
    currentCount = 0;


  }

  public void start() {
    System.out.println("실행 결과");

    while (!isGameEnd()) {
      this.progressRound(cars);
    }
  }

  public boolean isGameEnd() {
    return currentCount >= trialCount;
  }

  public void progressRound(List<Car> cars) {
    currentCount++;

    for (int i = 0; i < cars.size(); i++) {
      if (cars.get(i).isProgress()) {
        progressState.set(i, progressState.get(i) + 1);
      }
    }

    View.printProgressState(cars, progressState);

  }

  public void checkWinner() {
    int maxProgress = -1;
    for (int i = 0; i < cars.size(); i++) {
      if (progressState.get(i) > maxProgress) {
        maxProgress = progressState.get(i);
      }
    }
    
    List<Car> winnerCars = new ArrayList<Car>();
    for (int i = 0; i < cars.size(); i++) {
      if (progressState.get(i) == maxProgress) {
        winnerCars.add(cars.get(i));
      }
    }
    
    View.printWinner(winnerCars);
  }
    
  
}
