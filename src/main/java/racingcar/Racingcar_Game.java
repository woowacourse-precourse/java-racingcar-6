package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racingcar_Game {
    public static List<String> userInput(){
        List<String> carName = new ArrayList<>();

        String input=readLine();
        String name="";

        for(int i =0;i<input.length();i++){
            if(input.charAt(i)==','){
                if(checkNameLength(name)){
                    carName.add(name);
                    name="";
                }
            }
            else name+=input.charAt(i);
        }
        carName.add(name);
        return carName;
    }

    public static boolean checkNameLength(String name){
        if(name.length() > 5)
            throw new IllegalArgumentException("Name is too long");
        return true;
    }

    public static boolean checkPush(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public static void playGame(List<String> carName) {
        System.out.print("시도할 회수는 몇회인가요?");
        int gameCnt = Integer.parseInt(readLine());

        List<String> gameList = new ArrayList<>();
        for (int i = 0; i < carName.size(); i++) {
            gameList.add("");
        }

        for (int i = 0; i < gameCnt; i++) {
            for (int j = 0; j < carName.size(); j++) {
                if (checkPush()) {
                    String car = gameList.get(j);
                    car += ('-');
                    gameList.set(j, car);
                }
            }
            printProgress(carName,gameList);
        }
    }

    public static void printProgress(List<String> carName,List<String> gameList){
        for(int i=0;i<carName.size();i++){
            System.out.println(carName.get(i)+" : "+gameList.get(i));
        }
        System.out.println();
    }
}
