package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        String[] car_name = userInput.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        String mn = Console.readLine();
        int move_num = Integer.parseInt(mn);

        SizeComparison(car_name);
        startGame(move_num, car_name);
    }

    public static void SizeComparison(String[] carname) { // 차 이름이 5자 이하가 아니면 예외
        for (String s : carname) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void startGame(int mn, String[] carname) {
        String[] MoveCount = new String[carname.length];
        Arrays.fill(MoveCount, "");
        System.out.println("실행 결과");
        for (int num = 0; num < mn; num++) {
            System.out.println();
            for (int i = 0; i < carname.length; i++) {
                MoveCount[i] = GoOrStop(MoveCount[i]);
                System.out.println(carname[i] + " : " + MoveCount[i]);
            }
        }
        WhoIsWinner(MoveCount, carname);
    }

    public static String GoOrStop(String movecount){ //전진인지 아닌지 구별
        int computer = Computer.getRandomNumber();
        if (computer >= 4){
            movecount += "-";
        }
        return movecount;
    }

    public static void WhoIsWinner(String[] mc, String[] cn){
        int CntMax = 0;
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < mc.length; i++){
            if (CntMax < mc[i].length()){
                CntMax = mc[i].length();
                name.clear();
                name.add(cn[i]);
            }
            else if (CntMax == mc[i].length()){
                name.add(cn[i]);
            }
        }
        PrintWinner(name);
    }
    public static void PrintWinner(ArrayList<String> name){}
}

class Computer {
    public static int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}