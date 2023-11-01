package racingcar;

import Service.RaceResult;
import camp.nextstep.edu.missionutils.Console;
import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Service.RaceInputCount.raceInputCount;
import static Service.RaceState.state;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer token = new StringTokenizer(Console.readLine(), ",");

        while (token.hasMoreTokens()) {
            carList.add(new Car(token.nextToken()));
        }

        // 게임 회수 입력
        int gameCount = raceInputCount();

        System.out.println("\n실행 결과");
        /**
         * 게임 회수만큼 레이스 진행
         */
        for (int i = 0; i < gameCount; i++) {
            for (Car car : carList) {
                car.race();
            }
            state(carList);
        }

        // 최종 우승자 결정
        List<String> winners = RaceResult.determineWinners(carList);
        RaceResult.printWinners(winners);

    }
}
