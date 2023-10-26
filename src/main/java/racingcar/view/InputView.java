package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGarage;
import racingcar.util.TypeConverter;

import java.util.List;

public class InputView {

    private final TypeConverter converter;

    public InputView(TypeConverter converter) {
        this.converter = converter;
    }

    public CarGarage getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> nameList = converter.convertToNameList(input);
        List<Car> cars = converter.convertToCarList(nameList);
        return new CarGarage(cars);
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
