package racingcar.view;


import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printResult() {
        System.out.println("\n실행 결과");
    }
    public static void printLineBreaking() {
        System.out.print("\n");
    }
    public static void printResultDetail(String carName, int goNumber) {
        System.out.print(carName+" : ");
        for (int i = 0; i < goNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(ArrayList<Integer> maxIndexList, List<String> carNameList) {
        System.out.print("최종 우승자 : ");
        for (Integer maxIndex : maxIndexList) {
            System.out.print(carNameList.get(maxIndex));

            if (maxIndex < maxIndexList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
