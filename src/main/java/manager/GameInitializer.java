package manager;

import camp.nextstep.edu.missionutils.Console;

import custom_object.Car;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {
    private final int CAR_NAME_MAXIMUM_LENGTH = 5;

    public List<Car> inputCarName() {
        List<Car> carList = new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        String[] inputCarNameSplit;

        try {
            inputCarNameSplit = inputCarName.split(",");
        } catch(Exception exception) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputCarNameSplit.length; i++) {
            if (inputCarNameSplit[i].length() > CAR_NAME_MAXIMUM_LENGTH) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < inputCarNameSplit.length; i++) {
            carList.add(new Car(inputCarNameSplit[i]));
        }

        return carList;
    }

    public Integer inputNumbersOfMatch() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumbersOfMatch = Console.readLine();
        int NumbersOfMatch;

        try {
            NumbersOfMatch = Integer.parseInt(inputNumbersOfMatch);
        } catch(Exception exception) {
            throw new IllegalArgumentException();
        }

        return NumbersOfMatch;
    }
}
