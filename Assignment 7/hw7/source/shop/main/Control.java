package shop.main;
//REFACTORED version, Kristofer Hughes
import shop.ui.*;
import shop.data.Inventory;
import shop.main.ChangeEnums.INIT;

final class Control{
  StatesEnum states;
  OverTest UIFormTests;
  private NewInterface[] newMen;
  private int newState;
  private NewInterface formControl;
  private UIFormTest testInts, testStrings;
  private Inventory _inventory;
  private UI _ui;
  private INIT uiAct;
  private static FactoryOverride SuperUI = new FactoryOverride();


  Control(Inventory inventory, UI ui) {
    _inventory = inventory;
    _ui = ui;

    newMen = new NewInterface[states.NUMSTATES.get()];
    newState = states.START.get();
    addSTART(states.START.get());
    addEXIT(states.EXIT.get());
    UIFormTest yearTest = UIFormTests.YEARTEST.go();
    testInts = UIFormTests.NUMBERTEST.go();
    testStrings = UIFormTests.STRINGTEST.go();
    FormBuilder f = (FormBuilder)SuperUI.launch("UIFB",null,null); //new UIFormBuilder();
    f.add("Title", testStrings);
    f.add("Year", yearTest);
    f.add("Director", testStrings);
    formControl =  f.toUIForm("Enter Video");
    uiAct = new INIT(_ui, _inventory, formControl, testInts);
  }
  
  void run() {
    try {
      while (newState != states.EXITED.get()) {
        _ui.processMenu(newMen[newState]);
      }
    } catch (UIError e) {
      _ui.displayError("UI closed");
    }
  }
  
  private void addSTART(int stateNum) {
    MenuBuilder m = (MenuBuilder)SuperUI.launch("UIMB",null,null); //new UIMenuBuilder();
    
    m.add("Default",ChangeEnums.DEFAULT.run());
    m.add("Add/Remove copies of a video", ChangeEnums.ADD_REMOVE.run());
    m.add("Check in a video", ChangeEnums.CHECKIN.run());
    m.add("Check out a video",ChangeEnums.CHECKOUT.run());
    m.add("Print the inventory",ChangeEnums.PRINT.run());
    m.add("Clear the inventory", ChangeEnums.CLEAR.run());
    m.add("Undo", ChangeEnums.UNDO.run());
    m.add("Redo",ChangeEnums.REDO.run());
    m.add("Print top ten all time rentals in order", ChangeEnums.TOP10.run());
    m.add("Initialize with bogus contents", ChangeEnums.INIT.run());
    m.add("Exit", new UIMenuAction() {
      public void run() {
        newState = states.EXIT.get();
      }});
    
    newMen[stateNum] = m.toUIMenu("Bob's Video");
  }
  private void addEXIT(int stateNum) {
    MenuBuilder m = (MenuBuilder)SuperUI.launch("UIMB",null,null); //new UIMenuBuilder();

    m.add("Default", ChangeEnums.DEFAULT.run());
    m.add("Yes",
      new UIMenuAction() {
        public void run() { newState = states.EXITED.get(); }
      });
    m.add("No",
      new UIMenuAction() {
        public void run() {
          newState = states.START.get();
        }
      });
    
    newMen[stateNum] = m.toUIMenu("Are you sure you want to exit?");
  }
}
