package racingcar.domain;

import java.util.List;

public class Play {
    public void playGame(Cars cars, int playCount){
        Generator generator = new Generator();
        Judgment judgment = new Judgment();
        while (playCount > 0){
            playCount--;

            for (Car c: cars.getCars()){
                String len = "";
                int randomNum = generator.generateRandomNum();
                if (judgment.isGo(randomNum)){
                    c.distance += randomNum;
                }
                for (int i = 0; i<randomNum; i++){
                    len += "-";
                }


                System.out.println(c.name+" : "+len);

            }
            System.out.println();


        }
    }
}
