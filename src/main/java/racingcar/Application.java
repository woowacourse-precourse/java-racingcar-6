package racingcar;

public class Application {

    private final UserBehavior user;
    private final RacingBehavior racing;

    public Application(UserBehavior user, RacingBehavior racing) {
        this.user = user;
        this.racing = racing;
    }

    public static void main(String[] args) {
        try {
            User user = new User();
            Racing racing = new Racing(user);
            Application app = new Application(user, racing);

            app.user.input();
            app.racing.race();
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e);
        }
    }

}