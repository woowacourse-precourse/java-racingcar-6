package racingcar.output;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.CarDto;
import racingcar.domain.Winner;

public class OutputManager {
    public void printStartGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printTitleOfGameResult() {
        System.out.println("\n실행 결과");
    }

    public void printResultOfTrial(List<CarDto> carDtoList) {
        StringBuffer result = new StringBuffer();
        for (CarDto carDto : carDtoList) {
            result.append(carDto.name())
                    .append(" : ")
                    .append("-".repeat(carDto.forwardCount()))
                    .append("\n");
        }
        System.out.println(result);
    }

    public void printGameResult(List<Winner> winners) {
        String winnerNames = winners.stream()
                .map(Winner::name)
                .collect(Collectors.joining(", "));
        String gameResult = new StringBuffer()
                .append("최종 우승자 : ")
                .append(winnerNames)
                .toString();
        System.out.println(gameResult);
    }
}
