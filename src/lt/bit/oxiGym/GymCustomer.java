package lt.bit.oxiGym;

public class GymCustomer extends User {

    protected double dWeight, dHeight, dBMI;
    protected int iCalories, iActivity;
    protected GymCustomerStatistic oStatistic;

    public GymCustomer(String psFullName) {
        super(psFullName);

        this.oStatistic = new GymCustomerStatistic();

        load();
    }

    @Override
    public void load() {
        oStatistic.loadStatistics(getFullName() + ".txt");
    }

    @Override
    public void save() {
        this.oStatistic.saveStatistics(getFullName() + ".txt");
    }

    public void viewStatistics() {
        oStatistic.outputStatistics();
    }

    public void updateBMI() {
        this.dBMI = calculateBMI();

        oStatistic.addBMI(dBMI);
    }

    protected double calculateBMI() {
        double dBMI;
        double dHeightInMeters = this.getHeight() / 100;

        if (this.getWeight() == 0 || this.getHeight() == 0) // true if x or y
            return 0;

        dBMI = this.getWeight() / (Math.pow(dHeightInMeters, 2));

        //truncate to 2 decimals
        dBMI = Math.floor(dBMI * 100) / 100;

        return dBMI;
    }

    public double getWeight() {

        return dWeight;
    }

    public void setWeight(double dWeight) {
        this.dWeight = dWeight;

        oStatistic.addWeight(dWeight);
    }

    public double getHeight() {
        return dHeight;
    }

    public void setHeight(double dHeight) {
        this.dHeight = dHeight;

        oStatistic.addHeight(dHeight);
    }

    public int getCalories() {
        return iCalories;
    }

    public void setCalories(int iCalories) {
        this.iCalories = iCalories;

        oStatistic.addCalories(iCalories);
    }

    public int getActivity() {

        return iActivity;
    }

    public void setActivity(int iActivity) {
        this.iActivity = iActivity;

        oStatistic.addActivity(iActivity);
    }
}

