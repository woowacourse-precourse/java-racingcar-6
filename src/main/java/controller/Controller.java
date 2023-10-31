package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static exception.Validator.validateCarNameLength;
import static exception.Validator.validateNaturalNumber;

public class Controller {
    public String[] getCarNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNameLength(carNameList);

        return carNameList;
    }

    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int ROUND = Integer.parseInt(readLine());
        validateNaturalNumber(ROUND);
        System.out.println();

        return ROUND;
    }
}
