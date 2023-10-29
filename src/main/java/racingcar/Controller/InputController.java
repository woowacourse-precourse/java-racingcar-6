package racingcar.Controller;

import racingcar.CarManager;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    CarManager carManager=new CarManager();
    RaceController raceController =new RaceController();


    public void getNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            splitName(readLine());
        }catch(Exception e){
            throw new IllegalArgumentException("입력은 비어 있거나 쉼표만 포함될 수 없습니다.");
        }
    }

    private void splitName(String readLine) {
                if (readLine == null || readLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("입력은 비어 있거나 쉼표만 포함될 수 없습니다.");
                }

                String[] carNamesArray = readLine.split(",");
                if (carNamesArray.length == 0) {
                    throw new IllegalArgumentException("적어도 한 대 이상의 차량 이름을 입력해야 합니다.");
                }

                for (String carName : carNamesArray) {
                    String trimmedCarName = carName.trim();
                    if(isInvalidName(trimmedCarName)) throw new IllegalArgumentException("5자 이상의 닉네임은 입력할 수 없습니다.");
                    if (!trimmedCarName.isEmpty()) {
                        Car car = new Car(trimmedCarName);
                        carManager.addCar(car);
                    }
                }
                if (carManager.getCarCount() < 1) {
                    throw new IllegalArgumentException("적어도 한 대 이상의 유효한 차량 이름을 입력해야 합니다.");
                }
        //설정한 값을 raceController에서 쓰기 위해 carManager값을 전달해준다.
        raceController.setCarList(carManager);
    }
    public boolean isInvalidName(String nickName){
        if(nickName.length()>5) return true;
        return false;
    }


    public int getRaceTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(readLine());
        }catch(Exception e){
            throw new IllegalArgumentException("부적절한 입력입니다.");
        }
    }

}
