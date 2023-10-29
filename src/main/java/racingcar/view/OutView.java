package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class OutView {
    private OutView() {
    }


    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResultEachTrack(CarsDto cars) {
        int carsNumber = cars.getCarArrayList().size();
        ArrayList<CarDto> carArrayList = cars.getCarArrayList();
        for (int i = 0; i < carsNumber; i++) {
            CarDto car = carArrayList.get(i);
            System.out.print(car.getCarName() + " : ");
            for (int j = 0; j < car.getCurrentPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printResultWinner(CarsDto carsDto) {
        ArrayList<CarDto> carArrayList = carsDto.getCarArrayList();
        List<String> winners = carArrayList.stream()
                .map(CarDto::getCarName)
                .collect(Collectors.toList());
        String winner = String.join(", ", winners);
        System.out.print("최종 우승자 : " + winner);
    }
}
