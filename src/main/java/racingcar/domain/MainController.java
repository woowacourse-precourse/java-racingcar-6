package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;

public class MainController {

    CarGame carGame = new CarGame();
    public static int ATTEMPT_COUNT = 0;
    public static List<String> CARS;

    public void gameStart() {
        setInput();
        carGame.CarGame(CARS);

        for (int i = ATTEMPT_COUNT; i >= 1; i--) {
            //랜덤값 생성
            //중간 결과 출력
        }
    }

    private void setInput() {
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
