package racingcar;

import java.util.List;

public class Application {
  public static void main(String[] args) {

    // 자동차 이름 입력
    CarName car = new CarName();
    car.inputCarNames();

    // 실행할 횟수 입력
    AttemptNumber attempt = new AttemptNumber();
    int number = attempt.Attempt();

    List<String> savedCarNames = car.getCarNames();
    MoveResult move = new MoveResult();
    move.move(savedCarNames, number);

  }
}
