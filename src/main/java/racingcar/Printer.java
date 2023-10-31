package racingcar;

import java.util.List;

public class Printer {

    public static void settingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void settingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void raceStart() {
        System.out.println("실행 결과");
    }

    public static void raceResult(List<String> results) {
        System.out.println("최종 우승자 : " + String.join(", ", results));
    }
}
