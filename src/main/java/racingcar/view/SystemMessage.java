package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class SystemMessage {

    StringBuilder stringBuilder = new StringBuilder();

    public void printRequestInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRacingResult(List<RacingCar> racingCars) {
        System.out.println("실행 결과");

        for (RacingCar racingCar : racingCars) {
            String carName = racingCar.getCarName();
            String forward = "-".repeat(racingCar.getForwardCount());

            String result = stringBuilder.append(carName).append(" : ").append(forward).toString();

            System.out.println(result);
        }
    }

    public void printWinnerMessage(List<String> winners) {
        String winnerMessage = String.join(",", winners);

        System.out.println("최종 우승자 : " + winnerMessage);
    }
}
