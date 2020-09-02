import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        // Mencari distinct pair dari input berupa list number dan target

        // Input list number
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(6,6,3,9,9,3,5,1));
        // Input target
        int target = 12;

        // Variabel menampung jumlah distinct pair
        int sum = 0;

        // Variabel menampung pair number
        ArrayList<ArrayList<Integer>> pairNumber = new ArrayList<>();


        // Looping untuk mencari pair number yang hasil jumlah sesuai target
        for (int i = 0 ; i < number.size() ; i ++){
            // Loop di dalam loop untuk bisa menjumlahkan elemen satu dengan element berikutnya
            for (int j = i + 1 ; j < number.size() ; j++){
                // Kondisi jika hasil jumlah kedua element sesuai target
                if (number.get(i) + number.get(j) == target){
                    // Variabel menampung element yang jumlahnya sesuai target
                    ArrayList<Integer> addList = new ArrayList<>();
                    addList.add(number.get(i));
                    addList.add(number.get(j));
                    // Memasukan variabel ke variabel pairNumber
                    pairNumber.add(addList);
                }
            }
        }

        // Menampilkan pairNumber yang hasil jumlahnya sesuai target
        System.out.println("Pair Number yang jumlahnya sesuai target :");
        System.out.println(pairNumber);
        System.out.println(pairNumber.size());
        System.out.println("-------------");

        // Filter untuk menghilangkan duplikasi element atau element yang sama
        LinkedHashSet<ArrayList<Integer>> filter = new LinkedHashSet<>(pairNumber);
        ArrayList<ArrayList<Integer>> filterArray = new ArrayList<>(filter);

        // Menampilkan hasil setelah duplikat dihilangkan
        System.out.println("Pair Number setelah filter duplikasi :");
        System.out.println(filterArray);
        System.out.println(filterArray.size());
        System.out.println("-------------");


        // Filter untuk menghilangkan element pairNumber yang merupakan invert dari element lainnya
        for (int i = 0 ; i < filterArray.size() ; i ++){
            ArrayList<Integer> invert = new ArrayList<>(filterArray.get(i));
            Collections.reverse(invert);
            for (int j = i + 1 ; j < filterArray.size() ; j ++){
                if (invert.equals(filterArray.get(j))){
                    filterArray.remove(j);
                }
            }
        }

        // Menentukan jumlah akhir distinct pair
        sum = filterArray.size();
        // Menampilkan hasil akhir distinct pair dan jumlahnya
        System.out.println("Distinct Pair: "+filterArray);
        System.out.println("Jumlah Distinct Pair: "+sum);

    }

}
