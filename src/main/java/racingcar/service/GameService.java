package racingcar.service;

import camp.nextstep.edu.missionutils.Console;


public class GameService {

  public int tryNum;


  public void startGame() {
    getInputCar();
    getInputTryNum();
  }


  // 입력값을 받는다.
  public void getInputCar() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
  }



  public void getInputTryNum() {
    System.out.println("시도할 횟수는 몇회인가요?");
    tryNum = Console.readLine();
  }

}
