package racingcar.View;

import racingcar.Domain.Cars;
import racingcar.Domain.Result;

import java.util.List;

public class OutputView {
    //실행 결과, 우승자 출력 화면
    public static void OutputWinners(Cars cars) {
        Result result = Result.of(cars);
        List<String> winners = result.getWinner();
        winners.forEach(s -> {
            System.out.print(s + " ");
        });
    }

    public static void OutputResults(Cars cars) {
        System.out.println("실행 결과");
        cars.getCars().forEach(s -> {
            System.out.println(s.getName()+" : " + carPosition(s.getPosition()));
        });
    }

    private static String carPosition(int position) {
        String positionOutput = "";
        for (int i = 0; i < position; i++) {
            positionOutput += "-";
        }
        return positionOutput;
    }

}
