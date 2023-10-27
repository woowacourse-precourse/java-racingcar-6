package view;

import java.util.List;

public class OutputView {

    private static final String carNamesMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryNumberMessage = "시도할 회수는 몇회인가요?";

    public void enterCarNamesMessage() {
        System.out.println(carNamesMessage);
    }

    public void enterTryNumberMessage() {
        System.out.println(tryNumberMessage);
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
