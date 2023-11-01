package racingcar.view;

import racingcar.model.CarDto;

import java.util.List;

import static racingcar.utility.Constants.EXECUTION_RESULT;
import static racingcar.utility.Constants.COLON;
import static racingcar.utility.Constants.ADVANCEMENT;

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

    private void printAdvancementCount(int advancementCount){
        for(int i = 0; i < advancementCount; i++){
            System.out.print(ADVANCEMENT);
        }
    }

    private void printNewLine(){
        System.out.println();
    }
}
