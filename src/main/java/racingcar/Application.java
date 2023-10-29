package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        Racing racing = new Racing();

        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = racingCar.nameInput();
        List<String> cars = racingCar.naming(input);
        List<String> raceResult = new ArrayList<>();
        int attemptInput = racingCar.attemptInput();

        for(int i=0; i<cars.size();i++) {
           raceResult.add(racing.moveResult(attemptInput));
        }
        System.out.println(raceResult);
    }
}
