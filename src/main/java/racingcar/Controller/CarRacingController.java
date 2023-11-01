package racingcar.Controller;

import java.util.stream.IntStream;
import racingcar.domain.CarList;
import racingcar.domain.CarStatus;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
  private final InputView inputView;
  private final OutputView outputView;

  public CarRacingController() {
    outputView = new OutputView();
    inputView = new InputView(outputView);
  }

  public void run() {
    CarList cars = inputView.inputCarName();
    TryNumber tryNum = inputView.inputTryNumber();

    CarStatus carStatus = new CarStatus(cars.getCarList());

    moveCars(cars, tryNum, carStatus);

    printFinalWinner(carStatus);
  }

  private void moveCars(CarList cars, TryNumber tryNumber, CarStatus carStatus) {
    outputView.printTryResult();
    IntStream.range(0, tryNumber.getNumber()).forEach(index -> {
      cars.moveAll();
      outputView.printRacingStatus(carStatus);
    });
  }

  private void printFinalWinner(CarStatus status) {
    outputView.printFinalWinner(status);
  }
}
