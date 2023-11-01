package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public void start(){
        List<String> carNames = playerInput();
        Integer playtimes = inputPlayTimes();
        List<Integer> cars = race(carNames, playtimes);
        whoIsWinner(cars, carNames);

    }



    public void whoIsWinner(List<Integer> cars, List<String> carNames){
        List<String> winners = new ArrayList<>();
        for (int i=0; i< compareMax(cars).size();i++){
            winners.add(carNames.get(compareMax(cars).get(i)));
        }
        String winnersList = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersList);
    }

    public List<Integer> compareMax(List<Integer> cars){
        List<Integer> winners = new ArrayList<>();
        Integer Max = max(cars);
        for (int i=0; i<cars.size(); i++){
            if(Max.equals(cars.get(i))){
                winners.add(i);  // 자동차의 인덱스를 추가
            }
        }
        return winners;
    }

    public Integer max(List<Integer> numbers){
        int Max = 0;
        for (Integer number : numbers) {
            if (Max <= number) {
                Max = number;
            }
        }
        return Max;
    }

    public List<Integer> race(List<String> carNames, Integer playTimes){
        ArrayList cars = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        System.out.println("");
        System.out.println("실행 결과");
        for (int i=0 ; i < playTimes ; i++){
            raceEachTimes(cars);
            showRacing(cars, carNames);
        }
        return cars;
    }

    public void raceEachTimes(List<Integer> cars){
        for (int i=0 ; i < cars.size() ; i++){
            if(goForwardOrNot(creatRandomNum())){
                cars.set(i, cars.get(i) + 1);
            }
        }
    }

    public boolean goForwardOrNot(Integer number){
        return number>=4;
    }

    public Integer creatRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void showRacing(List<Integer> cars, List<String> carNames){
        for(int i=0;i<cars.size();i++){
            String dashes = "-".repeat(cars.get(i));
            System.out.println(carNames.get(i) + " : " + dashes);
        }
        System.out.println("");
    }

    public Integer inputPlayTimes(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        checkPlayTimesInput(input);

        return Integer.parseInt(input);
    }

    public void checkPlayTimesInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도할 횟수 입력이 잘못되었습니다.");
        }
    }

    public List<String> playerInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> players = List.of(input.split(","));
        checkPlayersName(players);


        return players;
    }

    public void checkPlayersName(List<String> inputs){
        for (String name : inputs) {
            checkNameLength(name);
        }
    }

    public void checkNameLength(String name){
        if (name.length()>5){
            throw new IllegalArgumentException("입력 값이 5자를 초과합니다.");
        }
    }
}
