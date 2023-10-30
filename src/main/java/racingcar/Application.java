package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    static String[] carNames;
    static Long raceTime;
    // 자동차 마다 현 위치를 저장하기 위해 map을 활용하였습니다. racTime 이 Long 이기 때문에 value type 은 Long 입니다.
    static Map<String, Long> carRace = new HashMap<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputCarName();
        inputRaceTime();

        playGame();
        printWinner();
    }

    public static void inputCarName() {
        String input = Console.readLine();
        carNames = parseCarName(input);

        for (String carName : carNames) {
            carRace.put(carName, 0L);
        }

    }
    public static String[] parseCarName(String input) {

        String[] names = input.split(",");

        for (String name : names) {
            validateCarName(name);
        }
        return names;
    }

    public static void validateCarName(String name) {
        isBelowFiveWord(name);
    }

    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("자동차의 이름이 5글자 이상입니다.");
        }
    }

    public static void inputRaceTime() {
        String input = Console.readLine();

        try{
            raceTime = Long.parseLong(input);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 횟수 입력입니다.");
        }
    }

    public static void playGame(){
        for(int i = 0; i < raceTime; i++){
            moveCar();
            printCarMap();
        }
    }

    public static void printCarMap(){
        for (String carName : carRace.keySet()) {
            Long position = carRace.get(carName);
            String carPosition = getPosition(position);
            System.out.printf(carName + " : " + carPosition + "\n");
        }
    }

    public static String getPosition(Long position){
        StringBuilder carPosition = new StringBuilder();
        for(int i = 0; i < position; i++){
            carPosition.append("-");
        }
        return carPosition.toString();
    }

    public static void moveCar(){
        for (String carName : carRace.keySet()) {
            Long carPosition = carRace.get(carName);

            if(isStraight()){
                carRace.replace(carName, ++carPosition);
            }
        }
    }

    public static boolean isStraight(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }

    public static void printWinner(){
        System.out.println("최종 우승자 : " + getWinner());
    }

    static String getWinner(){
        List<String> winners = new ArrayList<>();
        Long maxPosition = Collections.max(carRace.values());

        for( String carName : carRace.keySet()){
            Long carPosition = carRace.get(carName);
            if(carPosition.equals(maxPosition)){
                winners.add(carName);
            }
        }

        return getStringFormat(winners);
    }

    static String getStringFormat(List<String> input){
        StringBuilder result = new StringBuilder();

        if(input.size() == 1) return input.get(0);

        for(String item : input){
            result.append(item).append(",");
        }

        return result.toString();
    }

}
