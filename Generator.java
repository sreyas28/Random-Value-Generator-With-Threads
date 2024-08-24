import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {

    public static void main(String[] args) {
        // it will Create X4 of the range
        int range = 75000;


        //first_Half and Second HAlf
        First_Half first_half = new First_Half(range);
        Second_Half second_half = new Second_Half(range,range*2);
        Third_Half third_half = new Third_Half(range*2, range*3);
        Fourth_Half fourth_half = new Fourth_Half(range*3, range*4);

        //Creating thread so that they can run
        Thread thread_1 = new Thread(first_half);
        Thread thread_2 = new Thread(second_half);
        Thread thread_3 = new Thread(third_half);
        Thread thread_4 = new Thread(fourth_half);


        // Runing a thread
        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();

        // waiting Threads to complete
        try {
            thread_1.join();
            thread_2.join();
            thread_3.join();
            thread_4.join();

        } catch (InterruptedException e) { e.printStackTrace();}

        File_Create(range,first_half.get_Array(),second_half.get_Array(),third_half.get_Array(),fourth_half.get_Array());

        System.out.println("Process is Completed and numbers are saved in 'Unique_Number.txt'");

    }

    static void File_Create(int range, ArrayList<Integer> Array_1, ArrayList<Integer> Array_2, ArrayList<Integer> Array_3, ArrayList<Integer> Array_4){
        try {
            FileWriter file = new FileWriter("Unique_Number.txt");

            for(int i=0; i < range; i++){
                file.append(Integer.toString(Array_1.get(i)) + "\n");
                file.append(Integer.toString(Array_2.get(i)) + "\n");
                file.append(Integer.toString(Array_3.get(i)) + "\n");
                file.append(Integer.toString(Array_4.get(i)) + "\n");
            }

            file.close();
            
        } catch (IOException e) { e.printStackTrace();}

    }
}