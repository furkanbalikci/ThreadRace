import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> tenThousandList = new ArrayList<>();
        int n = 1;
        while (n < 10001){
            tenThousandList.add(n);
            n++;
        }
        ExecutorService pool= Executors.newFixedThreadPool(4);

        for(int i=0; i<4; i++){
            int x = i *2500;
            int y = x + 2500;
            System.out.println(x + " " +y);
            pool.execute(new OddEvenFinder(tenThousandList.subList(x,y)));
            Thread.sleep(1000);
        }
        pool.shutdown();
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Threads are completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Odd Numbers: " + OddEvenFinder.oddNumbers());
        System.out.println("Even Numbers: " + OddEvenFinder.evenNumbers());
        OddEvenFinder.getListSize();
    }
}