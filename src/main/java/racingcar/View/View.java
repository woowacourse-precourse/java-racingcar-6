package racingcar.View;

import racingcar.Model.RacingMap;

import java.util.List;

public interface View {
    public void printSetCarString();
    public void printSetNumOfAttempt();
    public void printMapProcess(RacingMap map);
    public void printWinner(List<String> Winner);
}
