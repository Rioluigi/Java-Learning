/*
Nama  : Rio Luigi Del Niery
NIM   : 20220040120
Kelas : TI22J
*/

public class LinearSearchNumber {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Mengembalikan indeks elemen yang ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika elemen tidak ditemukan
    }

    public static void main(String[] args) {
        int[] numbers = {1102021, 1102022, 1102023, 1102024, 1102025, 1102026};
        int target = 1102024;
        int result = linearSearch(numbers, target);
        if (result != -1) {
            System.out.println("Data ditemukan pada indeks: " + result);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }
}
