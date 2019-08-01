package lt.bit.oxiGym;

public abstract class User {
    protected String sFullName;

    public User (String psFullName) {

        this.sFullName = psFullName;
    }

    public abstract void load();
    public abstract void save();

    public String getFullName(){

        return sFullName;
    }
}
