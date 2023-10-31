package racingcar.view;

import racingcar.converter.InputConverter;
import racingcar.domain.game.car.Cars;
import racingcar.io.reader.StdReader;
import racingcar.io.writer.StdWriter;

public class InputView {
    private final String INPUT_CAR_NAMES_MESSSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private final StdReader reader;
    private final StdWriter writer;
    private final InputConverter inputConverter;

    public InputView(StdReader reader, StdWriter writer, InputConverter inputConverter) {
        this.reader = reader;
        this.writer = writer;
        this.inputConverter = inputConverter;
    }

    public Cars getCarsFromUserInput() {
        writer.writeLine(INPUT_CAR_NAMES_MESSSAGE);
        String input = reader.readLine();
        return inputConverter.toCars(input);
    }

    public int getTrialFromUserInput() {
        writer.writeLine(INPUT_TRIAL_MESSAGE);
        String input = reader.readLine();
        return inputConverter.toTrial(input);
    }
}
