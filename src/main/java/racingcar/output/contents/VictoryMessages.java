package racingcar.output.contents;

public enum VictoryMessages {
  VICTORY_MESSAGES("최종 우승자 : ");

  private final String victoryMessage;

  VictoryMessages(String victoryMessage) {
    this.victoryMessage = victoryMessage;
  }

  public String message() {
    return victoryMessage;
  }
}
