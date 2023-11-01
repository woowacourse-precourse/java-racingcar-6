package racingcar;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static HashMap<String, Integer> race = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        initializeRace(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(readLine());

        System.out.println("실행 결과");
    }

    public static void initializeRace(String inputCarNames){
        String[] carNames = inputCarNames.split(",");

        for (String carName : carNames) {
            race.put(carName, 0);
        }
    }
}
