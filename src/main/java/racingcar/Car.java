package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    Input input = new Input();
    Validator validator = new Validator();

    public List<String> splitByComma(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(","));
        validator.isLengthOverFive(carNames);
        return carNames;
    }

    public void nowRacing(List<String> carNames, int tryNumber) {
        for (String str : carNames) {
            System.out.print(str + " : ");
            System.out.println(goOrStop(tryNumber));
        }
    }

    private String goOrStop(int tryNumber) {
        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < tryNumber; i++) {
            if (Randoms.pickNumberInRange(0,9) > 4) {
                bar.append("-");
            }
        }
        return bar.toString();
    }


}
