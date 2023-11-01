package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class HostReception {

    String[] getParticipant () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String participants = Console.readLine();
        String[]  participant= participants.split(",");

        for (int i = 0; i < participant.length ; i++) {
            checkValidCarName(participant[i]);
        }

        return participant;
    }

    boolean checkValidCarName (String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return true;
    }
}
