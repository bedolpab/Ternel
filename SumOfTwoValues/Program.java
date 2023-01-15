import java.util.Hashtable;

public class Program {
    public static void main(String[] args) {
        int[] numbers = { 3, 4, 5, 4, 1, -2, 5 };
        System.out.println(SumExists(numbers, 5)); //
    }

    public static boolean SumExists(int[] array, int value){
        Hashtable values = new Hashtable();
        for(int i =0; i < array.length; i++){
            values.put(i, array[i]);
            if(values.containsValue(value-array[i])){
                return true;
            }
        }
        return false;
    }
}
