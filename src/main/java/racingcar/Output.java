package racingcar;

import java.util.List;

public class Output {



    // 커맨드 출력
    public String startOutput() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    // 시도할 횟수 출력
    public String timeOutput() {
        return "시도할 회수는 몇회인가요?";
    }

    // 상황 출력 //TODO
    public void printNow(List<Car> cars) {

        cars.stream()
                .forEach(car -> {
                    int dashesCount = car.getCurrentPlace();
                    String dashes = "-".repeat(dashesCount);
                    System.out.println(car.getName() + " : " + dashes);
                });
    }

    // 최종 우승자 출력 //TODO

}
