package racingcar.domain2;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;
import racingcar.domain.RandomNumberGenerator;

public class MainController {

    CarGame carGame = new CarGame();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    ScorePrinter scorePrinter = new ScorePrinter();
    public static int ATTEMPT_COUNT = 0;
    public static List<String> CARS;

    public void gameStart() {
        setInput();
        carGame.CarGame(CARS);

        System.out.println(CARS);

        for (int i = ATTEMPT_COUNT; i >= 1; i--) {
            attemptWithRepeat();
        }
        scorePrinter.printFinalScore(); //최종 점수 출력
    }

    private void attemptWithRepeat() {
        //randomNumberGenerator.setUserRandomValue(CARS); //랜덤값 생성
        scorePrinter.printMidtermScore(); //중간 점수 출력
    }

    private void setInput() { //+유효검사
        Validator validator = new Validator();

        CARS = getCarNameInput();
        validator.validatorForCar(CARS);
        ATTEMPT_COUNT = getAttemptCountInput();
        validator.validatorForAttemptCount(ATTEMPT_COUNT);
    }

    private int getAttemptCountInput() {
        String answer = Console.readLine();

        return Integer.parseInt(answer);
    }

    private List<String> getCarNameInput() {
        String answer = Console.readLine();

        return toListString(answer);
    }

    public List<String> toListString(String str) {
        String[] arry = str.split(",");

        List<String> list = new ArrayList<>();
        for (String sample : arry) {
            list.add(sample);
        }

        return list;
    }
}
