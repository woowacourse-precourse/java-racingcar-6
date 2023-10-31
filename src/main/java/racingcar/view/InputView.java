package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.dto.InputCarDto;

public class InputView {

    private static final String DELIMITER = ",";

    public static InputCarDto printInputCarName(){
        System.out.printf("경주할 자동차 이름을 입력하세요. (이름은 쉼표(%s) 기준으로 구분)%n", DELIMITER);
        return new InputCarDto(readLine(), DELIMITER);
    }

    public static String printInputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }
}
