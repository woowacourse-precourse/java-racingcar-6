package modules;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingcarModules {
  public static void checked_car_name_len(String[] carNames) {
    for (String carName : carNames) {
      RacingcarException.exception_len_5(carName);
    }
  }

  public static void checked_car_name(String[] carNames) {
    RacingcarException.exception_len_under_2(carNames);
    RacingcarException.exception_same_name(carNames);
    RacingcarModules.checked_car_name_len(carNames);
  }

  public static void checked_move_num(String num) {
    RacingcarException.exception_not_int(num);
    RacingcarException.exception_negative(num);
  }

  public static int checked_random_num_over_4(int random_num) {
    if (random_num >= 4) {
      return 1;
    } else {
      return 0;
    }
  }

  public static int car_forward_or_not() {
    int random_num = Randoms.pickNumberInRange(0, 9);
    return RacingcarModules.checked_random_num_over_4(random_num);
  }

  public static List<String> winner_racing(HashMap<String, Integer> car_situations) {
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
