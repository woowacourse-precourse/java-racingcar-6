package racingcar.message;

public enum PrintMessage {
  START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
  START_TRY_NUM("시도할 회수는 몇 회인가요?"),
  TRY_RESULT("실행 결과"),
  FINAL_WINNER("최종 우승자 : ");

  public final String message;

  PrintMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
