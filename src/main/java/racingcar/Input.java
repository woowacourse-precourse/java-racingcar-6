package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String[] cars;
    private int trys;
    private final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRYS = "시도할 회수는 몇회인가요?";

    public String[] getCars() {
        System.out.println(INPUT_CARS);
        String inputNames = Console.readLine();
        String[] carNames = inputNames.split(",");
        return carNames;
    }

    public int getTrys() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }

}
