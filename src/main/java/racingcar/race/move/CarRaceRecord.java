package racingcar.race.move;

public class CarRaceRecord {
  private final String carName;
  private final RoundRecord roundRecord;

  private CarRaceRecord(String carName, RoundRecord roundRecord) {
    this.carName = carName;
    this.roundRecord = roundRecord;
  }

  public static CarRaceRecord of(String carName, RoundRecord roundRecord) {
    return new CarRaceRecord(carName, roundRecord);
  }

  public String getCarName() {
    return carName;
  }

  public int lastRoundRaceResult() {
    return roundRecord.lastRoundRaceResult();
  }

  public RoundRecord getRoundRecord() {
    return roundRecord;
  }
}
