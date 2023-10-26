package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.util.TypeConverter;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private final TypeConverter converter;

    public InputView(TypeConverter converter) {
        this.converter = converter;
    }

    public List<Car> getCars() {
        String input = Console.readLine();
        List<String> nameList = converter.convertToList(input);
        List<Car> cars = new ArrayList<>();
        for (String name : nameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTryCount() {
        String input = Console.readLine();
        try {
            int count = Integer.parseInt(input);
            checkCount(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void checkCount(int count) {
        checkPositive(count);
        checkMax(count);
    }

    private void checkPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    private void checkMax(int count) {
        if (count >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}
