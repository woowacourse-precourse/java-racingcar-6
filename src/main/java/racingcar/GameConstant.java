package racingcar;

public class GameConstant {
  public static final String colon = " : ";
  public static final String dash = "-";

  public static enum Output {
    INPUTCARNAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUTTRIAL("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자 : ");

    private String outputText;

    Output(String outputText) {
      this.outputText = outputText;
    }

    public String getOutputText() {
      return outputText;
    }
  }
}
