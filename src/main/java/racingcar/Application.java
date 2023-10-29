package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        generateCars();
    }

    private static void generateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        String[] carNames = carNamesInput.split(",");
        int carCount = carNames.length;
        Car[] cars = new Car[carCount];
        for (int index = 0; index < carCount; index++) {
            cars[index] = new Car(carNames[index], 0);
        }
        System.out.println(Arrays.toString(carNames));
    }
}
