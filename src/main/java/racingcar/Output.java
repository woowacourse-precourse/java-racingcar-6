package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {


    // 커맨드 출력
    public void startGamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    // 시도할 횟수 출력
    public void roundsPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    // 상황 출력
    public void printNow(List<Car> cars) {
        cars.stream()
                .forEach(car -> {
                    int dashesCount = car.getPosition();
                    String dashes = "-".repeat(dashesCount);
                    System.out.println(car.getName() + " : " + dashes);
                });
        System.out.println("\n");
    }

    // 최종 우승자 출력
    public void printWinner(List<Car> winners) {
        List<String> winnersNames = new ArrayList<>();
        for (Car car : winners) {
            winnersNames.add(car.getName());
        }
        String winnersString = String.join(",", winnersNames);
        System.out.println("최종 우승자 : " + winnersString);

    }

}
