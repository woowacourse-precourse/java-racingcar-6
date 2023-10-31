package racingcar.View;

import racingcar.Model.RacingMap;

import java.util.List;

public interface View {
    public void printGetCarString();
    public void printGetNumOfAttempt();
    public void printMapProcess(RacingMap map);
    public void printWinner(List<String> Winner);
}
