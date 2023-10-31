package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static Validate validate = new Validate();

    public static int inputNumber() {
        return getInteger(camp.nextstep.edu.missionutils.Console.readLine());
    }

    public static int getInteger(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 자연수를 입력해 주세요");
        }

        // 자연수인지 검증
        validate.validatePositiveNumber(num);

        return num;
    }


    public static List<Player> inputPlayers() {
        List<Player> players = new ArrayList<>();
        /*
         * 이름을 "," 를 기준으로 나눠 반복해서 처리
         * */
        for (String name : camp.nextstep.edu.missionutils.Console.readLine().split(",", -1)) {
            // 이름이 조건에 맞으면, player List에 추가
            if (validate.validateName(name)) {
                players.add(new Player(name));
            }
        }

        return players;
    }


}
