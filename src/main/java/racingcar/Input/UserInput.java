package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class UserInput {
    public static LinkedHashMap<String, String> getCarNames() {
        // 1. 자동차 이름 입력 받기
        LinkedHashMap<String, String> namesMap = new LinkedHashMap<>();
        Set<String> nameSet = new HashSet<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] names = input.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 2대 이상의 자동차가 필요합니다.");
        }

        for (String name : names) {
            String trimmedName = name.trim(); // 앞 뒤 공백은 허용
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("공백은 자동차 이름이 될 수 없습니다.");
            }
            if (trimmedName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 띄어쓰기가 포함되면 안 됩니다.");
            }

            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
            }

            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            namesMap.put(trimmedName, "");
        }
        return namesMap;
    }

    public static int getNumberOfMoves() {
        // 2. 시도 횟수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        String moves = Console.readLine();

        int parsedMoves;
        try {
            parsedMoves = Integer.parseInt(moves);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }

        if (parsedMoves <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }

        return parsedMoves;
    }
}
