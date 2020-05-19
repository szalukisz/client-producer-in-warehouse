public class Warehouse {
    public static final int CAPACITY = 24;
    private int counter = 0;

    public String[] product_names = null;
    private Integer[] occupancy = null;

    public Warehouse()
    {
        this.occupancy = new Integer[] {0,0,0,0,0};
        this.product_names = new String[] {"A","B","C","D","E"};
    }
    public void occupancyStatus(){
        StringBuilder out= new StringBuilder("      Actual occupancy: ");
        for(int i = 0; i <occupancy.length;i++){
            out.append("[").append(product_names[i]).append("] : ").append(occupancy[i]).append(" | ");
        }
        System.out.println(out);
    }

    public synchronized boolean deposit(int product_id){
        if(counter < CAPACITY){

            occupancy[product_id]++;
            counter++;

            this.occupancyStatus();
            return true;
        }
        return false;
    }

    public synchronized boolean take(int product_id){
        if(occupancy[product_id]>0){

            occupancy[product_id]--;
            counter--;

            this.occupancyStatus();
            return true;
        }
        return false;
    }


}
