package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import tool.Random;
import validation.StringValidator;


public class Game {

  public static List<Car> makeCarList(final String nameList) {
    List<Car> carList = new ArrayList<>();
    StringTokenizer nameTokenizer = new StringTokenizer(nameList, ",");

    while (nameTokenizer.hasMoreTokens()) {
      String carName = StringValidator.checkLengthOver(nameTokenizer.nextToken(),
          Const.CAR_NAME_LIMIT);
      Car carListElement = new Car(carName);
      carList.add(carListElement);
    }

    return carList;
  }

  public static List<Car> moveCars(final List<Car> carList) {
    for (Car car : carList) {
      if (Random.isRandOverValueInRange(Const.RANDOM_RANGE_BEGIN, Const.RANDOM_RANGE_END,
          Const.FORWARD_MOVE_BOUND)) {
        car.addForwardDistance();
      }
    }

    return carList;
  }

  public static void printTrialResult(final List<Car> carList) {
    for (Car car : carList) {
      System.out.println(car.getStatus());
    }
    System.out.println();
  }

  public static void printWinner(final List<Car> carList) {
    System.out.print("최종 우승자 : ");
    int maxForwardDistance = getMaxForwardDistance(carList);
    int winnerCount = getWinnerCount(carList, maxForwardDistance);

    for (Car car : carList) {
      if (car.getForwardDistance() == maxForwardDistance) {
        System.out.print(car.getName());
      }

      if (--winnerCount == 0) {
        break;
      } else {
        System.out.print(", ");
      }
    }
  }

  public static int getMaxForwardDistance(final List<Car> carList) {
    int maxForwardDistance = 0;

    for (Car car : carList) {
      maxForwardDistance = Math.max(maxForwardDistance, car.getForwardDistance());
    }

    return maxForwardDistance;
  }

  // 우승자 수가 몇 명인지 리턴하는 함수
  public static int getWinnerCount(final List<Car> carList, int maxForwardDistance) {
    int winnerCount = 0;

    for (Car car : carList) {
      if (car.getForwardDistance() == maxForwardDistance) {
        winnerCount++;
      }
    }

    return winnerCount;
  }

  public static void play() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    List<Car> carList = makeCarList(input);

    System.out.println("시도할 회수는 몇회인가요?");
    int trialNumber = Integer.parseInt(
        StringValidator.checkIntegerFormat(Console.readLine()));

    System.out.println("실행 결과");
    while (trialNumber-- > 0) {
      carList = moveCars(carList);
      printTrialResult(carList);
    }

    printWinner(carList);
  }
}
