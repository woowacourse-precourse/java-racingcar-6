package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    public static void GameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        List<String> members = Arrays.asList(input.split(","));
        HashMap<String, String> membersHM = new HashMap<>();
        CarMovement.putHM(membersHM, members, "");

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptNum = Integer.parseInt(readLine());

        Print.progress(attemptNum, members, membersHM);

    }
}
