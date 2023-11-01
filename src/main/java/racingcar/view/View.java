package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public interface View {

    List<String> requestRacerNames();

    int requestRaceNumberOfTime();

    void displayRaceResult();

    void displayRaceStatus(List<Car> cars);

    void displayWinner(List<String> winner);

}
