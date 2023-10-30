package racingcar.view;

import java.util.List;

public interface View {

    List<String> requestRacerNames();

    int requestRaceNumberOfTime();

    void displayRaceResult();

    void displayRaceStatus(String name, int movementDistance);

    void displayWinner(List<String> winner);

}
