// Kelas yang merepresentasikan papan permainan Tic Tac Toe
public class Board {
    // Variabel untuk menyimpan data papan (0 = kosong, 1 = O, -1 = X)
    private int[][] data;
    // Variabel untuk menentukan giliran pemain (1 = O, -1 = X)
    private int turn;
    
    /*
    Constructor untuk inisialisasi papan permainan
    @param turn menentukan pemain mana yang mulai pertama (1 untuk O, -1 untuk X)
    */
    public Board(int turn) {
        this.data = new int[3][3];  // Membuat papan 3x3
        this.turn = turn;           // Set giliran pertama
    }
    
    // Method untuk menampilkan papan ke layar
    public void disp() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                switch(this.data[i][j]) {
                    case 0  -> System.out.print("  -  ");  // Kosong
                    case -1 -> System.out.print("  X  ");  // Pemain X
                    case 1  -> System.out.print("  O  ");  // Pemain O
                }
            }
            System.out.println();  // Baris baru setiap baris papan
        }
        System.out.println("\n\n");  // Spasi antar tampilan
    }
    
    /*
    Method untuk menempatkan tanda pada papan
    @param brs baris yang dipilih (0-2)
    @param kol kolom yang dipilih (0-2)
    @return true jika penempatan berhasil, false jika kotak sudah terisi
    */
    public boolean setBoard(int brs, int kol) {
        if(this.data[brs][kol] == 0) {  // Cek kotak kosong
            this.data[brs][kol] = turn; // Isi dengan tanda pemain sekarang
            turn = -turn;               // Ganti giliran
            return true;
        }
        else
            return false;
    }
    
    /*
    Method untuk menentukan pemenang
    @return 1 jika O menang, -1 jika X menang, 0 jika belum ada pemenang
    */
    public int winner() {
        // Cek kemenangan di baris
        for(int i = 0; i < 3; i++) {
            if(this.data[i][0] == this.data[i][1] && 
               this.data[i][1] == this.data[i][2] && 
               this.data[i][0] != 0) {
                return this.data[i][0];
            }
        }

        // Cek kemenangan di kolom
        for(int j = 0; j < 3; j++) {
            if(this.data[0][j] == this.data[1][j] && 
               this.data[1][j] == this.data[2][j] && 
               this.data[0][j] != 0) {
                return this.data[0][j]; 
            }
        }

        // Cek diagonal kiri atas ke kanan bawah
        if(this.data[0][0] == this.data[1][1] && 
           this.data[1][1] == this.data[2][2] && 
           this.data[0][0] != 0) {
            return this.data[0][0];
        }

        // Cek diagonal kanan atas ke kiri bawah
        if(this.data[0][2] == this.data[1][1] && 
           this.data[1][1] == this.data[2][0] && 
           this.data[0][2] != 0) {
            return this.data[0][2];
        }

        return 0;  // Belum ada pemenang
    }
    
    /*
    Method untuk mengecek apakah permainan sudah selesai
    @return true jika sudah ada pemenang atau papan penuh
    */
    public boolean gameOver() {
        if(winner() == 1 || winner() == -1) {  // Ada pemenang
            return true;
        } else if(isFull()) {  // Papan penuh (seri)
            return true;
        }
        return false;          // Permainan belum selesai
    }

    /*
    Method untuk mengecek apakah papan sudah penuh
    @return true jika semua kotak terisi
    */
    public boolean isFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.data[i][j] == 0) {  // Ada kotak kosong
                    return false;
                }
            }
        }
        return true; // papan Tic Tac Toe sudah penuh
    }
    
    /*
    Method untuk mereset papan permainan
    */
    public void resetBoard() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                this.data[i][j] = 0;  // Set semua kotak ke kosong
    }

    /*
    Getter untuk mendapatkan giliran pemain saat ini
    @return 1 untuk O, -1 untuk X
    */
    public int getTurn() {
        return this.turn;
    }
    
    /*
    Getter untuk mendapatkan data papan
    @return array 2D representasi papan
    */
    public int[][] getData() {
        return this.data;
    }
}