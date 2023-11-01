package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.console.ApplicationConsoleView;

public interface Racing {

  void race(List<Car> carNames, ApplicationConsoleView console);
}
