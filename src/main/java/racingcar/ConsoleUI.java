package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsoleUI {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames);

        return carNames;
    }

    private List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            carNames.add(name.trim());
        }

        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 입력값입니다.");
        }
    }

    public int getMoveNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String moveNum = readLine();
        validatePositive(moveNum);
        validateNumeric(moveNum);

        return Integer.parseInt(moveNum);
    }

    private static void validatePositive(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }

    private static void validateNumeric(String input) {
        boolean isNumeric = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                isNumeric = false;
                break;
            }
        }

        if (!isNumeric) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
