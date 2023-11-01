package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int totalMove;
    List<Car> CarList;
    public Game(){
        this.totalMove = 0;
        this.CarList = new ArrayList<>();
    }

    void Start(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carInput = Console.readLine();
        String[] carNames = carInput.split(",");
        for(String name : carNames){
            Car car = new Car(name.trim());
            CarList.add(car);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        this.totalMove = Integer.parseInt(Console.readLine());
        for(int i = 0; i < totalMove; i++){
            System.out.println("실행 결과");
            Match();
            System.out.println();
        }
    }
    // 경기 함수
    void Match(){
        for (Car car : CarList){
            int randomNumber = car.pickNumber();
            if(randomNumber >= 4){
                car.move();
            }
            System.out.println(car.howFar());
        }
    }
    void Winner() {
        int maxMoveCnt = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : CarList) {
            maxMoveCnt = Math.max(maxMoveCnt, car.moveCnt);
        }

        for (Car car : CarList) {
            if (car.moveCnt == maxMoveCnt) {
                winners.add(car.name);
            }
        }

        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }

}
