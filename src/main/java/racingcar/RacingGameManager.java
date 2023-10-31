package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class RacingGameManager {
    private List<String> carList;
    private Long racingTry;

    /**
     * 자동차 경주 진행 함수
     * 입력: 없음
     * 출력: 없음
     */
    public void gameManager() {
        Validator validator = new Validator();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (validator.validate(input)) {
            carList = Arrays.asList(input.split(","));
            System.out.println("시도할 회수는 몇회인가요?");
        }

        input = Console.readLine();
        if (validator.validate(input))
            this.racingTry = Long.parseLong(input);

        for (int i = 0; i < racingTry; i++) {
            System.out.println("\n실행 결과");
            moveCar();
            showCarMoveResult();
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", getWinnerList()));
    }

    /**
     * 자동차 이동 함수
     * 입력: 없음
     * 출력: 없음
     */
    private void moveCar() {}

    /**
     * 자동차 이동 결과 표시 함수
     * 입력: 없음
     * 출력: 없음
     */
    private void showCarMoveResult() {}

    /**
     * 우승자 확인 함수
     * 입력: 없음
     * 출력: List<String>(우승자의 이름을 담은 리스트)
     */
    private List<String> getWinnerList() {return null;}
}
