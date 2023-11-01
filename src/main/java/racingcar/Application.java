package racingcar;

import camp.nextstep.edu.missionutils.Console;
import modules.racingcarModules;
import views.InputViews;

public class Application {
  public static void main(String[] args) {
    String names = InputViews.read_car_names();
    String[] names_list = names.split(",");
    racingcarModules.checked_car_name(names_list);

    System.out.println("시도할 회수는 몇회인가요?");
    String move_num = Console.readLine();
    racingcarModules.checked_move_num(move_num);

    Games game = new Games(names_list, Integer.parseInt(move_num));
    game.racingcar_game();
  }
}
