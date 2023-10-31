package racingcar.view;

import racingcar.constant.GameViewConstant;
import racingcar.model.CarDto;
import racingcar.model.GameDto;

import java.util.Map;

public class GameView {
    public static void printRaceResult(GameDto gameDto) {
        Map<String, CarDto> cars = gameDto.getCars();
        for (String carName : cars.keySet()) {
            System.out.print(carName + " : ");
            printPosition(cars.get(carName).getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {//현재 간 위치를 표시하는 메서드
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(String winner) {//최종 우승자를 출력하는 메소드
        System.out.println(GameViewConstant.FINAL_WINNER + winner);
    }
}
