package racingcar;

import java.util.List;

public class Application {
  private static IoService io = new IoService();
  public static void main(String[] args) {
    String input = io.gameStartInputMsg();
    List<String> isNmaes = io.nameChangeNames(input);
    System.out.println(isNmaes);
    //경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    //pibo,tototot,boblkd
    //[pibo, tototot, boblkd]


  }
}
