package racingcar;

import java.util.ArrayList;

public class Message {
    private final static String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String attemptNumbersMessage = "시도할 회수는 몇회인가요?";
    private final static String processMessage = "실행 결과";

    static void getStartMessage(){
        System.out.println(startMessage);
    }

    static void getAttemptNumberMessage() {
        System.out.println(attemptNumbersMessage);
    }

    static void getProcessMessage() {
        System.out.println(processMessage);
    }
    static void makeResultMessage(String carName, int forwards){
        String message = "";
        message = carName + " : ";
        for (int i = 0; i < forwards; i++){
            message = message.concat("-");
        }
        System.out.println(message);
    }
    static void getResultMessage(ArrayList<String> names){
        String resultMessage = "최종 우승자 : ";
        for (String name : names){
            resultMessage = resultMessage.concat(name);
        }
        System.out.println(resultMessage);
    }
}
