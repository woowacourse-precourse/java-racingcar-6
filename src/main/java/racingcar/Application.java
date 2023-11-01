package racingcar;

import modules.RacingcarModules;
import views.InputViews;

public class Application {
  public static void main(String[] args) {
    String names = InputViews.read_car_names();
    String[] names_list = names.split(",");
    RacingcarModules.checked_car_name(names_list);

    String move_num = InputViews.read_move_num();
    RacingcarModules.checked_move_num(move_num);

    Games game = new Games(names_list, Integer.parseInt(move_num));
    game.racingcar_game();
  }
}
