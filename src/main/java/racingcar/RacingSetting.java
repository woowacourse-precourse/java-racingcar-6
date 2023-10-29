package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingSetting {
    CarNum carNum;
    MoveNum moveNum;

    String[] getName() {
        String inputCarName;
        String[] carNameParsing;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName = Console.readLine();
        isVaildInputCarName(inputCarName);
        carNameParsing = inputCarName.split(",");
        carNum = new CarNum(carNameParsing);
        return (carNameParsing);
    }

    void getMoveNum() {
        String inputMoveNum;

        System.out.println("시도할 회수는 몇회인가요?");
        inputMoveNum = Console.readLine();
        moveNum = new MoveNum(inputMoveNum);
    }

    void isVaildInputCarName(String inputCarName) throws IllegalArgumentException{
        if (inputCarName.matches(".*,,.*|.*,+$")) {
            throw new IllegalArgumentException("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
        }
    }
}
