package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dao.CarDao;
import racingcar.service.GameService;
import racingcar.util.parser;
import racingcar.util.validator;
import racingcar.view.inputView;
import racingcar.view.outputView;

public class Controller {
  private final GameService gameService = new GameService();
  private final parser parser = new parser();
  private final validator validator = new validator();
  private final CarDao carRepository = new CarDao();

  public void run() {
    // 입력을 받고, 입력을 저장한다.
    saveCars(parser.parseCarNames(getCarNamesByUserInput()));
  }

  // 입력을 위한 함수
  private void saveCars(List<String> carNames) {
    for (String carName : carNames) {
      carRepository.save(new Car(carName)); // 자동차 개수 저장
    }
  }

  private String getCarNamesByUserInput() {
    // 사용자의 입력으로 자동차의 이름을 입력받는다.
    inputView.requestCarNamesMessage(); // view
    String input = Console.readLine(); // 입력
    return checkValidationCarNamesInput(input); // vaildation check
  }

  private String checkValidationCarNamesInput(String input) {
    try {
      validator.checkCarNamesInput(input);
      return input;
    } catch (IllegalArgumentException e) {
      outputView.printException(e.getMessage()); // view
      return getCarNamesByUserInput(); //?
    }
  }
}
