package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final int MAX_NAME_LENGTH = 5;

    public String[] getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return validateAndSplitNames(input);
    }

    private String[] validateAndSplitNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은" + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
            }
        }
        return names;
    }

    public int getRaceCountFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateRaceCount(input);
        return Integer.parseInt(input);
    }

    private void validateRaceCount(String input) {
        try {
            int raceCount = Integer.parseInt(input);
            if (raceCount < 0) {
                throw new IllegalArgumentException("시도할 회수는 음수가 될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
