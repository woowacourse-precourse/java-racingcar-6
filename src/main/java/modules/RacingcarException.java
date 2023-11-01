package modules;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class RacingcarException {
  public static void exception_len_under_2(String[] carNames) {
    if (carNames.length < 2) {
      throw new IllegalArgumentException();
    }
  }

  public static void exception_len_5(String carName) {
    if (carName.length() > 5) {
      throw new IllegalArgumentException();
    }
  }

  public static void exception_same_name(String[] carNames) {
    List<String> carNames_list = List.of(carNames);
    Set<String> carNames_set = new HashSet<>(carNames_list);

    if (carNames_list.size() != carNames_set.size()) {
      throw new IllegalArgumentException();
    }
  }

  public static void exception_not_int(String num) {
    try {
      Integer.parseInt(num);
    } catch (Exception e) {
      throw new IllegalArgumentException();
    }
  }

  public static void exception_negative(String num) {
    if (Integer.parseInt(num) < 0) {
      throw new IllegalArgumentException();
    }
  }
}
