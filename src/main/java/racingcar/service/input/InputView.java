package racingcar.service.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.input.CarInputDto;
import racingcar.dto.input.TimeInputDto;
import racingcar.util.message.Printer;
import racingcar.util.validator.Validator;

public class InputView implements Input{
    @Override
    public CarInputDto getCarInput() {
        Printer.inputNameQuestion();
        return new CarInputDto(getCars());
    }

    @Override
    public TimeInputDto getTimeInput() {
        Printer.inputTimeQuestion();
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
