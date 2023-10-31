package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        List<Car> carList = parseInputName(inputName);

        int n = Integer.parseInt(Console.readLine());

        while(n != 0){
            int[] forwardNum = carForward(carList.size());

            for(int i=0; i<carList.size(); i++){
                if(forwardNum[i] > 0){
                    carList.get(i).setForward(carList.get(i).getForward()+1);
                }
            }

            printResultByOrder(carList);

            n--;
        }

        System.out.print("최종 우승자 : ");
        List<String> winner = findWinner(carList);
        printWinner(winner);

    }

    public static List<Car> parseInputName(String inputName) {
        List<Car> carList = new ArrayList<>();
        String arrName[] = inputName.split(",");

        for(String name : arrName){
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
            carList.add(car);
        }

        return carList;
    }

    public static int[] carForward(int carLength) {
        int[] forwardNum = new int[carLength];

        for(int i=0; i<carLength; i++){
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >= 4){
                forwardNum[i]++;
            }
        }

        return forwardNum;
    }

    public static void printResultByOrder(List<Car> carList){
        for(int i=0; i<carList.size(); i++){
            System.out.print(carList.get(i).getName()+" : ");
            for(int j=0; j<carList.get(i).getForward(); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static List<String> findWinner(List<Car> carList){
        int maxForward = -10000;
        for(int i=0; i<carList.size(); i++){
            if(carList.get(i).getForward() > maxForward){
                maxForward = carList.get(i).getForward();
            }
        }

        List<String> winner = new ArrayList<>();
        for(int i=0; i<carList.size(); i++){
            if(carList.get(i).getForward() == maxForward){
                winner.add(carList.get(i).getName());
            }
        }

        return winner;
    }

    public static void printWinner(List<String> winner){
        for(int i=0; i<winner.size(); i++){
            System.out.print(winner.get(i));
            if(i < winner.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
