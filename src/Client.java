import java.util.Random;


public class Client extends Thread {

    private Warehouse warehouse = null;
    private String name = null;
    private Random generator = null;

    public Client(String name,Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
        this. generator = new Random();
    }


    @Override
    public void run()    {
        while(true){
            boolean res = false;
            int product = generator.nextInt(5);
            int ctr = 5;
            while(!res && ctr-->0){
                try{
                    sleep((3+generator.nextInt(10)/(generator.nextInt(10)+1))*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                res = warehouse.take(product);
                if(res)
                    System.out.println("[C] Warehouse give out product ["+warehouse.product_names[product]+"] to client "+ name);
                else
                    System.out.println("[C] Warehouse doesn't have required product ["+warehouse.product_names[product]+"]  for client "+ name+ ", try nr: "+ctr);
            }
        }

    }
}

