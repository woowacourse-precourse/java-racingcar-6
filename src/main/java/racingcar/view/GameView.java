package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameViewConstant;
import racingcar.model.CarDto;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    public static String carNameView() {
        System.out.println(GameViewConstant.CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int gameCountView() {
        System.out.println(GameViewConstant.GAME_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static void resultView(List<CarDto> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinners(List<CarDto> winners) {
        System.out.println(GameViewConstant.FINAL_WINNER + winners.stream().map(CarDto::getName).collect(Collectors.joining(", ")));
    }
}
