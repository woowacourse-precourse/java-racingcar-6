package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.InputException.Handler;
import racingcar.model.GameManager;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static String firstMent = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String secondMent = "시도할 회수는 몇회인가요?";
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(firstMent);


        //이름 입력
        String nameInput = Console.readLine();
        List<String> carNameList = Arrays.asList(nameInput.split(","));
        Handler.nameException(carNameList);


        System.out.println(secondMent);


        String num = Console.readLine();
        //입력값에 대한 예외처리
        if(!Handler.numberException(num)) throw new IllegalArgumentException();

        //예외 안날 시 Type 변환
        int afterNum = Integer.parseInt(num);
        //입력값 세팅
        GameManager gameManager = new GameManager(carNameList, afterNum);

        gameManager.gameStart();

    }
}
