package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Controller.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;
    private static List<String> carNames;
    private static List<Integer> racingCarRandomNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        carNames = new ArrayList<>();
        String str = Console.readLine();
        String[] carArray = str.split(",");

        carNames.addAll(Arrays.asList(carArray));
        System.out.println(carNames);

        int racingCarNameCount = Integer.parseInt(Console.readLine());

        List<Integer> stopAndGo = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        for (int i = 0; i < racingCarNameCount; i++) {
            racingCarRandomNumber = new ArrayList<>();

            for (int j = 0; j < carNames.size(); j++) {
                int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
                System.out.print(carNames.get(j) + " : ");
                racingCarRandomNumber.add(randomNumber);
                for (int k = 0; k < racingCarRandomNumber.get(j); k++) {
                    System.out.print("-");
                }
                if (racingCarRandomNumber.get(j) >= 4) {
                    stopAndGo.set(j, stopAndGo.get(j) + 1);
                }
                System.out.println();
            }
        }
        int maxStopAndGo = Collections.max(stopAndGo);
        List<String> maxStopAndGoValues = new ArrayList<>();
        for (int i = 0; i < stopAndGo.size(); i++) {
            if (stopAndGo.get(i) == maxStopAndGo) {
                maxStopAndGoValues.add(carNames.get(i));
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < maxStopAndGoValues.size(); i++) {
            System.out.print(maxStopAndGoValues.get(i));
            if(i<maxStopAndGoValues.size()-1){
                System.out.print(", ");
            }
        }
    }
}
