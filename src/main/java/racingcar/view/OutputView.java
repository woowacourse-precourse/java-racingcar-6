package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printCarNameNPosition(List<String>carNameList, List<Integer> carPositionList) {
        for (int i=0;i<carNameList.size();i++) {
            System.out.println(carNameList.get(i)+" : " + "-".repeat(carPositionList.get(i)));
        }
    }

    public static void printWinnerNameList(List<String>winnerNameList) {
        for (int i=0;i<winnerNameList.size();i++) {
            System.out.print(winnerNameList.get(i));
            if (i != winnerNameList.size()-1) { System.out.print(", "); }
        }
    }

}
