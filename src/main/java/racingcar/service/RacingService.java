package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameBoard;
import racingcar.domain.NumberGenerator;
import racingcar.utils.Message;
import racingcar.view.console.ApplicationConsoleView;

public class RacingService implements Racing {

  private final GameBoard board = new GameBoard();

  @Override
  public void race(List<Car> cars, ApplicationConsoleView console) {
    // 현재 경주가 끝난 상황을 담을 새로운 List<Car>
    List<Car> nextRace = new ArrayList<>();

    for (Car car : cars) {
      // 경기 완료 후 현황을 담을 새로운 Car 리스트 초기화
      int random = NumberGenerator.generateRandomNumber();
      moveCarByRandomValue(car, random);

      nextRace.add(car);
    }

    board.update(nextRace);
    // 보드 업데이트 후 한 번씩 경기 결과 출력
    console.printRacingResult(board.toString() + GameBoard.NEW_LINE);
  }

  private void moveCarByRandomValue(Car car, int random) {
    if (random >= 4 && random <= 9) {
      car.forward();
    }
  }
}
