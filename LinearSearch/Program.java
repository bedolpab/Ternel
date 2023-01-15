public class Program {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 7, 11, 5, 1};
        System.out.println(Search(arr, 5));
    }

    public static boolean Search(int[] arr, int n){
        for(int i =0; i < arr.length; i++){
            if(arr[i] == n){
                return true;
            }
        }
        return false;
    }
}
