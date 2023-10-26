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
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
