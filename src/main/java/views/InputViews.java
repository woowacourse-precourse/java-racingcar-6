package views;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
  public static String read_car_names() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    return Console.readLine();
  }

  public static String read_move_num() {
    System.out.println("시도할 회수는 몇회인가요?");
    return Console.readLine();
  }
}
