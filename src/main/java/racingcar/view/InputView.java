package racingcar.view;

import racingcar.Application;

import java.util.Arrays;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.Converter.convertStringToHashMap;

public class InputView {
    private static final int MAX_LENGTH = 4;

    public static HashMap<String, String> inputParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carList = readLine().split(",");

        if (Arrays.stream(carList).anyMatch(c -> c.length() > MAX_LENGTH))
            throw new IllegalArgumentException("이름은 공백을 포함한 4자 이하여야 합니다.");

        HashMap<String, String> participants = convertStringToHashMap(carList);

        return participants;
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요");
        int count = Integer.parseInt(readLine());
        return count;
    }
}
