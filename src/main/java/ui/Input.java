package ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String input;
    public static final String InputCarNameFrontMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String InputCarMoveCountFrontMessage = "시도할 회수는 몇회인가요?";

    public static void carNameReadLine(){
        readLine(InputCarNameFrontMessage);
    }

    public static void carMoveCountReadLine(){
        readLine(InputCarMoveCountFrontMessage);
    }

    public static void readLine(String message){
        System.out.println(message);
        input = Console.readLine();
    }

}
