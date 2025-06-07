// Kelas yang mengatur strategi komputer dalam permainan Tic Tac Toe
public class StrategyCompWin {
    
    /*
    Method utama untuk menentukan langkah terbaik komputer
    @param board objek papan permainan saat ini
    @return array [baris, kolom] posisi terbaik untuk langkah komputer
    */
    public static int[] getBestMove(Board board) {
        int[][] data = board.getData(); // Mendapatkan keadaan papan saat ini

        // 1. Prioritas pertama: Cek apakah komputer bisa menang langsung
        int[] winMove = findWinningMove(data, -1); // -1 mewakili X (komputer)
        if (winMove != null) return winMove;

        // 2. Prioritas kedua: Cek apakah perlu memblokir pemain manusia
        int[] blockMove = findWinningMove(data, 1); // 1 mewakili O (pemain)
        if (blockMove != null) return blockMove;

        // 3. Prioritas ketiga: Ambil posisi tengah jika tersedia
        if (data[1][1] == 0) return new int[]{1, 1};

        // 4. Prioritas keempat: Ambil salah satu sudut yang kosong
        int[][] corners = {{0,0}, {0,2}, {2,0}, {2,2}}; // Daftar posisi sudut
        for (int[] corner : corners) {
            if (data[corner[0]][corner[1]] == 0) {
                return corner;
            }
        }

        // 5. Prioritas terakhir: Ambil kotak kosong pertama yang ditemukan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return null; // Kembalikan null jika tidak ada langkah tersisa
    }

    /*
    Method untuk mencari langkah yang bisa membuat pemain tertentu menang
    @param data keadaan papan saat ini
    @param player pemain yang dicek (1 untuk O, -1 untuk X)
    @return posisi [baris, kolom] yang membuat pemain menang, atau null jika tidak ada
    */
    private static int[] findWinningMove(int[][] data, int player) {
        // Cek semua kotak kosong di papan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == 0) {  // Jika kotak kosong
                    // Coba isi dengan tanda pemain
                    data[i][j] = player;
                    // Cek apakah ini membuat pemain menang
                    if (checkWinForPlayer(data, player)) {
                        data[i][j] = 0;  // Kembalikan ke keadaan semula
                        return new int[]{i, j};  // Return posisi menang
                    }
                    data[i][j] = 0;  // Kembalikan ke keadaan semula
                }
            }
        }
        return null;  // Tidak ada langkah yang membuat pemain menang
    }

    /*
    Method untuk mengecek apakah pemain tertentu sudah menang
    @param data keadaan papan saat ini
    @param player pemain yang dicek (1 untuk O, -1 untuk X)
    @return true jika pemain menang, false jika belum
    */
    private static boolean checkWinForPlayer(int[][] data, int player) {
        // Cek kemenangan di baris
        for (int i = 0; i < 3; i++) {
            if (data[i][0] == player && data[i][1] == player && data[i][2] == player) {
                return true;
            }
        }
        
        // Cek kemenangan di kolom
        for (int i = 0; i < 3; i++) {
            if (data[0][i] == player && data[1][i] == player && data[2][i] == player) {
                return true;
            }
        }
        
        // Cek diagonal kiri atas ke kanan bawah
        if (data[0][0] == player && data[1][1] == player && data[2][2] == player) {
            return true;
        }
        
        // Cek diagonal kanan atas ke kiri bawah
        if (data[0][2] == player && data[1][1] == player && data[2][0] == player) {
            return true;
        }
        
        return false;  // Pemain belum menang
    }
}