import java.util.ArrayList;
import java.util.Scanner;

class Laundry {
    String idLaundry;
    String nama;
    String nim;
    String asrama;
    String kamar;
    String status;

    Laundry(String idLaundry, String nama, String nim, String asrama, String kamar) {
        this.idLaundry = idLaundry;
        this.nama = nama;
        this.nim = nim;
        this.asrama = asrama;
        this.kamar = kamar;
        this.status = "Diterima";
    }
}

public class Driver3 {

    static ArrayList<Laundry> dataLaundry = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Input Laundry");
            System.out.println("2. Update Status Laundry");
            System.out.println("3. Antar Laundry (Driver)");
            System.out.println("4. Cek Status Laundry");
            System.out.println("5. Tampilkan Semua Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch(pilihan) {
                case 1: inputLaundry(); break;
                case 2: updateStatus(); break;
                case 3: antarLaundry(); break;
                case 4: cekStatus(); break;
                case 5: tampilData(); break;
            }

        } while(pilihan != 0);
    }

    static void inputLaundry() {
        System.out.print("Nama Mahasiswa: ");
        String nama = input.nextLine();
        System.out.print("NIM: ");
        String nim = input.nextLine();
        System.out.print("Asrama: ");
        String asrama = input.nextLine();
        System.out.print("Kamar: ");
        String kamar = input.nextLine();

        String id = "LD" + (dataLaundry.size() + 1);

        Laundry l = new Laundry(id, nama, nim, asrama, kamar);
        dataLaundry.add(l);

        System.out.println("Laundry berhasil ditambahkan!");
        System.out.println("ID Laundry: " + id);
    }

    static void updateStatus() {
        System.out.print("Masukkan ID Laundry: ");
        String id = input.nextLine();

        for (Laundry l : dataLaundry) {
            if (l.idLaundry.equals(id)) {
                System.out.println("1. Dicuci");
                System.out.println("2. Dikeringkan");
                System.out.println("3. Disetrika");
                System.out.println("4. Siap Diantar");
                System.out.print("Pilih Status: ");
                int pilih = input.nextInt();
                input.nextLine();

                switch(pilih) {
                    case 1: l.status = "Dicuci"; break;
                    case 2: l.status = "Dikeringkan"; break;
                    case 3: l.status = "Disetrika"; break;
                    case 4: l.status = "Siap Diantar"; break;
                }

                System.out.println("Status diperbarui!");
                return;
            }
        }
        System.out.println("ID tidak ditemukan!");
    }

    static void antarLaundry() {
        System.out.print("Scan ID Laundry: ");
        String id = input.nextLine();

        for (Laundry l : dataLaundry) {
            if (l.idLaundry.equals(id)) {
                l.status = "Sudah Sampai";
                System.out.println("Laundry berhasil diantar ke:");
                System.out.println(l.nama + " - Asrama " + l.asrama + " Kamar " + l.kamar);
                return;
            }
        }
        System.out.println("Laundry tidak ditemukan!");
    }

    static void cekStatus() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        for (Laundry l : dataLaundry) {
            if (l.nim.equals(nim)) {
                System.out.println("Status Laundry: " + l.status);
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    static void tampilData() {
        for (Laundry l : dataLaundry) {
            System.out.println("\nID: " + l.idLaundry);
            System.out.println("Nama: " + l.nama);
            System.out.println("NIM: " + l.nim);
            System.out.println("Asrama: " + l.asrama);
            System.out.println("Kamar: " + l.kamar);
            System.out.println("Status: " + l.status);
        }
    }
}
