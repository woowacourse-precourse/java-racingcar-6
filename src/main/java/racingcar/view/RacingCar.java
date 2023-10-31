package racingcar.view;

import racingcar.controller.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RacingCar {

    public void gameStart(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String tk = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(tk);
            System.out.println("gameStart");
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
        }

    };
}
