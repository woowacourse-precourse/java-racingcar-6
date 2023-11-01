package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String ROUND_CNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final int NAME_LENGTH = 5;

    public int inputRoundCnt() {
        System.out.println(ROUND_CNT_MESSAGE);
        int roundCnt;
        try {
            roundCnt = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return roundCnt;
    }

    public List<Car> inputCarName() {
        System.out.println(CAR_NAME_MESSAGE);
        String input = Console.readLine();
        String[] names = input.split(",");
        return validateCarName(names);
    }

    public List<Car> validateCarName(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }
}
