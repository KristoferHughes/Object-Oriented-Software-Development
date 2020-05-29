package shop.ui;


final public class FactoryOverride {
    public MegaUI launch(String i, String head, UIFormMenu.Pair[] t){
        switch(i){
            case MegaUI.popup:
                return new PopupUI();

            case MegaUI.textui:
                return new TextUI();

            case MegaUI.UIFormBuilder:
                return new UIFormBuilder();

            case MegaUI.UIFormMenu:
                return new UIFormMenu(head, t);

            case MegaUI.UIMenuBuilder:
                return new UIMenuBuilder();

            default:
                return null;    }}

    static private UI UIRes = new PopupUI();
    static public UI ui () {
        return UIRes; }}
