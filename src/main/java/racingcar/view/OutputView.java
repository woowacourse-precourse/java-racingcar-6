package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingResult;
import racingcar.model.enums.SpecialSign;

public class OutputView {

    private enum OutputMessage {
        START("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
        TRY_COUNT("시도할 횟수는 몇회인가요?"),
        RESULT("실행 결과"),
        WINNER("최종 우승자");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void printStartMessage() {
        System.out.println(OutputMessage.START.getMessage());
    }

    public void printTryCountMessage() {
        System.out.println(OutputMessage.TRY_COUNT.getMessage());
    }

    public void printProcess(Cars cars) {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecialSign.NEW_LINE.getSign());
        for (Car car : cars.getCars()) {
            sb.append(car.getName())
                    .append(" ")
                    .append(SpecialSign.COLON.getSign())
                    .append(" ")
                    .append(SpecialSign.drawHyphen(car.getDistance()));
        }
        System.out.print(sb);
    }

    public void printRacingResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecialSign.NEW_LINE.getSign())
                .append(OutputMessage.RESULT.getMessage());
        System.out.print(sb);
    }

    public void printWinner(RacingResult racingResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecialSign.NEW_LINE.getSign())
                .append(OutputMessage.WINNER.getMessage())
                .append(SpecialSign.SPACE.getSign())
                .append(SpecialSign.COLON.getSign())
                .append(SpecialSign.SPACE.getSign())
                .append(racingResult.winners());
        System.out.print(sb);
    }
}
