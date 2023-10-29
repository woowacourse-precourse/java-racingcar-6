package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void Game_생성(){
        String[] cars = {"hans", "jins"};
        Game gm = new Game(cars, 1);
        for (int i=0; i<cars.length; i++){
            System.out.println(i+"번 자동차의 이름 : "+gm.players[i].name);
            System.out.println(i+"번 자동차의 위치 : "+gm.players[i].location);
        }
        System.out.println("playNum : "+gm.playNum);
    }

    @Test
    public void Game_play의_테스트(){
        String[] cars = {"hans", "jins"};
        Game gm = new Game(cars, 1);
        gm.play();

        for (int i=0; i<cars.length; i++){
            System.out.println(i+"번 자동차의 이름 : "+gm.players[i].name);
            System.out.println(i+"번 자동차의 위치 : "+gm.players[i].location);
        }
    }
}