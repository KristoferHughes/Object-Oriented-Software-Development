package shop.ui;

public interface UI {
  public void processMenu(NewInterface menu);
  public String[] processForm(NewInterface form);
  public void displayMessage(String message);
  public void displayError(String message);
}
