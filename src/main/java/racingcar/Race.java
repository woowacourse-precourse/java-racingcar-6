package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Race {
    private Map<String, Integer> cars;
    private List<String> names;
    private int count;

    private void mapCarNames(){
        cars = new HashMap<>();
        for(String name: names){
            cars.put(name, 0);
        }
    }

    private void getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        names = List.of(input.split(","));
        mapCarNames();
    }

    private void getNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        count = Integer.parseInt(Console.readLine());
    }

    private List<String> getWinner(){
        List<String> winners = new ArrayList<>();
        List<String> scores = new ArrayList<>(cars.keySet());
        scores.sort((o1, o2)-> cars.get(o2).compareTo(cars.get(o1)));
        int maxRun = cars.get(scores.get(0));

        for(int i=0;i<cars.size()-1;i++){
            if(cars.get(scores.get(i)) == maxRun){
                winners.add(scores.get(i));
            }
        }
        return winners;
    }
    private void showResults(){
        List<String> winners = getWinner();
        System.out.print("최종 우승자 : ");
        for(String winner: winners){
            System.out.print(winner+" ");
        }

    }
    public void start(){
        getCarNames();

        getNumberOfAttempts();

        Car car = new Car();
        car.run(count, names, cars);

        showResults();
   }
}
