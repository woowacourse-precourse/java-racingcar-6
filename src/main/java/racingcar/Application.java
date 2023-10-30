package racingcar;

import Carset.CarNamedSet;

public class Application {
    public static void main(String[] args) {
        CarNamedSet carname = new CarNamedSet();
        carname.NameSetting(); // 먼저 이름을 설정
        carname.PrintCar(); 
    }
}
