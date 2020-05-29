package shop.main;

import shop.ui.FactoryOverride;
import shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
    Control control = new Control(Data.newInventory(), FactoryOverride.ui());
    control.run();
  }}
