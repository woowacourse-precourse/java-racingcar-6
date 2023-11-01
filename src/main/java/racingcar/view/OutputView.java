package racingcar.view;

import racingcar.domain.Cars;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "실행 결과";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
    public static void printRoundResult(Cars cars) {
        List<Car> carList = cars.getCars();
        for(int i=0;i<carList.size();++i){
            String result = carList.get(i).getName()+" : ";
            int step = carList.get(i).getStep();
            for(int j=0;j<step;++j){
                result+="-";
            }
            System.out.println(result);
        }
        System.out.println();
    }


}
