package racingcar.view;

public class View {
    private String viewContent;

    public View(String viewContent) {
        this.viewContent = viewContent;
    }

    public void print() {
        System.out.println(viewContent);
    }
}
