package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.view.UserInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력값
        UserInput input = inputUser();
    }

    //1) 사용자 입력 처리 기능
    static UserInput inputUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        return new UserInput(carName, gameCount);
    }
}

//자동차 Car 클래스 생성
class Car {
    String carName;
    int count;

    Car(String carName, int count) {
        this.carName = carName;
        this.count = count;
    }
}

//각 시행 별 자동차들 관리하는 컨트롤 Service
class CarService {
    UserInput input;
    ArrayList<Car> carList = new ArrayList<>();

    CarService(UserInput input) {
        this.input = input;
        this.carList = changeUserInputToCarList(input);
    }

    //1) 입력받은 자동차 이름별 Car클래스 생성 및 리스트에 담기
    public ArrayList<Car> changeUserInputToCarList(UserInput input) {
        ArrayList<Car> list = new ArrayList<>();
        String[] tmp = input.userInputCarName.split(",");
        //각 자동차 이름별로 Car클래스 리스트에 담고 초기화
        for (int i = 0; i < tmp.length; i++) {
            list.add(new Car((tmp[i]), 0));
        }
        return list;
    }

    //2) 경주할 각 자동차별 '랜덤값' 에 따라 전진-멈춤 조건 판별 기능
    public boolean judgeRunOrStop(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }

    //3) 판별 결과에 따라 현재 상태 세팅
    public void setCurrentCar(boolean flag, Car car){
        if(flag){ //전진 상태일 때만
            car.count++;//++처리
        }
        return;
    }
}