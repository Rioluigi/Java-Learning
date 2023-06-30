import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kamus1 {
    private static Map<String, String> englishToIndonesian = new HashMap<>();
    private static Map<String, String> indonesianToEnglish = new HashMap<>();

    public static void main(String[] args) {
        initializeDictionary();

        Scanner scanner = new Scanner(System.in);
        System.out.println("===🌏 KAMUS 🌏===");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Terjemahkan dari Bahasa Inggris ke Bahasa Indonesia");
            System.out.println("2. Terjemahkan dari Bahasa Indonesia ke Bahasa Inggris");
            System.out.println("3. Keluar");
            System.out.print("Opsi: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    translateEnglishToIndonesian(scanner);
                    break;
                case 2:
                    translateIndonesianToEnglish(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan kamus.");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
        }
    }

    private static void translateEnglishToIndonesian(Scanner scanner) {
        System.out.print("Masukkan kata dalam Bahasa Inggris: ");
        String word = scanner.next().toLowerCase();
        String translation = englishToIndonesian.get(word);
        if (translation != null) {
            System.out.println("Artinya dalam Bahasa Indonesia: " + translation);
        } else {
            System.out.println("Kata tidak ditemukan dalam kamus.");
        }
    }

    private static void translateIndonesianToEnglish(Scanner scanner) {
        System.out.print("Masukkan kata dalam Bahasa Indonesia: ");
        String word = scanner.next().toLowerCase();
        String translation = indonesianToEnglish.get(word);
        if (translation != null) {
            System.out.println("Artinya dalam Bahasa Inggris: " + translation);
        } else {
            System.out.println("Kata tidak ditemukan dalam kamus.");
        }
    }

    private static void initializeDictionary() {
        // Menambahkan kata-kata dan terjemahannya ke kamus
        addTranslation("hidung", "nose");
        addTranslation("mata", "eye");
        addTranslation("telinga", "ear");
        addTranslation("kaki", "foot");
        addTranslation("tangan", "hand");
        addTranslation("kepala", "head");
        // Tambahkan kata-kata lainnya di sini
    }

    private static void addTranslation(String indonesianWord, String englishWord) {
        englishToIndonesian.put(englishWord.toLowerCase(), indonesianWord.toLowerCase());
        indonesianToEnglish.put(indonesianWord.toLowerCase(), englishWord.toLowerCase());
    }
}
