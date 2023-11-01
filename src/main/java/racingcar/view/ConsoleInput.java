package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.InputValidator;

public class ConsoleInput implements Input {
    private InputValidator inputValidator;

    public ConsoleInput() {
        this.inputValidator = new InputValidator();
    }

    //mock 객체 주입을 위한 test전용 생성자입니다
    public ConsoleInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public List<String> getCarNames() {
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);

        return splitCarNames(carNames);
    }

    private List<String> splitCarNames(String carNames) {
        List<String> nameList = new ArrayList<>(List.of(carNames.split(",")));
        List<String> trimedNameList = nameList.stream()
                .map(name -> name.strip())
                .collect(Collectors.toList());

        return trimedNameList;
    }

    @Override
    public int getMoveCount() {
        String moveCount = Console.readLine();
        inputValidator.validateMoveCount(moveCount);

        return Integer.parseInt(moveCount);
    }
}
