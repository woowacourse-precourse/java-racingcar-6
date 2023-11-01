package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static ArrayList<String> playerCar = new ArrayList<>();
    static ArrayList<Integer> playerLine = new ArrayList<>();

    static ArrayList<String> winner = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine().trim();
        for(String carName: input.split(",")){
            if(carName.length() == 0 || carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름을 다시 입력해주세요.");
            }
            playerCar.add(carName);
            playerLine.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String testCase = readLine();

        try {
            Integer.parseInt(testCase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        System.out.println("\n" + "실행결과" + "\n");

        for(int i=0;i < Integer.parseInt(testCase);i++){
           for(int j=0;j<playerCar.size();j++){
               int randomNum = Randoms.pickNumberInRange(0,9);
               if(randomNum >=4){
                  playerLine.set(j,playerLine.get(j)+1);
               }
               System.out.println(playerCar.get(j).concat(" : ").concat("-".repeat(playerLine.get(j))));
           }
        }

    }
}
