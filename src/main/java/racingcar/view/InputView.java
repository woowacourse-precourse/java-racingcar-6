package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.TryNumber;

public class InputView {

  private final OutputView outputView;

  public InputView(OutputView outputView) {
    this.outputView = outputView;
  }

  public CarList inputCarName() {
    outputView.printInputRacing();
    String input = Console.readLine();
    String[] split = input.split(",");

    List<Car> cars = Arrays.stream(split)
            .map(Car::new)
            .collect(Collectors.toList());

    return new CarList(cars);
  }

  public TryNumber inputTryNumber() {
    outputView.printInputTryNumber();
    String input = Console.readLine();
    return new TryNumber(input);
  }
}
