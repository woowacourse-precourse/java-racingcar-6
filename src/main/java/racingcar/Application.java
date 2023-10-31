package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = "a,b,c,d";
        String[] carNames = inputString.split(",");
        MoveCar moveCar = new MoveCar();
        moveCar.PrintPosition(moveCar.CreateCar(carNames),3);

    }
}
