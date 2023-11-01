package racingcar;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model(view.getNames(), view.times());
        Controller control = new Controller(model, view);
        control.Grandprix();
        view.printFinalResult(model.raceCars,model.raceCars.length);
    }
}
