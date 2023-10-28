package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    public List<String> inputNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String inputNames = Console.readLine();
        validateBlank(inputNames);
        List<String> nameList = Arrays.stream(
                        inputNames.split(","))
                        .toList();
        validateNamesCount(nameList);
        validateNamesFormat(nameList);

        return nameList;
    }

    public Integer inputCountOfGameRound() {
        System.out.print("시도할 회수는 몇회인가요?");
        System.out.print("\n");
        String inputCountOfGameRound = Console.readLine();
        validateBlank(inputCountOfGameRound);
        validateNumber(inputCountOfGameRound);
        return Integer.parseInt(inputCountOfGameRound);
    }

    private void validateNumber(String number) {
        for (char token : number.toCharArray()) {
            if (!Character.isDigit(token)) {
                throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
            }
        }
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNamesCount(List<String> nameList) {
        if (nameList.size() <= 1) {
            throw new IllegalArgumentException("[ERROR] 이름은 최소 2개 이상 입력하셔야 합니다.");
        }
    }

    private void validateNamesFormat(List<String> nameList) {
        for (String name : nameList) {
            validateNameFormat(name);
        }
    }

    private void validateNameFormat(String name) {
        for (char token : name.toCharArray()) {
            if (!Character.isLetter(token)) {
                throw new IllegalArgumentException("[ERROR] 이름에 글자 이외의 문자를 입력할 수 없습니다.");
            }
        }
    }
}
