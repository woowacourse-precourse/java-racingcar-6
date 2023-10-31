package racingcar.domain;

import java.util.List;

public class Output {

    public void InputCarDes() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void InputGameNumDes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void CarsResult(List<Car> cars, List<Car> winner) {
        System.out.println("실행 결과");
        for (Car c : cars) {
            CarResult(c);
        }

        WinnerResult(winner);
    }

    private void CarResult(Car car) {
        System.out.print(car.name + " : ");
        for (int i = 0; i < car.cnt; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void WinnerResult(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        String result = "";

        for (Car c : cars) {
            result += c.name;
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);

        System.out.println(result);
    }

}
