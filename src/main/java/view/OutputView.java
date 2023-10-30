package view;

import domain.ConstantUtil;
import java.util.List;

public class OutputView {

    public void enterCarNamesMessage() {
        System.out.println(ConstantUtil.ENTER_CAR_NAMES_MESSAGE);
    }

    public void enterTryNumberMessage() {
        System.out.println(ConstantUtil.ENTER_TRY_NUMBER_MESSAGE);
    }

    public void printResult(List<String> carNames, int[] result) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            System.out.print(carName + " : ");
            for (int j = 0; j < result[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
