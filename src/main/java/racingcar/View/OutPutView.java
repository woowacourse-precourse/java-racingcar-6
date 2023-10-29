package racingcar.View;

import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutView {

    public static void showRoundResult(CarGroup carGroup) {
        for (int order = 1; order <= carGroup.findSize(); order++) {
            Car findCar = carGroup.findCarByOrder(order);
            System.out.println(findCar.findName() + " : " + makeIndividualResult(findCar.findPosition()));
        }
    }

    public static void showFinalWinner(CarGroup carGroup) {

    }


    public static String makeIndividualResult(Integer position) {
        return "-".repeat(Math.max(0, position));
    }
}
