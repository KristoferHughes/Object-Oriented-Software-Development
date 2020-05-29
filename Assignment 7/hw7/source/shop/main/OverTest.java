package shop.main;

import shop.ui.UIFormTest;

enum OverTest {
    NUMBERTEST(new numberTest()), STRINGTEST(new stringTest()), YEARTEST(new yearTest());

    private UIFormTest newTST;

    OverTest(UIFormTest uift){
        this.newTST = uift; }

    public UIFormTest go(){
        return newTST;}

    static class yearTest implements UIFormTest{
        public boolean run(String input) {
            try {
                int i = Integer.parseInt(input);
                return i > 1800 && i < 5000;
            } catch (NumberFormatException e) {
                return false;          }} }

    static class numberTest implements UIFormTest{
        public boolean run(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;      } } }

    static class stringTest implements UIFormTest{
        public boolean run(String input) {
            return ! "".equals(input.trim());}}}
