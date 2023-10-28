package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashMap;

public class Application {
    static String InputCarName = "";
    static HashMap<String, Integer> racingcar = new HashMap<>();
    static int TryNumber = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartMessage();
        InputCarName();
        Try_Message();
        Result_Message();
        Repeat_Racing();
    }

    public static void StartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void InputCarName() {
        InputCarName = readLine();
        Exception_Handling();
    }

    public static void Exception_Handling() {
        String[] carArray = InputCarName.split(",");
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            racingcar.put(carArray[i], 0);
        }
    }

    public static void Try_Message() {
        System.out.println("시도할 회수는 몇회인가요?");
        Try_Number();
    }

    public static void Try_Number() {
        String Input_TryNumber = readLine();
        if (isInteger(Input_TryNumber) == false) {
            throw new IllegalArgumentException();
        }
        TryNumber = Integer.parseInt(Input_TryNumber);
    }

    public static boolean isInteger(String Input_TryNumber) {
        try {
            Integer.parseInt(Input_TryNumber);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void Result_Message() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void Repeat_Racing() {
        for (int i = 0; i < TryNumber; i++) {
            
        }
    }


}
