package racingcar.View;

import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutView {

    static final String HeaderPrompt = "\n실행 결과";
    static final String RoundResultConcat = " : ";
    static final String FooterPrompt = "\n최종 우승자 : ";
    static final String FinalWinnerConcat = ", ";
    static final String PositionCharacter = "-";

    public void showHeaderPrompt() {
        System.out.print(HeaderPrompt);
    }

    public void showRoundResult(CarGroup carGroup) {
        System.out.println();
        for (int order = 1; order <= carGroup.findSize(); order++) {
            Car findCar = carGroup.findCarByOrder(order);
            System.out.println(findCar.findName() + RoundResultConcat + makeIndividualPosition(findCar.findPosition()));
        }
    }

    public void showFinalWinner(CarGroup carGroup) {
        CarGroup finalWinners = carGroup.findFinalWinner();
        System.out.print(FooterPrompt);
        for (int order = 1; order <= finalWinners.findSize(); order++) {
            Car findCar = finalWinners.findCarByOrder(order);
            System.out.print(findCar.findName());
            if (order != finalWinners.findSize()) {
                System.out.print(FinalWinnerConcat);
            }
        }
    }


    private String makeIndividualPosition(Integer position) {
        return PositionCharacter.repeat(position);
    }
}
