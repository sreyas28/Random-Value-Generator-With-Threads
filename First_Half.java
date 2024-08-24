import java.util.ArrayList;
import java.util.Random;

public class First_Half implements Runnable{

    private volatile ArrayList<Integer> Array = new ArrayList<>();
    private int range;

    First_Half(int range){
        this.range = range;
    }

    @Override
    public void run() {
        Random value = new Random();
        int Count = 0;

        while( Count < range ){
            int temp = value.nextInt(range);
            if(is_Unique(Array, Count, temp)){
                Array.add(temp);
                Count++;
            }
        }
        System.out.println("Thread 1 Complete");
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
