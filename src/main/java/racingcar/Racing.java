package racingcar;

public class Racing {
    Car[] cars;
    int raceCount;
    public Racing(String[] carList, int raceCount) {
        this.raceCount = raceCount;
        cars = new Car[carList.length];
        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i], 0);
        }
    }


}
