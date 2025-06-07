// Import library Scanner untuk input user
import java.util.Scanner;

// Kelas utama permainan Tic Tac Toe
public class TicTacToe {
    // Method utama yang akan dijalankan pertama kali
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari user
        Scanner scanner = new Scanner(System.in);
        // Variabel untuk menentukan apakah user ingin bermain lagi
        boolean playAgain = true;

        // Loop utama permainan
        while (playAgain) {
            // Menampilkan menu pilihan mode permainan
            System.out.println("Pilih Mode Permainan:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.print("Masukkan pilihan: ");
            // Membaca input pilihan mode dari user
            int pilihan = scanner.nextInt();

            // Membuat objek papan permainan dengan ukuran 3x3
            Board board = new Board(1);

            // Loop permainan selama belum selesai
            while (!board.gameOver()) {
                if (pilihan == 1) {
                    // Mode Player vs Player
                    // Menampilkan papan permainan
                    board.disp();
                    // Meminta input gerakan dari player
                    PlayerMove(board);
                } else if (pilihan == 2) {
                    // Mode Player vs Computer
                    System.out.println("Pilih Mode Kesulitan:");
                    System.out.println("1. Easy");
                    System.out.println("2. Hard");
                    System.out.print("Masukkan pilihan: ");
                    int mode = scanner.nextInt();
                    switch (mode) {
                        case 1:
                            // Mode Easy (Komputer gerakan random)
                            do {
                                // Giliran player
                                board.disp();
                                PlayerMove(board);
                                // Giliran komputer
                                System.out.println("Giliran Komputer ('X')");
                                boolean moved = false;
                                // Komputer memilih posisi random sampai valid
                                while (!moved) {
                                    int brs = (int)(Math.random() * 3);
                                    int kol = (int)(Math.random() * 3);
                                    moved = board.setBoard(brs, kol);
                                }
                            } while (!board.gameOver());
                            break;
                    
                        case 2:
                            // Mode Hard (Komputer menggunakan strategi)
                            do {
                                // Giliran Komputer
                                System.out.println("Giliran Komputer ('O')");
                                // Komputer mencari gerakan terbaik
                                int[] move = StrategyCompWin.getBestMove(board);
                                if (move != null) {
                                    board.setBoard(move[0], move[1]);
                                }
                                board.disp();
                                // Cek apakah permainan sudah selesai
                                if (board.gameOver()) {
                                    break;
                                }
                                // Giliran Player
                                PlayerMove(board);
                            } while (!board.gameOver());
                            break;

                        default:
                            // Input tidak valid
                            System.out.println("Masukan yang anda masukan tidak valid!");
                            break;
                    }
                }
            }

            // Menampilkan hasil akhir permainan
            if (board.winner() == 1) {
                System.out.println("Pemain 'O' menang!");
            } else if (board.winner() == -1) {
                System.out.println("Pemain 'X' menang!");
            } else {
                System.out.println("Permainan seri!");
            }

            // Menanyakan apakah user ingin bermain lagi
            System.out.print("Ingin main lagi? (y/n): ");
            String jawaban = scanner.next();
            if (jawaban.equalsIgnoreCase("y")) {
                // Reset papan jika ingin bermain lagi
                board.resetBoard();
            } else {
                // Keluar dari loop permainan
                playAgain = false;
            }
        }

        // Menutup scanner dan menampilkan pesan penutup
        scanner.close();
        System.out.println("Terima kasih telah bermain!");
    }

    // Method untuk menangani gerakan player
    private static void PlayerMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        // Menampilkan giliran player saat ini
        System.out.println("Giliran Player: "+board.getTurn());
        // Meminta input baris
        System.out.print("Masukkan baris (0-2): ");
        int baris = scanner.nextInt();
        // Meminta input kolom
        System.out.print("Masukkan kolom (0-2): ");
        int kolom = scanner.nextInt();

        // Validasi input dan coba melakukan gerakan
        if (baris < 0 || baris > 2 || kolom < 0 || kolom > 2 || !board.setBoard(baris, kolom)) {
            // Jika input tidak valid, minta input ulang
            System.out.println("Posisi tidak valid! Silakan coba lagi.");
            PlayerMove(board);
        }
    }
}