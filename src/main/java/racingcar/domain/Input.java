package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static Validate validate;
    private static InputGenerator inputGenerator;

    public Input(Validate validate, InputGenerator inputGenerator) {
        this.validate = validate;
        this.inputGenerator = inputGenerator;
    }

    public static int inputNumber() {
        String input = inputGenerator.readLine();

        // int 자료형 검증
        validate.validateInteger(input);
        int num = Integer.parseInt(input);

        // 자연수 검증
        validate.validatePositiveNumber(num);

        return num;
    }

    public static List<Player> inputPlayers() {
        List<Player> players = new ArrayList<>();
        /*
         * 이름을 "," 를 기준으로 나눠 반복해서 처리
         * */
        for (String name : inputGenerator.readLine().split(",", -1)) {
            // 이름이 조건에 맞으면, player List에 추가
            if (validate.validateName(name)) {
                players.add(new Player(name, new RandomGenerator()));
            }
        }

        return players;
    }


}
