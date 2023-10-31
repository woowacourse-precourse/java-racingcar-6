package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class CarsInputView {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String INPUT_ERROR_MESSAGE = "자동차 이름을 쉼표(,)+1 개수만큼 입력하지 않았습니다.";

    public List<Car> generateInputList() {
        System.out.print(INPUT_MESSAGE);
        String names = Console.readLine();
        validateNoInputName(names);
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

    private void validateNoInputName(String names) {
        String[] result = names.split(",");
        for (int i = 0; i < result.length; ++i) {
            if (result[i].length()==0) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }
        }
    }

}
