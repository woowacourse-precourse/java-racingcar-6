package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.GameMessage.RUN;

public class CarRacing {
    private CarAndDistance carAndDistance = new CarAndDistance();

    public CarAndDistance racingController(String[] carsName, int numberTry) {

        DistanceCounting[] distanceCountingArray = new DistanceCounting[carsName.length];

        for(int i = 0; i < carsName.length; i++) {
            distanceCountingArray[i] = new DistanceCounting();
        }

        for(int j = 0; j < numberTry; j++){
            for(int i = 0; i < carsName.length; i++) {
                int random = Randoms.pickNumberInRange(0, 9);
                carAndDistance.setCarAndDistance(carsName[i], distanceCountingArray[i].passCheck(random));
            }
            if(j == 0) System.out.println(RUN);
            intermediateResults(carsName.length);
        }
        return carAndDistance;
    }

    public void intermediateResults(int j) {
        for(int i = 0; i < j; i++) {
            System.out.println(carAndDistance.carAndDistanceResult(j)[i]);
        }
        System.out.println();
    }
}
