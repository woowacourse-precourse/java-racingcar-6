package modules;

public class racingcarException {
  public static void exception_len_0(String[] name_list) {
    if (name_list.length < 2) {
      System.out.println("exception_len_0의 if문 안에 들어옴");
      throw new IllegalArgumentException();
    }
  }

  public static void exception_len_5(String carName) {
    if (carName.length() > 5) {
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
