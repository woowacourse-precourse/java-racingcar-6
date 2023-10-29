package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final static String inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String inputTryNumberMessage = "시도할 횟수는 몇회인가요?";

    public static List<String> inputCarName(){
        System.out.println(inputCarNameMessage);
        String names = Console.readLine();
        return splitNames(names);
    }

    private static List<String> splitNames(String names) {
        String[] namesArray = names.split(",");
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < namesArray.length; i++) {
            nameList.add(namesArray[i]);
        }

        return nameList;
    }

    public static int inputTryNumber(){
        System.out.println(inputTryNumberMessage);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
