package racingcar.output;

import java.util.List;
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
        for (CarDto carDto : carDtoList) {
            StringBuffer result = new StringBuffer()
                    .append(carDto.name())
                    .append(" : ")
                    .append("-".repeat(carDto.forwardCount()));
            System.out.println(result);
        }
        System.out.println();
    }

    public void printGameResult(List<Winner> winners) {

    }
}
