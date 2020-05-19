import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        String[] clients_names = new String[] {"CL1","CL2","CL3"};
        String[] producers_names = new String[] {"PR1","PR2","PR3"};

        List<Thread> threads = new ArrayList<Thread>();

        for(int i=0;i<3;i++)        {
            threads.add(new Producer(producers_names[i], warehouse));
            threads.add(new Client(clients_names[i], warehouse));
        }

        for (Thread thread : threads)
            thread.start();

    }
}
