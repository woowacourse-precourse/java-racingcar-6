package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public class ConsolePrintServiceImpl implements PrintService{
    @Override
    public void printInputNameNotice() {
        System.out.println(OutputSentence.INPUT_NAME_NOTICE.getSentence());
    }

    @Override
    public void printInputCountNotice() {
        System.out.println(OutputSentence.INPUT_COUNT_NOTICE.getSentence());
    }

    @Override
    public void printResultNotice() {
        System.out.println(OutputSentence.RESULT_NOTICE.getSentence());
    }

    @Override
    public void printGameResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            int distance = car.getDistance();
            for (int i=0;i<distance;i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    @Override
    public void printFinalGameResult(List<String> carNameList) {
        System.out.print(OutputSentence.GAME_WINNER_NOTICE.getSentence());
        String carNamesResult = "";
        for(String carName:carNameList){
            carNamesResult += carName;
            carNamesResult += ", ";
        }
        carNamesResult = carNamesResult.substring(0, carNamesResult.length() - 2);
        System.out.println(carNamesResult);
    }
}
