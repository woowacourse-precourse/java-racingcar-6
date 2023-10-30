package racingcar.View;

import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutView {

    public void showPrompt() {
        System.out.print("\n실행 결과");
    }

    public void showRoundResult(CarGroup carGroup) {
        System.out.println();
        for (int order = 1; order <= carGroup.findSize(); order++) {
            Car findCar = carGroup.findCarByOrder(order);
            System.out.println(findCar.findName() + " : " + makeIndividualResult(findCar.findPosition()));
        }
    }

    public void showFinalWinner(CarGroup carGroup) {
        CarGroup finalWinners = carGroup.findFinalWinner();
        System.out.print("\n최종 우승자 : ");
        for (int order = 1; order <= finalWinners.findSize(); order++) {
            Car findCar = finalWinners.findCarByOrder(order);
            System.out.print(findCar.findName());
            if (order != finalWinners.findSize()) {
                System.out.print(", ");
            }
        }
    }


    private String makeIndividualResult(Integer position) {
        return "-".repeat(Math.max(0, position));
    }
}
