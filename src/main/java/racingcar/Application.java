/**
 * @Package_name   : racingCar
 * @Class_name : Application
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package racingcar;

public class Application {
    /**
     * Description : 자동차 경주 main 메소드
     *
     * @Method : main()
     */
    public static void main(String[] args) {
        CarRace carRaceGame = new CarRace();
        carRaceGame.carRacing();
    }
}
