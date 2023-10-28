package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutView {
    private OutView() {
    }

    public static void printResultEachTrack(CarsDto cars){
        int carsNumber = cars.getCarArrayList().size();
        ArrayList<CarDto> carArrayList = cars.getCarArrayList();
        System.out.println("실행 결과");
        for(int i=0;i<carsNumber;i++){
            CarDto car = carArrayList.get(i);
            System.out.print(car.getCarName()+" : ");
            for(int j=0;j<car.getCurrentPosition();j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }


}
