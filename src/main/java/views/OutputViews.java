package views;

import java.util.List;

public class OutputViews {
  public static void now_position(String car_name, int value_update) {
    System.out.println(car_name + " : " + "-".repeat(value_update));
  }

  public static void final_winner(List<String> winner_member) {
    System.out.print("최종 우승자 : " + String.join(", ", winner_member));
  }
}
