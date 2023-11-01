package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        InputCar inputcar = new InputCar();
        InputCount inputcount = new InputCount();
        Go go = new Go();

        List<String> inputCarName = inputcar.carName();
        List<Integer> inputCarPosition = inputcar.carPosition(inputCarName.size());
        Integer inputCountNum = inputcount.countNum();
        System.out.println("실행 결과");

        while(inputCountNum > 0) {
            go.Race(inputCarName, inputCarPosition);
            System.out.println("");

            inputCountNum--;

        }
        List<String> raceResult = go.Result(inputCarName, inputCarPosition);
        if (raceResult.size() > 1) {
            System.out.print("최종 우승자 : ");

            for (int i = 0; i<raceResult.size(); i++){
                System.out.print(raceResult.get(i));
                System.out.print(", ");

            }
        }else{
            System.out.print("최종 우승자 : ");
            System.out.print(raceResult.get(0));
        }

    }
}
