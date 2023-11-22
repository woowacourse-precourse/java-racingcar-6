package racingcar.Controller;

public class CarsController {

    public void checkCarsName(String CarsName) throws IllegalArgumentException{
        checkCarsNameLength(CarsName);
        checkCarsNameIsalpha(CarsName);
    }
    private void checkCarsNameLength(String carsName) {
        if(carsName.length()>5){
            throw new IllegalArgumentException();
        }
    }
    private void checkCarsNameIsalpha(String carsName){
        if(!carsName.matches("^[a-zA-Z]*$")){

        }
    }

}
