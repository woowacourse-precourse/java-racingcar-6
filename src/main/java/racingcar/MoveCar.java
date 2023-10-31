package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCar {
    public String CarMove(int move){
        String position = "";
        for(int i = 0; i<move; i++){
            position+="-";
        }
        return position;
    }

    public Car[] CreateCar(String[] carNames){
        Car[] cars = new Car[carNames.length];
        MoveCar moveCar = new MoveCar();
        for(int i = 0; i< carNames.length;i++){
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public void PrintPosition(Car[] cars,MoveCar moveCar){
        for(Car car: cars){
            int move = Randoms.pickNumberInRange(0, 9);
            if(move >= 4){
                car.MoveCar();
            }
            System.out.println(car.ReturnCarName() + ":" +moveCar.CarMove(car.ReturnMove()));
        }
    }

}

