package modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class racingcarModules {
  public static void checked_car_name_len(String[] carNames) {
    for (String carName : carNames) {
      racingcarException.exception_len_5(carName);
    }
  }

  public static void checked_car_name(String[] carNames) {
    racingcarException.exception_len_0(carNames);
    racingcarException.exception_same_name(carNames);
    racingcarModules.checked_car_name_len(carNames);
  }

  public static void checked_move_num(String num) {
    racingcarException.exception_not_int(num);
    racingcarException.exception_negative(num);
  }

  public static int checked_random_num_over_4(int random_num) {
    if (random_num >= 4) {
      return 1;
    } else {
      return 0;
    }
  }

  public static List<String> campion_racing(HashMap<String, Integer> car_situations) {
    List<String> champion_member = new ArrayList<>();
    var top_score = 0;
    for (String car_name : car_situations.keySet()) {
      int car_name_value = car_situations.get(car_name);
      if (top_score < car_name_value) {
        top_score = car_name_value;
        champion_member.clear();
        champion_member.add(car_name);
      } else if (top_score == car_name_value) {
        champion_member.add(car_name);
      }
    }
    return champion_member;
  }
}
