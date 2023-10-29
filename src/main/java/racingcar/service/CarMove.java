package racingcar.service;


import java.util.ArrayList;
import java.util.List;

public class CarMove {

    public List<Integer> lengthCount = new ArrayList<>();
    private RandomNumber randomNumber;
    private CarName carName;

    public CarMove(CarName carName, RandomNumber randomNumber) {
        this.carName = carName;
        this.randomNumber = randomNumber;
    }

    public void initializeLengthList() {
        for (int i = 0; i < carName.rangeCarList.size(); i++) {
            lengthCount.add(0);
        }

    }
    public void increaseLength() {
        for (int i = 0; i < carName.rangeCarList.size(); i++) {
            int currentLength = lengthCount.get(i);
            if (randomNumber.generate() >= 4) {
                lengthCount.set(i, currentLength + 1);
            }
        }
    }
    public void drawHistogram() {
        for (int i = 0; i < carName.rangeCarList.size(); i++) {
            System.out.print(carName.rangeCarList.get(i) + " : ");
            for (int j = 0; j < lengthCount.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }


}