package lt.bit.oxiGym;

import java.io.*;
import java.util.ArrayList;

public class GymCustomerStatistic {

    protected ArrayList<Double> oWeightList, oHeightList, oBMIList;
    protected ArrayList<Integer> oCalorieList, oActivityList;

    public GymCustomerStatistic() {
        oWeightList = new ArrayList<>(); // Create an ArrayList object
        oHeightList = new ArrayList<>();

        oCalorieList = new ArrayList<>();
        oActivityList = new ArrayList<>();
        oBMIList = new ArrayList<>();
    }

    public void addWeight(double dWeight) {

        oWeightList.add(dWeight);
    }

    public void addHeight(double dHeight) {

        oHeightList.add(dHeight);
    }

    public void addCalories(Integer iCalories) {

        oCalorieList.add(iCalories);
    }

    public void addActivity(Integer iActivity) {

        oActivityList.add(iActivity);
    }

    public void addBMI(double dBMI) {

        oBMIList.add((dBMI));
    }

    public void outputStatistics() {
        System.out.println("BMI Calories Activity");

        for (int i = 0; i < oBMIList.size(); i++) {
            System.out.println(String.format("%.2f", oBMIList.get(i)) + " " + oCalorieList.get(i) + " "
                    + oActivityList.get(i));
        }
    }

    public void loadStatistics(String sFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sFileName));

            String sLine;
            String[] sInputs;

            while ((sLine = reader.readLine()) != null) {
                System.out.println(sLine);
                sInputs = sLine.split(" ");

                addBMI(Double.parseDouble(sInputs[0]));
                addCalories(Integer.parseInt(sInputs[1]));
                addActivity(Integer.parseInt(sInputs[2]));
            }

            reader.close();
        } catch (FileNotFoundException ex) {
            //no user - no error
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveStatistics(String sFileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sFileName));

            for (int i = 0; i < oBMIList.size(); i++) {
                writer.write(String.format("%.2f", oBMIList.get(i)) + " " + oCalorieList.get(i) + " "
                        + oActivityList.get(i));
                writer.newLine();
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
