package racingcar.view;

import racingcar.controller.OutputController;
import racingcar.model.Model;

import java.util.List;
import java.util.Map;

import static racingcar.Constant.OutputMenu.*;

public class OutputView {
    private final OutputController outputController;
    public OutputView(Model model) {
        outputController = new OutputController(model);
    }

    public void start(){
        int count = outputController.getCount();
        Map<String, String> carList = outputController.getCarList();
        printRacingScore(count, carList);
        printWinners(carList, outputController.sortingCarListByScore(carList));
    }

    private void printRacingScore(int count, Map<String, String> carList) {
        System.out.println(OUTPUT_RESULT);
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, String> car : carList.entrySet()) {
                outputController.createRandomScore(car);
                System.out.println(car.getKey() + COLON + car.getValue());
            }
            System.out.println();
        }
    }




    private static void printWinners(Map<String, String> carList, List<String> carNameByKeyDesc) {
        System.out.print(FINAL_WINNER);
        String firstWinner = carNameByKeyDesc.get(0);
        int max = carList.get(firstWinner).length();
        System.out.print(firstWinner);

        for (int i = 1; i < carNameByKeyDesc.size(); i++) {
            String carName = carNameByKeyDesc.get(i);
            if (carList.get(carName).length() != max) break;
            System.out.print(COMMA_AND_SPACE + carName);
        }
    }
}
