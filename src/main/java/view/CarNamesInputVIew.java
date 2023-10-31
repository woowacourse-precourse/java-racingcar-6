package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class CarNamesInputVIew {
    public String[] receiveCarNames() {
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        System.out.println(Arrays.toString(carNames));
        return carNames;
    }
}
