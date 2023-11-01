package racingcar.service;

import racingcar.constant.AnnouncerScript;
import racingcar.domain.Car;
import racingcar.utility.ProviderRandomValue;
import racingcar.view.Output;

import java.util.HashMap;
import java.util.Iterator;

public class Racing {

    private ProviderRandomValue providerRandomValue;
    private Judgement judgement;
    private Output output = Output.getOutput();

    private Car cars;

    public Racing() {
        providerRandomValue = new ProviderRandomValue();
        judgement = new Judgement();
    }

    public void play(Car carList, int attempt) {
        output.printMessage(AnnouncerScript.EXCUTION_RESULT);
        cars = carList;

        for (int i = 0; i < attempt; i++) {
            Iterator<String> carNames = carList.getCarName().iterator();
            raceCar(carNames);
            output.printMessage(AnnouncerScript.FINISH_ONE_ROUND);
        }

        output.printMessage(AnnouncerScript.WINNER);
        output.printMessage(judgement.findWinner(cars));
    }

    private void raceCar(Iterator<String> carNames) {
        while (carNames.hasNext()) {
            String carName = carNames.next();

            int random = providerRandomValue.returnRandomNumeric();

            if (judgement.isMovableRange(random)) {
                moving(carName);
            }

            printResult(carName);
        }
    }

    private void moving(String carName) {
        cars.setMovingCount(carName);
    }

    private void printResult(String carName) {
        String movingCount = "";
        String result;

        for (int i = 0; i < cars.getMovingCount(carName); i++) {
            movingCount += "-";
        }

        result = String.format("%s : %s\n", carName, movingCount);

        output.printMessage(result);
    }

    private void decideWinner() {

    }

}
