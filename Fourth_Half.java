import java.util.ArrayList;
import java.util.Random;

public class Fourth_Half implements Runnable{
    ArrayList<Integer> Array = new ArrayList<>();
    int range, bound;

    Fourth_Half(int range, int bound){
        this.range = range;
        this.bound = bound;
    }

    @Override
    public void run() {
        Random value = new Random();
        int Count = 0;

        while( Count < range/3 ){
            int temp = value.nextInt(range,bound);
            if(is_Unique(Array, Count, temp)){
                Array.add(temp);
                Count++;
            }
        }
        System.out.println("Thread 4 Complete");
    }

    boolean is_Unique(ArrayList<Integer> Array, int Size, int val){

        for(int i=0; i<Size; i++){
            if(Array.get(i) == val ){
                return false;
            }
        }


        return true;
    }

    public ArrayList<Integer> get_Array(){
        return Array;
    }
}
