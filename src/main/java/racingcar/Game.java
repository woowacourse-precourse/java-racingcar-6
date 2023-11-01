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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carNames = carInput.split(",");

        // 최소 자동차 2대 에러처리
        if (carNames.length<1){
            throw new IllegalArgumentException("자동차가 필요합니다.");
        }
        for(String name : carNames){
            Car car = new Car(name.trim());
            CarList.add(car);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        String moveInput = Console.readLine();

        // 숫자 에러 처리
        try {
            this.totalMove = Integer.parseInt(moveInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }

        if (totalMove <= 0) {
            throw new IllegalArgumentException("양수의 횟수를 입력하세요.");
        }
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i < totalMove; i++){
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

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }
        System.out.println();
    }

}
