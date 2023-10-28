package racingcar.service.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.domain.Car;

public class InputView implements Input{
    @Override
    public List<Car> getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = getCars();
        System.out.println("시도할 회수는 몇회인가요?");
        int time = getTime();
        return null;
    }

    private static int getTime() {
        String timeInput = Console.readLine();
        return Integer.parseInt(timeInput);
    }

    private static String[] getCars() {
        String input = Console.readLine();
        return input.split(",");
    }
}
