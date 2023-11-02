package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.Entries;
import racingcar.model.Round;
import racingcar.util.TypeConverter;

public class InputView {

    private static final String INPUT_ENTRY_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MSG = "시도할 회수는 몇회인가요?";

    public Entries readEntryNames() {
        System.out.println(INPUT_ENTRY_NAME_MSG);
        List<String> entries = TypeConverter.toList(readLine());
        return new Entries(entries);
    }

    public Round readRound() {
        System.out.println(INPUT_ROUND_MSG);
        int round = TypeConverter.toInt(readLine());
        return new Round(round);
    }
}
