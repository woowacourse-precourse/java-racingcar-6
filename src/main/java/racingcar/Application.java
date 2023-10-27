package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = readLine();
        List<String> carList = List.of(cars.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(readLine());
    }
}
