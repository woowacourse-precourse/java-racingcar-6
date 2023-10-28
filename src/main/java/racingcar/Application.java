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

  // 참가한 자동차 갯수
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

    // 경기 진행 횟수 입력
    System.out.println("시도할 회수는 몇회인가요?");
    round = inputRound();

    // 참가한 자동차 갯수
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

    // 경기 종료 : 결과 발표
    announcement();

  }


  // 경기 종료 : 결과 발표
  public static void announcement() {

    // 가장 큰 전진 정도를 찾기 위한 변수 maxNumber
    int maxNumber = 0;

    // 가장 큰 전진을 한 자동차의 이름을 담을 리스트 winnerList
    List<String> winnerList = new ArrayList<>();

    // 우승자 탐색
    for(int i = 0; i < n; i++) {
      // 현재 큰 값보다 큰 게 있다면 업데이트
      if(maxNumber < forwardArr[i]) {
        maxNumber = forwardArr[i];
        winnerList = new ArrayList<>();
        winnerList.add(carList.get(i));
      }
      // 현재 큰 값과 같다면 우승자 리스트에 추가 
      else if(maxNumber == forwardArr[i]) {
        winnerList.add(carList.get(i));
      }
    }

    // 우승 메세지 출력
    String message = "최종 우승자 : ";
    for(int i = 0; i < winnerList.size(); i++) {
      message += winnerList.get(i) + ", ";
    }
    System.out.println(message);

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
