package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.TypeConverter;

public class InputView {

    private static final String INPUT_ENTRY_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> readEntryNames() {
        System.out.println(INPUT_ENTRY_NAME_MSG);
        return TypeConverter.toList(readLine());
    }
}
