package racingcar.model;

public class Cars {
    CarList carlist = new CarList();

    public void addCar(String names) {
        for (String name : names.split(",")) {
            carlist.add(name);
        }
    }

    public CarList getCarlist() {
        return carlist;
    }
}
