import java.util.Scanner;

public class BankMangkiriQueue {
    private static final int MAX_SIZE = 10; // Maksimal jumlah antrian per jalur
    private static String[] queueA = new String[MAX_SIZE]; // Antrian jalur 1
    private static String[] queueB = new String[MAX_SIZE]; // Antrian jalur 2
    private static int frontA = -1, rearA = -1; // Front dan rear untuk jalur 1
    private static int frontB = -1, rearB = -1; // Front dan rear untuk jalur 2

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Hapus Antrian Elemen Pertama");
            System.out.println("3. Hapus Antrian di Posisi Tertentu");
            System.out.println("4. Hapus Semua Elemen");
            System.out.println("5. Tampilkan Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    enqueue(input);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    delete(input);
                    break;
                case 4:
                    clear();
                    break;
                case 5:
                    display();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void enqueue(Scanner input) {
        System.out.print("Masukkan data antrian: ");
        String data = input.next();
        System.out.print("Masukkan nomor jalur (1 atau 2): ");
        int jalur = input.nextInt();
        switch (jalur) {
            case 1:
                if (rearA == MAX_SIZE - 1) {
                    System.out.println("Antrian jalur 1 penuh!");
                } else {
                    if (frontA == -1) {
                        frontA = 0;
                    }
                    rearA++;
                    queueA[rearA] = data;
                    System.out.println("Data " + data + " telah ditambahkan ke antrian jalur 1");
                }   break;
            case 2:
                if (rearB == MAX_SIZE - 1) {
                    System.out.println("Antrian jalur 2 penuh!");
                } else {
                    if (frontB == -1) {
                        frontB = 0;
                    }
                    rearB++;
                    queueB[rearB] = data;
                    System.out.println("Data " + data + " telah ditambahkan ke antrian jalur 2");
                }   break;
            default:
                System.out.println("Jalur tidak valid!");
                break;
        }
    }

    private static void dequeue() {
        if (frontA == -1 && frontB == -1) {
            System.out.println("Antrian kosong!");
        } else {
            String data;
            if (frontA != -1) {
                data = queueA[frontA];
                if (frontA == rearA) {
                    frontA = -1;
                    rearA = -1;
                } else {
                    frontA++;
                }
                System.out.println("Data " + data + " telah dihapus dari antrian jalur 1");
            } else {
                data = queueB[frontB];
                if (frontB == rearB) {
                    frontB = -1;
                    rearB = -1;
                } else {
                    frontB++;
                }
                System.out.println("Data " + data + " telah dihapus dari antrian jalur 2");
            }
        }
    }

    private static void delete(Scanner input) {
        System.out.print("Masukkan nomor jalur (1 atau 2): ");
        int jalur = input.nextInt();
        System.out.print("Masukkan posisi data yang akan dihapus: ");
        int pos = input.nextInt() - 1;
        switch (jalur) {
            case 1:
                if (frontA == -1) {
                    System.out.println("Antrian jalur 1 kosong!");
                } else if (pos < frontA || pos > rearA) {
                    System.out.println("Posisi tidak valid!");
                } else {
                    String data = queueA[pos];
                    for (int i = pos; i < rearA; i++) {
                        queueA[i] = queueA[i + 1];
                    }
                    queueA[rearA] = null;
                    rearA--;
                    System.out.println("Data " + data + " telah dihapus dari antrian jalur 1");
                }       break;
            case 2:
                if (frontB == -1) {
                    System.out.println("Antrian jalur 2 kosong!");
                } else if (pos < frontB || pos > rearB) {
                    System.out.println("Posisi tidak valid!");
                } else {
                    String data = queueB[pos];
                    for (int i = pos; i < rearB; i++) {
                        queueB[i] = queueB[i + 1];
                    }
                    queueB[rearB] = null;
                    rearB--;
                    System.out.println("Data " + data + " telah dihapus dari antrian jalur 2");
                }       break;
            default:
                System.out.println("Jalur tidak valid!");
                break;
        }
    }

    private static void clear() {
        if (frontA == -1 && frontB == -1) {
            System.out.println("Antrian kosong!");
        }   else {
            for (int i = frontA; i <= rearA; i++) {
                queueA[i] = null;
            }
            for (int i = frontB; i <= rearB; i++) {
                queueB[i] = null;
            }
            frontA = -1;
            rearA = -1;
            frontB = -1;
            rearB = -1;
            System.out.println("Semua elemen telah dihapus dari antrian!");
        }
    }

    private static void display() {
        if (frontA == -1 && frontB == -1) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Isi antrian jalur 1:");
            if (frontA == -1) {
                System.out.println("Kosong");
            } else {
                for (int i = frontA; i <= rearA; i++) {
                    System.out.println((i + 1) + ". " + queueA[i]);
                }
            }
            System.out.println("Isi antrian jalur 2:");
            if (frontB == -1) {
                System.out.println("Kosong");
            } else {
                for (int i = frontB; i <= rearB; i++) {
                    System.out.println((i + 1) + ". " + queueB[i]);
                }
            }
        }
    }
}