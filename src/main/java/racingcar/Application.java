package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 최초의 입력
        System.out.println("경주할 자동 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();

        String[] carNames = carNamesInput.split(",");

        validateInput(carNames);

    }


    public static void validateInput(String[] inputs) {
        for (String input : inputs) {
            System.out.println("======== input : " + input);
            if (input.length() > 5) {
                throw new IllegalArgumentException("CarName can not exceed over 5 character");
            }
        }
    }
}
