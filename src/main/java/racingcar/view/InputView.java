package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class InputView {
    private static String getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static String getCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static List<Car> getCarList() {
        String carNames = getCarInput();
        String[] carNameArray = carNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public static int getCountTry() {
        String count = getCountInput();
        return Integer.valueOf(count);
    }

    
}
