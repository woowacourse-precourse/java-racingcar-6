package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class HostReception {

    List<String> getParticipant () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String participants = Console.readLine();
        List<String>  participant= Arrays.stream(participants.split(",")).toList();

        participant.forEach(this::checkValidCarName);

        return participant;
    }

    int getRoundFromUser () {
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();

        if (!round.matches("^-?\\d+$\n")) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }

        return Integer.parseInt(round);
    }

    boolean checkValidCarName (String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return true;
    }
}
