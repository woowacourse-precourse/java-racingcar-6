package racingcar.View;

import racingcar.Model.RacingMap;

public interface View {
    public void printGetCarString();
    public void printGetNumOfAttempt();
    public void printMapProcess(RacingMap map);
    public void printWinner(RacingMap map);
}
