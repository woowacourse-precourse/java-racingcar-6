package racingcar.view;

import racingcar.model.Cars;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
    public void printRoundResult(Cars cars) {
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
