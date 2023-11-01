package racingcar.util;

public class ValidationCarName {
  public static boolean isValidCarName(String name) {
    String[] names = name.split(",");

    for (String n : names) {
      if(n.length() > 5) {
        throw new IllegalArgumentException();
      }
    }
    return true;
  }
}
