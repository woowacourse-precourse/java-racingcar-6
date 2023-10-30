package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameBeforeSplit, numberOfMoves;
        carNameBeforeSplit = readLine();

        // 입력 받은 문자열을 쉼표를 기준으로 구분하여 자동차 이름 저장하기
        String[] carNameAfterSplit = carNameBeforeSplit.split(",");
        ArrayList<String> carList = new ArrayList<String>(Arrays.asList(carNameAfterSplit));

        // 시도할 횟수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        numberOfMoves = readLine();
    }

}
