package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        String[] carList = cars.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int raceCount = Integer.parseInt(readLine());

        Racing racing = new Racing(carList, raceCount);

        System.out.println("\n실행 결과");
        racing.race();
        racing.findWinner();
    }
}
