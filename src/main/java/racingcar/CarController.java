package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CarController {
    List<Car> carList;
    CarView carView;

    //start() 함수 구현
    public void start() {
        carList = new ArrayList<>();
        carView = new CarView();

        //경주할 자동차 이름을 입력하세요.(View)
        carView.printInputCarNames();

        //값 받기
        StringTokenizer st = new StringTokenizer(Console.readLine(),",");
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken()));
        }
        validateInput();

        //시도할 횟수를 입력하세요.(View)
        carView.printInputHowManyRound();

        //값 받기
        int roundNumber = Integer.parseInt(Console.readLine());

        //roundNumber동안, 실행결과 출력
        //  1. carList의 개수만큼,  Moving실행
        //  2. carList -> carDtoList로 변경
        //  3. carDtoList를 통해 printResult
        System.out.println("실행 결과");
        for (int i=0; i<roundNumber; i++) {
            carListMoving(carList);
            List<CarDto> carDtoList = convertCarToCarDto(carList);
            carView.printResult(carDtoList);
        }

        List<CarDto> carDtoList = convertCarToCarDto(carList);
        carView.printWinner(carDtoList);
    }

    private List<CarDto> convertCarToCarDto(List<Car> carList) {
        List<CarDto> carDtoList = new ArrayList<>();
        for (int i=0; i<carList.size(); i++) {
            Car car = carList.get(i);
            String carName = car.getCarName();
            int movedDistance = car.getMovedDistance();

            carDtoList.add(new CarDto(carName, movedDistance));
        }

        return carDtoList;
    }

    private void carListMoving(List<Car> carList) {
        for (int i=0; i<carList.size(); i++) {
            Car car = carList.get(i);
            car.isMoving();
        }
    }

    //사용자로부터 입력된 값의 유효성 검증
    private void validateInput() {
        if (carList.size() == 1) {
            throw new IllegalArgumentException();
        }

        Set<String> carNameSet = new HashSet<>();

        //넣어진 인스턴스 값을 바탕으로 하면 되겠네!
        for (int i = 0; i < carList.size(); i++) {
            Car carInList = carList.get(i);
            String carNameInList = carInList.getCarName();

            if (carNameInList.length() > 5) {
                throw new IllegalArgumentException();
            }

            carNameSet.add(carNameInList);
        }

        if (carNameSet.size() != carList.size()) {
            throw new IllegalArgumentException();
        }

    }
}


