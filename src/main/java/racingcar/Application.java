package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {

  // 자동차 이름을 담을 List
  static List<String> carList;
  // 진행할 round 갯수
  static int round;

  // 자동차 갯수
  static int n;

  // 각 자동차의 경주 상태
  static int[] forwardArr;
  static List<String> lainList;


  public static void main(String[] args) {
    // TODO: 프로그램 구현
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    // 자동차 이름 입력
    carList = new ArrayList<>();
    carList = inputCar();

    System.out.println("시도할 회수는 몇회인가요?");

    // 경기 진행 횟수 입력
    round = inputRound();

    n = carList.size();

    // 경기 진행

    // 자동차 경로 초기화
    forwardArr = new int[n];
    lainList = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      String lain = carList.get(i) + " : ";
      lainList.add(lain);
    }

    // 경기 시작
    System.out.println("실행 결과");
    for(int i = 0; i < round; i++) {
      race();
    }




  }

  // 한 라운드 경기 진행
  public static void race() {
    for(int i = 0; i < n; i++) {
      int number = Randoms.pickNumberInRange(0,9);
      // 4 이상일 경우 전진
      if(number >= 4) {
        forwardArr[i] += 1;
        lainList.set(i, lainList.get(i) + "-");
      }
      System.out.println(lainList.get(i));
    }
    System.out.println();
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
