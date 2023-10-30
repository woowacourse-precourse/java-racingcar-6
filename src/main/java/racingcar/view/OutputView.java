package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printFirstSeparator() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public static void printCarNameNPosition(List<String>carNameList, List<Integer> carPositionList) {
        for (int i=0;i<carNameList.size();i++) {
            System.out.println(carNameList.get(i)+" : " + "-".repeat(carPositionList.get(i)));
        }
        System.out.println();
    }

    public static void printWinnerNameList(List<String>winnerNameList) {
        System.out.print("최종 우승자 : ");
        for (int i=0;i<winnerNameList.size();i++) {
            System.out.print(winnerNameList.get(i));
            if (i != winnerNameList.size()-1) { System.out.print(", "); }
        }
    }

}
