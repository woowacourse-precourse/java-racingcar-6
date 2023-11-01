package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Global.INPUT_CARS_NAMES);
        Input input = new Input();
        String carInput = Console.readLine();
        input.getCarInfo(carInput);
        System.out.println(Global.INPUT_EXECUTE_TIME);
        String executeTimeInput = Console.readLine();
        input.getInfoExecuteCountInfo(executeTimeInput);
        Racing racing= new Racing(input.getCars());
        racing.startRacing(input.getExecuteCount());
        Result result = new Result();
        result.showResult();
        result.showRacingResult(racing.getPosition(),input.getExecuteCount());
        result.showWinners(racing.getWinnersNames(racing.getPosition()));


    }
}
