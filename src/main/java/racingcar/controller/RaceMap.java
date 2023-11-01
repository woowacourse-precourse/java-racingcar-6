package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.Cars;
import racingcar.view.Finish;
import racingcar.view.ScorePrint;
import racingcar.view.Try;

public class RaceMap {
    public RaceMap() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Cars.name();
        System.out.println("시도할 회수는 몇회인가요?");
        int maxTry = Try.input();
        int car_numbers = cars.size();
        int carLocation[] = new int[car_numbers];

        int tryCount = 0;
        System.out.println("실행 결과\n");
        while (tryCount < maxTry) {
            carLocation = Race.racing(carLocation, car_numbers);
            ScorePrint.resultByOrder(carLocation, cars);
            tryCount++;
        }
        Finish.victoryCars(carLocation, cars);
    }

}
