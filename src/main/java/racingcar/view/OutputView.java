package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public final class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String COMMA = ", ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<CarDto> carDtos) {

        carDtos.stream()
                .forEach(OutputView::printDtoInfo);
        System.out.println();
    }

    public static void printFinalWinner(List<String> winnerNames) {

        System.out.print(FINAL_WINNER + COLON);
        for(int i = 0; i < winnerNames.size();) {
            System.out.print(winnerNames.get(i));
            if(++i < winnerNames.size()) {
                System.out.print(COMMA);
            }
        }
        System.out.println('\n');
    }

    private static void printDtoInfo(CarDto carDto) {

        System.out.print(carDto.getName() + COLON);
        for(int i = 0; i< carDto.getPosition(); i++) {
            System.out.print(HYPHEN);
        }
        System.out.println();
    }
}
