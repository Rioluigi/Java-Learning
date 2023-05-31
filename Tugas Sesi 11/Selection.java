\\
Nama  : Rio Luigi Del Niery
NIM   : 20220040120
Kelas : TI22J
\\
import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr_nilai1 = {18, 6, 11, 14, 10, 4, 15, 20};
        int[] arr_nilai2 = {66, 70, 40, 21, 55, 100, 50};

        goSort(arr_nilai1, "ASC"); // Mengurutkan arr_nilai1 secara ascending (terkecil ke terbesar)
        goSort(arr_nilai1, "DESC"); // Mengurutkan arr_nilai1 secara descending (terbesar ke terkecil)

        goSort(arr_nilai2, "ASC"); // Mengurutkan arr_nilai2 secara ascending (terkecil ke terbesar)
        goSort(arr_nilai2, "DESC"); // Mengurutkan arr_nilai2 secara descending (terbesar ke terkecil)
    }

    static void goSort(int[] data_arr, String optionSort) {
        int[] arr = data_arr.clone();
        int minOrMax = arr[0];
        int index = 0;
        int prosesSwap = 0;

        long startTime = System.nanoTime();
        if (optionSort.equals("ASC")) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                        index = j;
                    }
                }
                if (arr[i] > min) {
                    arr[index] = arr[i];
                    arr[i] = min;
                    prosesSwap++;
                }
            }
        } else if (optionSort.equals("DESC")) {
            for (int i = 0; i < arr.length - 1; i++) {
                int max = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                        index = j;
                    }
                }
                if (arr[i] < max) {
                    arr[index] = arr[i];
                    arr[i] = max;
                    prosesSwap++;
                }
            }
        } else {
            System.out.println("Invalid sort option!");
        }
        long endTime = System.nanoTime();
        System.out.println("Hasil Array " + Arrays.toString(arr));
        System.out.println("Proses Swap yang Dilakukan: " + prosesSwap);
        System.out.println("Waktu Eksekusi: " + (endTime - startTime) / 1000000.0 + " milliseconds\n");
    }
}