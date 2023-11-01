package racingcar.View;

import racingcar.Domain.CarGroup;

public interface OutPutView {

    void showHeaderPrompt();

    void showRoundResult(CarGroup carGroup);

    void showFinalWinner(CarGroup carGroup);
}
