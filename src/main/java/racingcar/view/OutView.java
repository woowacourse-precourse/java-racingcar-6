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

    public static void printResult(ArrayList<CarsDto> resultList) {
        printResultMessage();
        for(int i=0;i<resultList.size();i++){
            ArrayList<CarDto> carArrayList = resultList.get(i).getCarArrayList();
            printEachTrack(carArrayList);
            System.out.println("");
        }
    }

    private static void printEachTrack(ArrayList<CarDto> carArrayList) {
        carArrayList.stream()
                .forEach(carDto -> printEachCar(carDto));
    }

    private static void printEachCar(CarDto carDto) {
        int currentPosition = carDto.getCurrentPosition();
        System.out.print(carDto.getCarName()+" : ");
        while (currentPosition-->0){
            System.out.print("-");
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
