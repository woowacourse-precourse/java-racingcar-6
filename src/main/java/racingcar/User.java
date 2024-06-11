package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    // 사용자에게 입력받기
    public void showMain() {
        String[] car = getCar();
        int game = getGame();
        String[] drive = playGame(car);

        // 게임진행
        Driving drving = new Driving();
        drving.showResult(car, drive, game);
    }

    // 경주할 자동차 이름 , 기준으로 입력받기
    private String[] getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        String[] car = null;

        try {
            name = br.readLine();
            car = name.split(",", 5);
            check(car);
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return car;

    }

    // car 이름 5자인지 확인하기
    private void check(String[] car) throws IllegalAccessException {
        for (String s : car) {
            if (s.length() > 5) {
                throw new IllegalAccessException(s+" 잘못된 값 입력");
            }
        }
    }

    // 게임 횟수 입력받기
    private int getGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        int game = 0;
        try {
            game = Integer.parseInt(br2.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return game;
    }

    // 차의 주행 정보를 저장할 배열, ""으로 초기화
    private String[] playGame(String[] car) {
        String drive[] = new String[car.length];
        for (int i = 0; i < drive.length; i++) {
            drive[i] = "";
        }

        return drive;
    }
}
