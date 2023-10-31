package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.asList(Console.readLine().split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
            Game game = new Game(cars, num);
            game.checkCarName();
            game.startGame();
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
