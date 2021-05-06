package pl.pjatk.core;

public class MySimplePojo {

    public int liczba= 3;
    public String cos="Whatever";

    public MySimplePojo(int liczba, String cos) {
        this.liczba = liczba;
        this.cos = cos;
    }

    public int getLiczba() {
        return liczba;
    }

    public String getCos() {
        return cos;
    }
    public void soutSomething(){
        System.out.println("something");

    }
}
