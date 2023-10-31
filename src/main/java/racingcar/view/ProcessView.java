package racingcar.view;

import java.util.List;
import racingcar.model.CarModel;

public class ProcessView {
    // Todo: 현재 자동차의 전진 상황 출력

    public void showCurrentResult(List<CarModel> cars) {
        for (CarModel car : cars) {
            System.out.println(car);
        }
    }
}
