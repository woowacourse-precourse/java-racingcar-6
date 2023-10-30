package racingcar.View;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class OutPutViewImpl implements OutPutView {

    private static final String HeaderPrompt = "\n실행 결과";
    private static final String RoundResultConcat = " : ";
    private static final String FooterPrompt = "\n최종 우승자 : ";
    private static final String FinalWinnerConcat = ", ";
    private static final String PositionCharacter = "-";

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
