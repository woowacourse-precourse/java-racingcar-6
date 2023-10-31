package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class outputView {

  private static final int SOLO = 1;

  // 게임 처음에 나오는 출력문
  public static void printHead() {
    System.out.println("실행 결과");
  }

  //
  public static void printScore(List<Car> cars) {
    for (Car car : cars) {
      printCarScore(car);
    }
    System.out.println();
  }

  public static void printWinners(List<String> carNames) {
    System.out.print("최종 우승자 : ");
    System.out.print(carNames.get(0));
    if (checkSoloWin(carNames)) {
      // 우승자 1명인 경우. 종료.
      System.out.println();
      return;
    }
    for (int i = 1; i < carNames.size(); i++) {
      System.out.print(", ");
      // 2명 이상인 경우.
      System.out.print(carNames.get(i));
    }
    System.out.println();
  }

  public static void printException(String message) {
    // 예외처리 메세지 출력
    System.out.println(message);
  }

  private static void printCarScore(Car car) {
    System.out.print(car.getName() + " : ");
    printPosition(car);
    System.out.println();
  }

  private static void printPosition(Car car) {
    // 자동차의 전진 횟수만큼 - 넣기.
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print("-");
    }
  }

  private static boolean checkSoloWin(List<String> carNames) {
    // 1인지 아닌지 확인하기.
    return carNames.size() == SOLO;
  }
}
