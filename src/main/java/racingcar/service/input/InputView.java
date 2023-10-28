package racingcar.service.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.domain.Car;
import racingcar.service.dto.CarsAndTime;
import racingcar.service.util.validator.Validator;

public class InputView implements Input{
    @Override
    public CarsAndTime getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.println("시도할 회수는 몇회인가요?");
        return new CarsAndTime(getCars(),getTime());
    }

    private static int getTime() {
        String timeInput = Console.readLine();
        return Validator.validateTime(timeInput);
    }

    private static String[] getCars() {
        String input = Console.readLine();
        return Validator.validateCars(input);
    }
}
