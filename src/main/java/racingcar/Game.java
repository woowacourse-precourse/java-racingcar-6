package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {

    public final int Max_Length = 5;
    public ArrayList<Car> carMembers = new ArrayList<>();
    public String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameAll = Console.readLine();

        if (carNameAll.isEmpty()){
            throw new IllegalArgumentException();
        }

        return carNameAll.split(",");
    }

    public void correctLength(String[] carName) {
        for (String rider : carName) {
            if (rider.length() > Max_Length) {
                throw new IllegalArgumentException();
            }
        }
    }


    public void carMembersConstructor(String[] members) {
        for (String rider : members) {
            Car carMember = new Car(rider);
            carMembers.add(carMember);
        }
    }







}
