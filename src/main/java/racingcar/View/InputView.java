package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private final PrintStream printStream;


    public InputView(PrintStream printStream) {
        this.printStream = printStream;

    }

    public List<String> inputCarNames() {
        printStream.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> names = getCarNames();

        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException("자동차 이름은 유일한 이름이어야 합니다.");
        }
        return names;
    }

    private List<String> getCarNames() {
        String names = Console.readLine();

        return trim(split(names));
    }

    private boolean hasDuplicatedName(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return set.size() != names.size();
    }

    private List<String> split(String names) {
        return List.of(names.split(","));
    }

    private List<String> trim(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
    //회수 입력? 횟수 범위 추가 100 정도?
}
