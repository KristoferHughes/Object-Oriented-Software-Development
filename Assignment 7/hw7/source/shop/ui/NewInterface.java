package shop.ui;

public interface NewInterface {
    int size();
    String getHeading();
    String getPrompt(int i);
    boolean checkInput(int i, String input);
    void runAction(int i);
}
