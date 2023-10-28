package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;

public class OutView {

    private final static String DEFAULT_TRAVEL_LENGTH = "-";

    public static void printCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceResults(List<CarDto> carDtoList) {
        for(CarDto carDto : carDtoList){
            System.out.printf("%s : %s \n", carDto.name(), DEFAULT_TRAVEL_LENGTH.repeat(carDto.travelDistance()));
        }
        System.out.println();
    }

    public static void printFinalWinner(List<CarDto> carDtoList){
        String winners = carDtoList.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s", winners);
    }

    public static void printResults() {
        System.out.println("실행 결과");
    }
}
