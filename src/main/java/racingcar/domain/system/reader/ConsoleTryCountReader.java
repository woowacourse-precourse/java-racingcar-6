package racingcar.domain.system.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.NumberStringConverter;

public class ConsoleTryCountReader implements TryCountReader {


    @Override
    public Long read() {
        String tryCount = Console.readLine();
        return NumberStringConverter.convert(tryCount);
    }
}
