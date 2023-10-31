package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.message.ErrorMessage;
import racingcar.model.Car;

public class InputView {

    private static final String COMMA = ",";

    public List<Car> receiveCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(COMMA);
        boolean isValidateName = Arrays.stream(carNames)
                .anyMatch(name -> name.length() > 5);
        long uniqueCount = Arrays.stream(carNames)
                .distinct()
                .count();

        if (isValidateName) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }

        if (uniqueCount != carNames.length){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
        }

        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int receiveTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            int times = Integer.parseInt(input);

            if (times < 1) {
                throw new NumberFormatException();
            }

            return times;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TIMES.getMessage());
        }
    }
}
