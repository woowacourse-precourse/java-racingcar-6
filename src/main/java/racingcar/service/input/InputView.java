package racingcar.service.input;

import static racingcar.util.error.ErrorMessage.NO_INPUT_ELEMENT;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
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
        try{
            return Validator.validateTime(Console.readLine());
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException(NO_INPUT_ELEMENT.toString());
        }
    }

    private static String[] getCars() {
        try{
            return Validator.validateCars(Console.readLine());
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException(NO_INPUT_ELEMENT.toString());
        }
    }
}
