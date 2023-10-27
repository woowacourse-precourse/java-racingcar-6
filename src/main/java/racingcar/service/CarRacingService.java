package racingcar.service;

import static racingcar.view.RacingView.racingStartView;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarList;

public class CarRacingService {

    public void racingStart() {
        racingStartView();
        CarList carList = new CarList(Console.readLine());
    }
}
