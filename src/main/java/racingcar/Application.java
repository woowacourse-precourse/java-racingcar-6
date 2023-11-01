package racingcar;

import camp.nextstep.edu.missionutils.Console;
import modules.racingcarModules;
import modules.racingcarException;

public class Application {
  public static void main(String[] args) {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String names = Console.readLine();
    String[] names_list = names.split(",");
    racingcarModules.checked_car_name(names_list);

    System.out.println("시도할 회수는 몇회인가요?");
    String move_num = Console.readLine();
    racingcarModules.checked_move_num(move_num);

    Games game = new Games(names_list, Integer.parseInt(move_num));
    game.racingcar_game();
  }
}
