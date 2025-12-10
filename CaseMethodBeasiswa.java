import java.util.Scanner;

public class CaseMethodBeasiswa {
    // Abie
    static Scanner sc = new Scanner(System.in);
    static final int MAX = 100;
    static String[] nama = new String[MAX];
    static String[] nim = new String[MAX];
    static double[] ipk = new double[MAX];
    static String[] jenis = new String[MAX];
    static int[] penghasilan = new int[MAX];

    static int jumlahData = 0;

    // Ghulam
    static void tambahData() {
        if (jumlahData >= MAX) {
            System.out.println("Data penuh! Tidak dapat menambah pendaftar lagi.");
            return;
        }

        System.out.print("Nama Mahasiswa: ");
        nama[jumlahData] = sc.nextLine();

        System.out.print("NIM: ");
        nim[jumlahData] = sc.nextLine();

        System.out.print("IPK terakhir: ");
        ipk[jumlahData] = Double.parseDouble(sc.nextLine());

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        jenis[jumlahData] = sc.nextLine();

        if (!jenis[jumlahData].equalsIgnoreCase("Reguler") &&
                !jenis[jumlahData].equalsIgnoreCase("Unggulan") &&
                !jenis[jumlahData].equalsIgnoreCase("Riset")) {
            System.out.println("Jenis beasiswa tidak valid!");
            return;
        }

        System.out.print("Penghasilan orang tua (maksimal 2000000): ");
        penghasilan[jumlahData] = Integer.parseInt(sc.nextLine());

        if (penghasilan[jumlahData] > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas.");
            return;
        }

        jumlahData++;
        System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlahData);
    }

    // timothy
    static void tampilkanSemua() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Nama\t\tNIM\t\tIPK\tJenis\t\tPenghasilan");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%s\t\t%s\t\t%.2f\t%s\t\t%d\n",
                    nama[i], nim[i], ipk[i], jenis[i], penghasilan[i]);
        }
    }

    // Ega
    static void cariJenis() {
        System.out.print("Masukkan jenis beasiswa (Reguler/Unggulan/Riset): ");
        String cari = sc.nextLine();

        boolean ketemu = false;

        for (int i = 0; i < jumlahData; i++) {
            if (jenis[i].equalsIgnoreCase(cari)) {
                if (!ketemu) {
                    System.out.println("\nData ditemukan:");
                }
                ketemu = true;
                System.out.println(nama[i] + " - " + nim[i] + " - IPK: " + ipk[i]);
            }
        }

        if (!ketemu) {
            System.out.println("Tidak ada pendaftar dengan jenis tersebut.");
        }
    }

    // ELghulam
    static void hitungRataIPK() {
        String[] jenisBeasiswa = { "Reguler", "Unggulan", "Riset" };

        for (String jns : jenisBeasiswa) {
            double total = 0;
            int count = 0;

            for (int i = 0; i < jumlahData; i++) {
                if (jenis[i].equalsIgnoreCase(jns)) {
                    total += ipk[i];
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(jns + ": tidak ada pendaftar.");
            } else {
                System.out.printf("%s : rata-rata IPK = %.2f\n", jns, total / count);
            }
        }
    }

    // Abie
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Pendaftaran Beasiswa ===");
            System.out.println("1. Tambah Data Pendaftar Beasiswa");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
            System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanSemua();
                    break;
                case 3:
                    cariJenis();
                    break;
                case 4:
                    hitungRataIPK();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
