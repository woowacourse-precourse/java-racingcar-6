package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.ConvertUtil;

public class OutputView {

    public static void printResult(){
        System.out.println("실행 결과");
    }

    public static void printPosition(List<Car> cars){
        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(car.getName() + " : " + ConvertUtil.convertPositionToStr(position));
        }
        System.out.println();
    }
}
