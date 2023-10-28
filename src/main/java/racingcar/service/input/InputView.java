package racingcar.service.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarInputDto;
import racingcar.dto.TimeInputDto;
import racingcar.util.validator.Validator;

public class InputView implements Input{
    @Override
    public CarInputDto getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new CarInputDto(getCars());
    }

    @Override
    public TimeInputDto getTimeInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new TimeInputDto(getTime());
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
