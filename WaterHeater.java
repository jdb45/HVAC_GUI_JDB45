import java.util.Date;

public class WaterHeater extends ServiceCall{

    //creating static variables
    public static int waterHeaterAge;
    public static String serviceRequest;
    //giving CITY_FEE a final value becasue that value wont change
    protected static final double CITY_FEE = 20;


    //creating a constructor
    public WaterHeater(String serviceAddress, String serviceRequest, String problemDescription, Date date, int waterHeaterAge)  {
        super(serviceAddress, problemDescription, date);
    }

    @Override
    //creating a method toString to convert, and print the values of the water heater class
    public String toString() {


        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        double totalDue = fee + CITY_FEE;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(totalDue);



        return  "Water Heater Service Call " + "\n" +
                "Service Address = " + serviceAddress + "\n" +
                "Service Requested = " + serviceRequest + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Water Heater Age = " + waterHeaterAge + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Water Heater City Fee = " + "$" + CITY_FEE + "\n" +
                "Total Fee = " + (feeString);



    }


}
