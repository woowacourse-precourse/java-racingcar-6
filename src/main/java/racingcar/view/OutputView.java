package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public final class OutputView {

    private static final String NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_GUIDE = "실행 결과";
    private static final String COLON_DELIMITER = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNERS_GUIDE = "최종 우승자";
    private static final String COMMA_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printNamesGuide() {
        System.out.println(NAMES_INPUT_GUIDE);
    }

    public static void printTrialGuide() {
        System.out.println(TRIAL_INPUT_GUIDE);
    }

    public static void printResultGuide() {
        System.out.println();
        System.out.println(RESULT_GUIDE);
    }

    public static void printRoundResult(final CarsDto carsDto) {
        List<CarDto> carDtos = carsDto.carDtos();
        for (CarDto carDto : carDtos) {
            String carName = carDto.name();
            String currentPosition = replaceToHyphens(carDto.position());
            System.out.println(String.join(COLON_DELIMITER, carName, currentPosition));
        }
        System.out.println();
    }

    private static String replaceToHyphens(final int position) {
        return HYPHEN.repeat(position);
    }

    public static void printWinnersName(final List<String> winnersName) {
        System.out.println(String.join(COLON_DELIMITER, WINNERS_GUIDE, divideNamesByComma(winnersName)));
    }

    private static String divideNamesByComma(final List<String> names) {
        return String.join(COMMA_DELIMITER, names);
    }

}
