package racingcar.ui.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 민경수
 * @description user input reader
 * @since 2023.10.27
 **********************************************************************************************************************/
public class CarNamesInputReader{

    public List<String> readLine() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return convertToStringList();
    }

    private List<String> convertToStringList() {
        return Stream.of(Console.readLine().split(",", -1))
                .collect(Collectors.toList());
    }

}