package racingcar;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import modules.racingcarModules;

public class Games {
  int move_num;
  String[] names;
  HashMap<String, Integer> car_situations = new HashMap<String, Integer>();

  Games(String[] names, int move_num) {
    this.names = names;
    for (String name : names) {
      car_situations.put(name, 0);
    }
    this.move_num = move_num;
  }

  public void racingcar_game() {
    System.out.println("실행 결과");
    for (var i = 0; i < move_num; i++) {
      for (String car_name : names) {
        int value_update = car_situations.get(car_name) + racingcarModules.car_forward_or_not();
        car_situations.put(car_name, value_update);

        System.out.println(car_name + " : " + "-".repeat(value_update));
      }
      System.out.println();
    }
    List<String> champion_member = racingcarModules.campion_racing(car_situations);
    System.out.print("최종 우승자 : " + String.join(", ", champion_member));
  }
}
