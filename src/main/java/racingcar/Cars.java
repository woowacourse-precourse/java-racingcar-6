package racingcar;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> carList = new ArrayList<Car>();

    public void createCars(ArrayList<String> carNameList){
        carNameList.forEach((name)->{
            addCarToCarList(name);
        });
    }
    private void addCarToCarList(String carName){
        carList.add(new Car(carName));
    }
    public String doRace(){
        StringBuilder raceMsg = new StringBuilder();
        carList.forEach((car)->{
            car.tryMove();
            raceMsg.append(createRaceMsg(car));
        });
        return raceMsg.toString();
    }
    public String createRaceMsg(Car car){
        String name = car.getName();
        int location = car.getLocation();
        String locationVar = "-".repeat(location);
        return String.format("%s : %s\n", name, locationVar);
    }

    public ArrayList<String> CheckFinalWinner(){
        int max    = 0;
        ArrayList<String> winnerName = new ArrayList<>();

        for(Car car: carList){
            if (car.getLocation()>max){
                winnerName.clear();
                winnerName.add(car.getName());
                max=car.getLocation();
            } else if (car.getLocation()==max) {
                winnerName.add(car.getName());
            }
        };
        return winnerName;
    }


}
