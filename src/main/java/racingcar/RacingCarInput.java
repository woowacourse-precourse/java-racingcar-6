package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class RacingCarInput {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public String getCarNames(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine();
        System.out.println(carNames);

        return carNames;
    }

    public int getTryCount(){
        System.out.println(TRY_INPUT_MESSAGE);
        int tryCnt = Integer.parseInt(Console.readLine());
        System.out.println(tryCnt);

        return tryCnt;
    }
}
