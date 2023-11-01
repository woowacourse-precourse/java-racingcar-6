package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carList = getCarList();
        List<Integer> distList = new ArrayList<>(Collections.nCopies(carList.size(), 0));
        System.out.println("시도할 회수는 몇회인가요?");
        int round = getGameRound();

        System.out.println("실행결과");
        List<String> winner = new ArrayList<>();
        for(int i = 0; i < round; ++i){
            winner = playGameRound(carList, distList);
            printGameScreen(carList, distList);
        }

        System.out.println("최종 우승자 : " + String.join(",",winner));
    }

    public static List<String> getCarList(){

        String carInput = Console.readLine();

        return new ArrayList<>(Arrays.asList(carInput.split(",")));
    }

    public static int getGameRound(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public static int getGoDist(){
        int percent = Randoms.pickNumberInRange(0, 9);
        if(percent >= 4) return 1;
        else return 0;
    }

    public static List<String> playGameRound(List<String> carList, List<Integer> distList){
        List<String> winner = new ArrayList<>();
        int highScore = 0;
        for(int i = 0; i < carList.size(); ++i){
            int score = distList.get(i) + getGoDist();
            distList.set(i, score);
            if(highScore == score){
                winner.add(carList.get(i));
            }else if(highScore < score){
                winner.clear();
                winner.add(carList.get(i));
                highScore = score;
            }
        }

        return winner;
    }

    public static void printGameScreen(List<String> carList, List<Integer> distList){
        for(int i = 0; i < carList.size(); ++i){
            System.out.print(carList.get(i) + " : ");
            printCarDist(distList.get(i));
        }
        System.out.print("\n");
    }

    public static void printCarDist(int n){
        for(int i = 0; i < n; ++i){
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
