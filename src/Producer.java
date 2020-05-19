import java.util.Random;


public class Producer extends Thread {

    private Warehouse warehouse = null;
    private String name = null;
    private Random generator = null;

    public Producer(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
        this. generator = new Random();
    }

    public String GetName(){
        return this.name;
    }

    @Override
    public void run()
    {
        while(true){
            boolean res = false;
            int product = generator.nextInt(5);
            int ctr = 5;
            while(!res && ctr-->0){
                try{
                    sleep((2+generator.nextInt(8)/(generator.nextInt(10)+1))*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                res = warehouse.deposit(product);
                if(res)
                    System.out.println("[P] Warehouse take product ["+warehouse.product_names[product]+"] from producer "+ name);
                else
                    System.out.println("[P] Warehouse doesn't have space to take from "+ name+ " try nr: "+ctr);
            }
        }
    }
}
