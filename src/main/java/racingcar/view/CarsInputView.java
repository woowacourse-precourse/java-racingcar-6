package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.errormessage.InputError;

import java.util.ArrayList;
import java.util.List;

public class CarsInputView {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

    public List<Car> generateInputList() {
        System.out.print(INPUT_MESSAGE);
        String names = Console.readLine();
        validateInputNoName(names);
        validateInputNameCount(names);
        return StringInput(names);
    }

    private List<Car> StringInput(String names) {
        String[] result = names.split(",");
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < result.length; ++i) {
            list.add(new Car(result[i],0));
        }
        return list;
    }

    private void validateInputNoName(String names) {
        String[] result = names.split(",");
        for (int i = 0; i < result.length; ++i) {
            if (result[i].equals("")) {
                throw new IllegalArgumentException(InputError.INPUT_SPACE_ERROR_MESSAGE);
            }
        }
    }

    private void validateInputNameCount(String names) {
        String[] result = names.split(",");
        long cnt = countChar(names,',');
        if(result.length!=cnt+1) throw new IllegalArgumentException(InputError.INPUT_ERROR_MESSAGE);
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
