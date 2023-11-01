package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.dto.input.CarsRequestDto;
import racingcar.io.Reader;
import racingcar.io.Writer;
import racingcar.parser.Parser;

import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Cars getCars() {
        writer.write(INPUT_CAR_NAMES);
        String carNames = reader.readLine();
        List<String> carNameList = Parser.parseCarNames(carNames);
        CarsRequestDto carsRequestDto = new CarsRequestDto(carNameList);
        return Cars.from(carsRequestDto.carNameList());
    }

    public int getTryTimes() {
        writer.write(INPUT_TRY_TIMES);
        String tryTimes = reader.readLine();
        return Parser.parseTryTimes(tryTimes);
    }
}
