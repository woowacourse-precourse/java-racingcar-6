package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserInput {
    Verification verification = new Verification();

    private List<String> carNames;
    private int numberOfTry;

    //참가자 입력
    public void labelNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String readLine = Console.readLine();
        carNames = List.of(readLine.split(","));
        verification.verifyDuplication(carNames);
        verification.verifyArg(carNames);
    }

    //시도 회수 입력
    public void setupNumberOfTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        String readLine = Console.readLine();
        verification.verifyNumberOfTry(readLine);
        numberOfTry = Integer.valueOf(readLine);
    }


    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}
