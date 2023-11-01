package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<String> getCarName(){

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

    public static void playGameRound(List<String> carList, List<Integer> distList){
        for(int i = 0; i < carList.size(); ++i){
            distList.set(i, distList.get(i) + getGoDist());
        }
    }

    public static void printGameScreen(List<String> carList, List<Integer> distList){
        for(int i = 0; i < carList.size(); ++i){
            System.out.print(carList.get(i) + " : ");
            pringCarDist(distList.get(i));
        }
    }

    public static void pringCarDist(int n){
        for(int i = 0; i < n; ++i){
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
