package sample;

public class Users {
    private String name;
    private String sername;
    private int number;

    Users()
    {
        name = "Pasha";
        sername = "Kosinskiy";
        number = 1792;
    }

    @Override
    public String toString() {
        return name+" "+sername+" "+number;
    }
}
