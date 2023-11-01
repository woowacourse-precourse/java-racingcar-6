package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;

public class Application {
    static String InputCarName = "";
    static LinkedList<String> Winner = new LinkedList<>();
    static LinkedList<String> RacingCar = new LinkedList<>();
    static LinkedList<Integer> RacingScore = new LinkedList<>();
    static int TryNumber = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartMessage();
        InputCarName();
        Try_Message();
        Result_Message();
        Repeat_Racing();
        Racing_winner();
        Winner_Print();
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
                Error();
            }
            RacingCar.add(carArray[i]);
            RacingScore.add(0);
        }
    }

    public static void Try_Message() {
        System.out.println("시도할 회수는 몇회인가요?");
        Try_Number();
    }

    public static void Try_Number() {
        String Input_TryNumber = readLine();
        if (isInteger(Input_TryNumber) == false) {
            Error();
        }
        TryNumber = Integer.parseInt(Input_TryNumber);
        if (TryNumber <= 0) {
            Error();
        }
    }

    public static void Error() {
        throw new IllegalArgumentException();
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
            Match_game();
            Print_result();
        }
    }

    public static void Match_game() {
        for (int i = 0; i < RacingCar.size(); i++) {
            int score = Randoms.pickNumberInRange(0, 9);
            if (score > 3) {
                int addScore = RacingScore.get(i) + 1;
                RacingScore.set(i, addScore);
            }
        }
    }

    public static void Print_result() {
        for (int i = 0; i < RacingCar.size(); i++) {
            String line = "";
            for (int j = 0; j < RacingScore.get(i); j++) {
                line = line + "-";
            }
            System.out.println(RacingCar.get(i) + " : " + line);
        }
        System.out.println();
    }

    public static void Racing_winner() {
        int max_score = 0;

        for (int i = 0; i < RacingCar.size(); i++) {
            if (RacingScore.get(i) > max_score) {
                max_score = RacingScore.get(i);
            }
        }
        for (int i = 0; i < RacingScore.size(); i++) {
            if (RacingScore.get(i) == max_score) {
                Winner.add(RacingCar.get(i));
            }
        }
    }

    public static void Winner_Print() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < Winner.size(); i++) {
            if (i == Winner.size() - 1) {
                System.out.println(Winner.get(i));
            } else {
                System.out.print(Winner.get(i) + ", ");
            }
        }
    }
}
