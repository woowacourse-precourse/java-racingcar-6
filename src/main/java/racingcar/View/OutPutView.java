package racingcar.View;

import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutView {

    public void showRoundResult(CarGroup carGroup) {
        for (int order = 1; order <= carGroup.findSize(); order++) {
            Car findCar = carGroup.findCarByOrder(order);
            System.out.println(findCar.findName() + " : " + makeIndividualResult(findCar.findPosition()));
        }
    }

    public void showFinalWinner(CarGroup carGroup) {
        CarGroup finalWinners = carGroup.findFinalWinner();
        System.out.print("최종 우승자 : ");
        for (int order = 1; order <= finalWinners.findSize(); order++) {
            Car findCar = finalWinners.findCarByOrder(order);
            System.out.print(findCar.findName());
            if (order != finalWinners.findSize()) {
                System.out.print(", ");
            }
        }
    }


    public String makeIndividualResult(Integer position) {
        return "-".repeat(Math.max(0, position));
    }
}
