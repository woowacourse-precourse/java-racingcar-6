package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Racing {
    private Car[] cars;
    public Racing(){
        startRacing();
    }

    /**
     * 전제 자동차 경주를 진행한다.
     * 사용자로 부터 자동차 이름과 이동 시도횟수를 입력받는다.
     * 이동 시도횟수만큼 moveCar를 진행하고 결과를 출력한다.
     * 최종 결과를 출력한다.
     */
    private void startRacing(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        setCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int phase = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for(int i = 0; i < phase; ++i)
            moveCar();

        checkWinner();
    }

    /**
     * cars배열에 있는 Car객체들을 비교하여 가장 멀리 이동한 거리를 반환한다.
     *
     * @return dst - 가장 멀리 이동한 거리
     */
    private int winnerDistance(){
        int dst = 0;
        for(Car car : cars)
            if(car.getDistance() > dst)
                dst = car.getDistance();

        return dst;
    }

    /**
     * 최종 우승자를 찾아, 최종 우승자를 출력한다.
     */
    private void checkWinner(){
        String winner = " ";
        int winner_count = 0;
        int dst = winnerDistance();
        for(Car car : cars)
            if(winner_count == 0 && car.getDistance() == dst){
                winner = car.getCarName();
                winner_count++;
            }
            else if(car.getDistance() == dst)
                winner += ", " + car.getCarName();
        System.out.print("최종 우승자 : " + winner);
    }

    /**
     * 사용자로부터 받은 입력을 파싱하여, 자동차 객체를 생성하여
     * cars 배열에 추가한다.
     */
    private void setCarName(){
        String name = Console.readLine();
        String[] temp = name.split(",");

        cars = new Car[temp.length];

        for(int i = 0; i < temp.length; ++i){
            if(temp[i].length() > 5)
                throw new IllegalArgumentException();
            cars[i] = new Car(temp[i]);
        }

    }

    /**
     * 자동차 객체가 움직일 지 결정한다.
     */
    private void moveCar(){
        for(Car car : cars)
            car.move();
        postResult();
        System.out.println();
    }

    /**
     * 자동차의 이동거리의 결과를 출력한다.
     */
    private void postResult(){
        for(Car car : cars){
            System.out.print(car.getCarName() + " : ");
            for(int i = 0; i < car.getDistance(); ++i)
                System.out.print("-");
            System.out.println();
        }
    }
}
