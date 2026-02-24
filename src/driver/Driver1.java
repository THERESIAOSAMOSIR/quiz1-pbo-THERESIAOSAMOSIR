import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String kode;
        int porsiButet;
        int porsiUcok;
        int totalPorsi;
        int harga = 0;
        int totalMenu;
        int totalBelanja = 0;

        System.out.println("Masukkan kode menu dan porsi Butet (ketik END untuk selesai)");

        while (true) {
            kode = input.nextLine();

            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            porsiButet = Integer.parseInt(input.nextLine());

            // Ucok makan 2x Butet
            porsiUcok = 2 * porsiButet;
            totalPorsi = porsiButet + porsiUcok;

            // Tentukan harga berdasarkan kode
            switch (kode) {
                case "NGS":
                    harga = 15000;
                    break;
                case "AP":
                    harga = 20000;
                    break;
                case "SA":
                    harga = 25000;
                    break;
                case "BU":
                    harga = 18000;
                    break;
                case "MAP":
                    harga = 15000;
                    break;
                case "GG":
                    harga = 15000;
                    break;
                case "SAM":
                    harga = 17000;
                    break;
                case "RD":
                    harga = 25000;
                    break;
                case "IB":
                    harga = 35000;
                    break;
                case "NUK":
                    harga = 20000;
                    break;
                default:
                    System.out.println("Kode tidak valid!");
                    continue;
            }

            totalMenu = totalPorsi * harga;
            totalBelanja += totalMenu;

            System.out.println("Menu: " + kode +
                    " | Total Porsi: " + totalPorsi +
                    " | Total: " + totalMenu);
        }

        // ===== HITUNG DISKON =====
        double diskon = 0;

        if (totalBelanja >= 500000) {
            diskon = 0.25;
        } else if (totalBelanja >= 400000) {
            diskon = 0.20;
        } else if (totalBelanja >= 300000) {
            diskon = 0.15;
        } else if (totalBelanja >= 200000) {
            diskon = 0.10;
        } else if (totalBelanja >= 100000) {
            diskon = 0.05;
        }

        double jumlahDiskon = totalBelanja * diskon;
        double totalBayar = totalBelanja - jumlahDiskon;

        // ===== CETAK STRUK =====
        System.out.println("\n==============================");
        System.out.println("Total Belanja : " + totalBelanja);
        System.out.println("Diskon        : " + (diskon * 100) + "%");
        System.out.println("Potongan      : " + jumlahDiskon);
        System.out.println("------------------------------");
        System.out.println("Total Bayar   : " + totalBayar);
        System.out.println("==============================");

        input.close();
    }
}
