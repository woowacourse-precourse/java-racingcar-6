package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {

  // 자동차 이름을 담을 List
  static List<String> carList;

  // 진행할 round 갯수
  static int round;

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    carList = new ArrayList<>();

    // 자동차 이름 입력
    carList = inputCar();
    // 경기 진행 횟수 입력
    round = inputRound();


  }

  // 자동차 이름 입력
  public static List<String> inputCar() {
    String[] inputCarList = Console.readLine().split(",");
    carList = new ArrayList<>();
    for (String name : inputCarList) {
      // 이름은 다섯 글자 이상이면 에외 처리
      if (name.length() > 5) {
        throw new IllegalArgumentException();
      }
      carList.add(name);
    }
    return carList;
  }

  // 경기 진행 횟수 입력
  public static int inputRound() {
    String readLine = Console.readLine();

    // 숫자가 아닌게 들어오면 예외 발생
    for(char c : readLine.toCharArray()) {
      if(!Character.isDigit(c)) {
        throw new IllegalArgumentException();
      }
    }

    return Integer.parseInt(readLine);
  }

}
