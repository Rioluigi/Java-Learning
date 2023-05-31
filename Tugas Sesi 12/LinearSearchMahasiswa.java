/*
Nama  : Rio Luigi Del Niery
NIM   : 20220040120
Kelas : TI22J
*/

public class LinearSearchMahasiswa {
    public static void linearSearch(String[] names, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println((i + 1) + ". " + names[i] + " - " + "NIM: " + names[i - 1] + " - " + "Alamat: " + names[i + 1]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Data yang Anda cari tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        String[] data = {"1102021", "Andri Hariadi", "BANDUNG", "1102022", "Dewi Lestari", "SURABAYA", "1102023", "Dewi Agustin", "MALANG", "1102024", "Reni Indrayanti", "MALANG", "1102025", "Toni Sukmawan", "SURABAYA", "1102026", "Toni Gunawan", "BANDUNG"};
        String target = "Toni";
        linearSearch(data, target);
    }
}
