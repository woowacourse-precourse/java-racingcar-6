package racingcar.view;

public class ViewNotice {

  private static final String GET_CARNAME_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String GET_ROUND_NOTICE = "시도할 회수는 몇회인가요?";
  public static final String ROUND_RESULT_NOTICE = "실행 결과";

  public static void printGetCarNameNotice() {
    System.out.println(GET_CARNAME_NOTICE);
  }

  public static void printGetRoundNotice() {
    System.out.println(GET_ROUND_NOTICE);
  }

  public static void printRoundResultNotice() {
    System.out.println(ROUND_RESULT_NOTICE);
  }
}
