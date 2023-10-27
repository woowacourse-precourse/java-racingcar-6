package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;

public class RacingGame {

    private static final int MAX_NAME_SIZE = 5;

    private static final String STARTING_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTING_PHRASE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";

    LinkedHashMap<String, Integer> racingCars;
    int attemptingNum;

    public void startGame() {
        System.out.println(STARTING_PHRASE);
    }

    public void playGame() {

    }

    public String getInput() {
        String input = Console.readLine().trim();
        return input;
    }

    public LinkedHashMap<String, Integer> addHashMapWithNames(String input) {
        String[] names = input.split(",");
        racingCars = new LinkedHashMap<>();

        for (String name : names) {
            name = name.trim();
            checkValidCarName(name);
            racingCars.put(name, 0);
        }

        return racingCars;
    }

    public void checkValidCarName(String name) {
        if(name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }

    public void getAttemptingNum() {
        System.out.println(ATTEMPTING_PHRASE);
        attemptingNum = Integer.parseInt(Console.readLine());
    }

    public int generateRandomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

}
