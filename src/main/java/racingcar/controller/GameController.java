package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameController {

  private final Input input;
  private final Output output;
  private Cars racingCars;

  public GameController(Input input, Output output) {
    this.input = input;
    this.output = output;
  }

  public void runGame() {
    initializeGame();
    Round round = new Round(racingCars, output);

    int attempts = input.inputTryCount();
    for (int i = 0; i < attempts; i++) {
      round.play();
    }

    showWinners();
  }

  /**
   * 게임 시작 전, 사용자 입력을 받아 자동차 목록 초기화
   */
  private void initializeGame() {
    List<String> carNames = input.inputCarNames();
    List<Car> cars = createCars(carNames);
    this.racingCars = new Cars(cars);
  }

  /**
   * 레이스에서 최종 우승자를 결정
   *
   * @return 레이스에서 우승한 차량 이름 목록
   */
  private List<String> determineWinners() {
    List<String> winners = new ArrayList<>();
    int maxPosition = getMaxPosition();
    for (int i = 0; i < racingCars.getCarPositions().size(); i++) {
      if (racingCars.getCarPositions().get(i) == maxPosition) {
        winners.add(racingCars.getCarNames().get(i));
      }
    }
    return winners;
  }

  /**
   * 레이스에서 가장 멀리 이동한 차량의 위치를 반환
   *
   * @return 레이스에서 가장 멀리 이동한 차량의 위치
   */
  private int getMaxPosition() {
    List<Integer> carPositions = racingCars.getCarPositions();
    int max = 0;
    for (int position : carPositions) {
      max = Math.max(max, position);
    }
    return max;
  }

  /**
   * 레이스에서 우승한 차량 목록을 출력
   */
  private void showWinners() {
    List<String> winners = determineWinners();
    output.printFinalWinners(winners);
  }

  /**
   * 사용자 입력으로부터 받은 자동차 이름 목록을 Car 객체로 생성
   *
   * @param carNames 사용자 입력으로 받은 자동차 이름 목록
   * @return Car 객체로 변환된 자동차 목록
   */
  private List<Car> createCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }
}
