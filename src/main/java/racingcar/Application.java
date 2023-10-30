package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCar = Console.readLine();
        String[] car = inputCar.split(",");
        int carCount = car.length;

        String inputTime = Console.readLine();
        int time = Integer.parseInt(inputTime);


        InputCarName inputCarName = new InputCarName();
        List<Integer> track;
        track = inputCarName.makeTrack(carCount);

        for(int i=0;i<time;i++){
            CarSimulate carSimulate = new CarSimulate();
            carSimulate.goSimulate(carCount,track);
            carSimulate.viewCurrentProgress(carCount,car,track);
            System.out.println();

        }


    }
}
