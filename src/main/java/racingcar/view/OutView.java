package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.RaceConditionDto;

public class OutView {
    private static final String RACE_CAR_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUM_TRIES_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_PROMPT = "실행 결과";
    private static final String WINNER_PROMPT = "최종 우승자 : %s";
    private final static String DEFAULT_TRAVEL_LENGTH = "-";
    private static final String RACING_STATUS_PROMPT = "%s : %s \n";
    private static final String COMMA = ", ";


    public static void printCarNames(){
        System.out.println(RACE_CAR_PROMPT);
    }

    public static void printNumberOfAttempts(){
        System.out.println(NUM_TRIES_PROMPT);
    }

    public static void printRaceResults(RaceConditionDto raceConditionDto) {
        List<List<CarDto>> lists = raceConditionDto.raceCondition();
        for(List<CarDto> carDtoList : lists){
            printCarDtoList(carDtoList);
        }
    }

    public static void printFinalWinner(List<CarDto> carDtoList){
        String winners = carDtoList.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(COMMA));
        System.out.printf(WINNER_PROMPT, winners);
    }

    public static void printResults() {
        System.out.println(EXECUTION_RESULT_PROMPT);
    }

    private static void printCarDtoList(List<CarDto> carDtoList) {
        for(CarDto carDto : carDtoList){
            System.out.printf(RACING_STATUS_PROMPT, carDto.name(), DEFAULT_TRAVEL_LENGTH.repeat(carDto.travelDistance()));
        }
        System.out.println();
    }
}
