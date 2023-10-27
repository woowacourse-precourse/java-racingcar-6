package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNamesList = inputCarNames();
        checkNamingError(carNamesList);

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfRaces = inputNumberOfRaces();

        generateAction();

        System.out.println(carNamesList);
        System.out.println(carNamesList.size());
        System.out.println(numberOfRaces);
    }

    public static List<String> inputCarNames() {
        // 문자열 받아서 콤마(,)롤 기준으로 나누어 List에 담음
        String carNames = Console.readLine();
        String[] carNamesSplitted = carNames.split(",");
        List<String> carNamesList = new ArrayList<>();
        Collections.addAll(carNamesList, carNamesSplitted);
        return carNamesList;
    }

    public static void checkNamingError(List<String> carNamesList) {
        int maxLength = 5;
        for (String item : carNamesList) {
            if (item.length() > maxLength) {
                throw new IllegalArgumentException("이름 길이 5자 초과");
            }
        }
    }

    public static int inputNumberOfRaces() {
        String numberOfRaces = Console.readLine();
        try {
            return Integer.parseInt(numberOfRaces);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    public static void generateAction() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        System.out.println(randomNumber);
    }
}
