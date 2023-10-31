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

        Iterator<String> carNames = carList.getCarName().iterator();
        while (carNames.hasNext()) {
            String carName = carNames.next();

            raceCar(carName);
            printResult(carName);
        }
    }

    private void raceCar(String carName) {
        int random = providerRandomValue.returnRandomNumeric();

        if (judgement.isMovableRange(random)) {
            moving(carName);
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

        result = String.format("%s : %s", carName, movingCount);

        output.printMessage(result);
    }
}
