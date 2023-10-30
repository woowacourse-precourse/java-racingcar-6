package racingcar.View;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutViewImpl implements OutPutView {

    static private final String HeaderPrompt = "\n실행 결과";
    static private final String RoundResultConcat = " : ";
    static private final String FooterPrompt = "\n최종 우승자 : ";
    static private final String FinalWinnerConcat = ", ";
    static private final String PositionCharacter = "-";

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
        List<String> carNames = finalWinners.findCarNames();
        System.out.print(String.join(FinalWinnerConcat, carNames));
    }


    private String makeIndividualPosition(Integer position) {
        return PositionCharacter.repeat(position);
    }
}
