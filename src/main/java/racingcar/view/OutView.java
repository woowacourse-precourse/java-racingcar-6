package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class OutView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String ADVANCE_MARK = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String SEPARATOR = ", ";

    private OutView() {
    }


    public static void printResult(ArrayList<CarsDto> resultList) {
        printResultMessage();
        printAllTryResult(resultList);
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static void printAllTryResult(ArrayList<CarsDto> resultList) {
        for (int i = 0; i < resultList.size(); i++) {
            ArrayList<CarDto> carArrayList = resultList.get(i).getCarArrayList();
            printEachTryResult(carArrayList);
            System.out.println();
        }
    }

    private static void printEachTryResult(ArrayList<CarDto> carArrayList) {
        carArrayList.stream()
                .forEach(carDto -> printEachCarResult(carDto));
    }

    private static void printEachCarResult(CarDto carDto) {
        int currentPosition = carDto.getCurrentPosition();
        System.out.print(carDto.getCarName() + COLON);
        while (currentPosition-- > 0) {
            System.out.print(ADVANCE_MARK);
        }
        System.out.println();
    }

    public static void printWinner(CarsDto carsDto) {
        ArrayList<CarDto> carArrayList = carsDto.getCarArrayList();
        List<String> winners = extractNameFromDto(carArrayList);
        String winner = String.join(SEPARATOR, winners);
        System.out.print(WINNER_MESSAGE + winner);
    }

    private static List<String> extractNameFromDto(ArrayList<CarDto> carArrayList) {
        List<String> winners = carArrayList.stream()
                .map(CarDto::getCarName)
                .collect(Collectors.toList());
        return winners;
    }

}
