package transport;

public class DamagedRover extends MarsRover {

    private final static int MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY = 10000;
    private final static int METERS_FROM_START_TO__CLIFF = 1000;

    private final static int N_SIUMULATIONS = 500;

    private double      position;           // Distance from start. Range is
                                            // -1000 to +1000. If Rover travels
                                            // beyond this range, it falls off
                                            // a cliff.
    private double      metersTraveled;     // Total meters traveled // back and forth.
    private boolean     fell;               // If true, an expensive loss.


    //
    // Simulates travel under damage conditions. In each turn, travels forward or
    // backward either 1, 2, 3, or 4 meters. Continues until there's no more power
    // in the battery, or we fall off a cliff. Cliffs are at position = 1000 or
    // position = -1000.
    //
    public void simulateStormDamageTravel(){
        // Reset instance variables here
        position = 0;                             //!!!
        metersTraveled = 0;                       //!!!
        fell = false;                             //!!!

        while (metersTraveled < MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY)    {
            // Random int: 1, 2, 3, or 4. Represents the
            // travel distance (maybe forward, maybe back) this turn
            double distanceNextTurn = (int)(1 + 4*Math.random());
            // Random boolean for direction of travel this turn.
            boolean forwardNotBack = (Math.random() > 0.5);
            // Adjust position and metersTraveled.
            if (forwardNotBack)
                position = position + distanceNextTurn;
            else
                position = position - distanceNextTurn;
            metersTraveled = metersTraveled + distanceNextTurn;
            // Check for falling off cliff. If Rover fell, set fell to true and
            // terminate (break out of) the loop.
            if (position > METERS_FROM_START_TO__CLIFF || position < ~METERS_FROM_START_TO__CLIFF)      {
                fell = true;
            //      TERMINATE THE LOOP;
            }
        }
    }

    public double zgetMetersTraveled(){
        return metersTraveled;
    }

    public boolean getFell(){
        return fell;
    }

    public static void main(String[] args){
        DamagedRover dr = new DamagedRover();
        int numTimesFell = 0;

        for(int i=0; i < dr.N_SIUMULATIONS; i++) {
            dr.simulateStormDamageTravel();
            if(dr.fell){
                numTimesFell++;
                System.out.println("Fell");
                System.out.println("Meters traveled: " + dr.metersTraveled);
            }else {
                System.out.println("No more power");
            }
        }
        System.out.println("Number times the rover fell: " + numTimesFell);
    }
}
