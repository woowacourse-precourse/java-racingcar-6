package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.NCars;

public class Application {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(Console.readLine().split(","));
        NCars nCars  = NCars.applyNames(names);
        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());

        for (int i = 0 ; i < round ;i++) {
            nCars.moveCars();
            view(nCars.getSingleRoundResult());
        }

        viewWinner(nCars.getWinnerName());
    }
    public static void view(List<String> message){
        for(String msg : message){
            System.out.println(msg);
        }
    }
    public static void viewWinner(List<String> message){
        for(String msg : message){
            System.out.println("최종 우승자 : " +msg);
        }
    }
}
