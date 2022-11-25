import java.util.ArrayList;
import java.util.List;

public class OddEvenFinder implements Runnable{
    private List<Integer> inputList = new ArrayList<>();
    private static final List<Integer> oddList = new ArrayList<>();
    private static final List<Integer> evenList = new ArrayList<>();
    public OddEvenFinder(List<Integer> list) {
        this.inputList = list;
    }

    @Override
    public void run() {
        oddEvenFinder();
    }
    public void oddEvenFinder(){
        for (Integer element:inputList) {
            if (element%2 == 0) {
                evenList.add(element);
            }else {
                oddList.add(element);
            }
        }
    }
    public static List<Integer> oddNumbers(){
        return oddList;
    }
    public static List<Integer> evenNumbers(){
        return evenList;
    }
    public static void getListSize(){
        System.out.println("Even numbers size: " + evenList.size());
        System.out.println("Odd numbers size: " + oddList.size());
    }

}
