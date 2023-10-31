package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dao.GameDao;
public class GameService {
  private static final int FORWARD_CONDITION = 4;
  private static final int MIN_VALUE = -1;
  private final GameDao gameDao = new GameDao();

  public void play(Game game) {
    // 랜덤 숫자 생성,
    moveForwardByRandomNumber(game);
    game.increaseTrialNum();
  }

  public List<String> getWinners(Game game) {
    List<Car> cars = game.getCars();
    int maxPosition = getMaxPosition(cars);
    return getMaxPositionCars(cars, maxPosition);
  }

  public Boolean isEnd(Game game) {
    return gameDao.isEnd(game);
  }

  public Long save(Game game) {
    return gameDao.save(game);
  }

  private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
    List<String> carNames = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        carNames.add(car.getName());
      }
    }
    // 출력에 필요한 자동차 이름들 return
    return carNames;
  }

  private int getMaxPosition(List<Car> cars) {
    int max = MIN_VALUE;
    for (Car car : cars) {
      // postion 제일 큰 것 구하기.
      if (max < car.getPosition()) {
        max = car.getPosition();
      }
    }
    return max;
  }

  private void moveForwardByRandomNumber(Game game) {
    for (Car car : game.getCars()) {
      if (FORWARD_CONDITION <= getRandomNumber()) {
        car.moveForward(1);
      }
    }
  }

  private int getRandomNumber() {
    // 랜덤 숫자 생성
    return Randoms.pickNumberInRange(0, 9);
  }
}
