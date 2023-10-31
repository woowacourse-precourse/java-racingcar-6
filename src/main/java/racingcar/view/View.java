package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.WinnerResponseDto;

public class View {

    public static void printProgress(CarsResponseDto carsResponseDto) {
        StringBuilder message = new StringBuilder();
        for (Car car : carsResponseDto.cars()) {
            message.append(car.getName())
                    .append(" : ")
                    .append(car.progressBar())
                    .append("\n");
        }
        System.out.println(message);
    }

    public static void printWinner(WinnerResponseDto winners) {
        String winnerNames = String.join(",", winners.winnerNames());
        System.out.println(winnerNames);
    }
}
