import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input jumlah data
        System.out.print("Masukkan jumlah data: ");
        int N = input.nextInt();

        // Membuat array untuk menyimpan nilai
        int[] nilai = new int[N];

        // Input semua nilai siswa
        for(int i = 0; i < N; i++){
            System.out.print("Masukkan nilai ke-" + (i+1) + ": ");
            nilai[i] = input.nextInt();
        }

        // Input kode kelompok
        System.out.print("Masukkan kode kelompok (1 / 2): ");
        int kelompok = input.nextInt();

        // Variabel untuk menyimpan total nilai kelompok
        int total = 0;

        // Proses pemisahan dan penjumlahan berdasarkan kelompok
        for(int i = 0; i < N; i++){

            // Kelompok 1 -> indeks genap
            if(kelompok == 1 && i % 2 == 0){
                total += nilai[i];
            }

            // Kelompok 2 -> indeks ganjil
            else if(kelompok == 2 && i % 2 != 0){
                total += nilai[i];
            }
        }

        // Output hasil
        System.out.println("Total nilai kelompok " + kelompok + " adalah: " + total);
    }
}