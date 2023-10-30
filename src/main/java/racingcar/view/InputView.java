package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.dto.input.CarsDto;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.validator.TryTimesValidator;

public class InputView {
    private final InputReader reader;
    private final OutputWriter writer;

    public InputView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Cars getCars() {
        writer.writeInputNameMsg();
        String carNames = reader.readLine();
        CarsDto carsDto = new CarsDto(carNames);
        return carsDto.toCars();
    }

    public int getTrytimes() {
        writer.writeInputTryTimesMsg();
        String tryTimes = reader.readLine();
        TryTimesValidator.validateNumber(tryTimes);
        return Integer.parseInt(tryTimes);
    }
}
