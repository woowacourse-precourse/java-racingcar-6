package racingcar.view;

import racingcar.model.CarDto;
import racingcar.model.WinnerDto;

import java.util.List;

import static racingcar.utility.Constants.*;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView(){}

    public static OutputView getInstance(){
        return outputView;
    }

    public void printExecutionResultMessage(){
        System.out.println(EXECUTION_RESULT);
    }

    public void printExecutionResult(List<CarDto> carInformationList){
        for(int i = 0; i < carInformationList.size(); i++){
            System.out.print(carInformationList.get(i).getCarName() + COLON);
            printAdvancementCount(carInformationList.get(i).getAdvancementCount());
            printNewLine();
        }
        printNewLine();
    }

    public void printWinner(WinnerDto winnerDto){
        System.out.print(WINNER_ANNOUNCEMENT_MESSAGE + COLON + String.join(SEPARATOR,winnerDto.getWinner()));
    }

    private void printAdvancementCount(int advancementCount){
        for(int i = 0; i < advancementCount; i++){
            System.out.print(ADVANCEMENT);
        }
    }

    private void printNewLine(){
        System.out.println();
    }
}
