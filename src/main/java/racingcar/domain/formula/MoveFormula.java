package racingcar.domain.formula;

import racingcar.domain.generator.NumberGenerator;

public class MoveFormula {

  private static final int MINIMUM_MOVING_CONDITIONS = 4;

  private final NumberGenerator numberGenerator;

  public MoveFormula(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public MoveState move() {
    if (numberGenerator.generate() >= MINIMUM_MOVING_CONDITIONS) {
      return MoveState.GO;
    }
    return MoveState.STOP;
  }
}
