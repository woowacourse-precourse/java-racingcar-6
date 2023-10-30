package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.exception.InvalidInput;

public class InputView {
    private final static String inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String inputTryNumberMessage = "시도할 횟수는 몇회인가요?";

    public String inputCarName() {
        System.out.println(inputCarNameMessage);

        return Console.readLine();
    }

    public List<String> splitNames(String names) {
        String[] namesArray = names.split(",");
        InvalidInput.DuplicateNameException(namesArray);

        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < namesArray.length; i++) {
            InvalidInput.longNameException(namesArray[i]);
            nameList.add(namesArray[i]);
        }

        return nameList;
    }

    public int inputTryNumber() {
        System.out.println(inputTryNumberMessage);
        String input = Console.readLine();

        InvalidInput.NotIntegerValueException(input);
        InvalidInput.OutOfRangeException(input);

        return Integer.parseInt(input);
    }
}
