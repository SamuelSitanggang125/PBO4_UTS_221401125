![image](https://github.com/SamuelSitanggang125/PBO4_UTS_221401125/assets/115195417/d618f810-e92f-4529-91a2-a9110267bba3)# PBO4_UTS_221401125
UTS PBO4

Jadi didalam program ini terdapat 2 kelas yaitu BankAccount dan juga BankSystem. Didalam BankAccount terdapat beberapa atribut yaitu:
• nama (String) 
• alamat (String) 
• nomor_telepon (String) 
• nomor_akun (String) 
• saldo (int) 
• tanggal_registrasi (LocalDateTime) 
Program:
public class BankAccount {
    private String nama;
    private String alamat;
    private String nomor_telepon;
    private String nomor_akun;
    private int saldo;
    private LocalDateTime tanggal_registrasi;

terdapat konstruktor:
    public BankAccount(String nama, String alamat, String nomor_telepon, int saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomor_telepon = nomor_telepon;

        this.nomor_akun = generateNomorAkun();

        this.saldo = saldo;
        this.tanggal_registrasi = LocalDateTime.now();
    }
nama: Parameter untuk menyimpan nama pemilik akun.
alamat: Parameter untuk menyimpan alamat pemilik akun.
nomor_telepon: Parameter untuk menyimpan nomor telepon pemilik akun.
saldo: Parameter untuk menyimpan saldo awal dalam akun.
this.nama = nama;: Menginisialisasi atribut nama dari objek BankAccount dengan nilai yang diterima dari parameter nama.
this.alamat = alamat;: Menginisialisasi atribut alamat dari objek BankAccount dengan nilai yang diterima dari parameter alamat.
this.nomor_telepon = nomor_telepon;: Menginisialisasi atribut nomor_telepon dari objek BankAccount dengan nilai yang diterima dari parameter nomor_telepon.
this.nomor_akun = generateNomorAkun();: Memanggil method generateNomorAkun() dan menyimpan hasilnya ke atribut nomor_akun dari objek BankAccount.
this.saldo = saldo;: Menginisialisasi atribut saldo dari objek BankAccount dengan nilai saldo awal yang diterima dari parameter saldo.
this.tanggal_registrasi = LocalDateTime.now();: Menginisialisasi atribut tanggal_registrasi dari objek BankAccount dengan waktu saat ini menggunakan LocalDateTime.now().

program:
    private String generateNomorAkun() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10)); // Generates random digits (0-9)
        }
        return sb.toString();
    }
metode generateNomorAkun() membuat objek Random menggunakan Random random = new Random();. Objek Random digunakan untuk menghasilkan bilangan acak. metode ini menggunakan objek StringBuilder (StringBuilder sb = new StringBuilder();) untuk membangun nomor akun secara bertahap. Penggunaan StringBuilder digunakan untuk menghindari pembuatan objek string baru setiap kali kita menambahkan karakter ke nomor akun. Dalam setiap iterasi, metode ini memanggil random.nextInt(10), yang menghasilkan angka acak antara 0 hingga 9. Angka ini kemudian ditambahkan ke objek StringBuilder menggunakan metode append(). Setelah semua digit telah ditambahkan ke StringBuilder, metode ini menggunakan sb.toString() untuk mengonversi StringBuilder ke String. Hasilnya adalah nomor akun yang terdiri dari 7 digit angka.

program:
    public void topUp(int jumlahTopUp) {
        if (jumlahTopUp > 0) {
            saldo += jumlahTopUp;
        } else {
            System.out.println("Invalid amount for top-up. Amount must be positive.");
        }
    }
metode ini melakukan validasi terhadap jumlahTopUp. Jika jumlahTopUp lebih dari 0 (positif), maka operasi top-up akan dilakukan dengan menambahkan nilai jumlahTopUp ke saldo akun menggunakan operator +=. Jika jumlahTopUp kurang dari atau sama dengan 0, metode akan mencetak pesan error "Invalid amount for top-up. Amount must be positive.", yang menunjukkan bahwa top-up tidak dapat dilakukan dengan nilai yang tidak valid (harus positif).

program:
    public void transfer(int jumlahTransfer) {
        if (jumlahTransfer > 0 && saldo >= jumlahTransfer) {
            saldo -= jumlahTransfer;
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
        }
    }
Metode transfer menerima satu parameter jumlahTransfer yang merupakan jumlah uang yang akan ditransfer. Sebelum melakukan transfer, metode ini melakukan dua validasi:
1. jumlahTransfer > 0: Pastikan jumlahTransfer adalah nilai positif.
2. saldo >= jumlahTransfer: Pastikan saldo akun saat ini cukup untuk melakukan transfer sejumlah jumlahTransfer.
Jika kedua kondisi validasi terpenuhi, maka jumlahTransfer akan dikurangkan dari saldo akun saat ini (saldo -= jumlahTransfer;), yang menandakan bahwa transfer telah berhasil dilakukan. Jika salah satu dari kedua validasi di atas tidak terpenuhi, metode akan mencetak pesan error "Transfer failed. Insufficient balance or invalid amount.", yang menunjukkan bahwa transfer tidak dapat dilakukan karena saldo tidak mencukupi atau jumlah transfer tidak valid.

Program:
    public void showDescription() {
        System.out.println("Nama              : " + nama);
        System.out.println("Alamat            : " + alamat);
        System.out.println("Nomor HP          : " + nomor_telepon);
        System.out.println("Nomor Akun        : " + nomor_akun);
        System.out.println("Saldo             : Rp. " + saldo);
        System.out.println("Tanggal Registrasi: " + tanggal_registrasi);
    }
Metode ini digunakan untuk menampilkan:
nama: Nama pemilik akun.
alamat: Alamat pemilik akun.
nomor_telepon: Nomor telepon pemilik akun.
nomor_akun: Nomor unik akun yang digenerate secara acak.
saldo: Jumlah saldo dalam akun.
tanggal_registrasi: Tanggal dan waktu saat akun diregistrasi.

Lalu, program ini juga memiliki kelas BankSystem yang memiliki beberapa Method:
1. Show Menu
2. RegisterAccount
3. TransferMoney
4. DepositMoney
5. CheckAccountInfo

Program ShowMenu:
    public void showMenu() {
        while (true) {
            System.out.println("+-------------------------------------------+");
            System.out.println("|Silahkan pilih program yang anda mau:      |");
            System.out.println("|1. Register Akun Baru                      |");
            System.out.println("|2. Mengirim Uang                           |");
            System.out.println("|3. Menyimpan Uang                          |");
            System.out.println("|4. Mengecek Informasi Rekening Pribadi     |");
            System.out.println("|5. Keluar                                  |");
            System.out.println("+-------------------------------------------+");

            System.out.print("Kode Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerAccount();
                    break;
                case 2:
                    transferMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    checkAccountInfo();
                    break;
                case 5:
                    System.out.println("Exiting Banking System...");
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

Metode showMenu() membantu dalam mengelola antarmuka pengguna dan menjalankan fungsi-fungsi yang sesuai berdasarkan pilihan pengguna. Metode menggunakan struktur switch untuk menentukan aksi yang sesuai berdasarkan kode pilihan yang dimasukkan oleh pengguna. Berikut adalah fungsi yang dilakukan berdasarkan kode pilihan:
Kode 1 (case 1): Memanggil method registerAccount() untuk mendaftarkan akun baru.
Kode 2 (case 2): Memanggil method transferMoney() untuk mentransfer uang antar akun.
Kode 3 (case 3): Memanggil method depositMoney() untuk menyimpan uang ke dalam akun.
Kode 4 (case 4): Memanggil method checkAccountInfo() untuk mengecek informasi rekening.
Kode 5 (case 5): Mengakhiri program dengan mencetak pesan "Exiting Banking System..." dan keluar dari method showMenu().

program:
public void registerAccount() {
    System.out.print("Masukkan nama anda                               : ");
    String nama = scanner.nextLine();
    System.out.print("Masukkan alamat anda                             : ");
    String alamat = scanner.nextLine();

    String nomor_telepon;
    do {
        System.out.print("Masukkan nomor telepon anda (up to 14 digits)    : ");
        nomor_telepon = scanner.nextLine().trim();

        // Validasi nomor telepon harus berupa bilangan bulat dan panjangnya tidak lebih dari 14 digit
        if (!isNumeric(nomor_telepon) || nomor_telepon.length() > 14) {
            System.out.println("Invalid phone number. Please enter a valid integer up to 14 digits.");
        }
    } while (!isNumeric(nomor_telepon) || nomor_telepon.length() > 14);

    System.out.print("Masukkan saldo awal anda                         : RP. ");
    int saldo = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.println("Akun bank anda berhasil dibuat.");
    System.out.println("Silahkan menikmati layanan yang kami sediakan");
    System.out.println("");

    BankAccount newAccount = new BankAccount(nama, alamat, nomor_telepon, saldo);
    accounts.add(newAccount);

    // Menampilkan informasi akun setelah registrasi berhasil
    System.out.println("\nBerikut data registrasi anda:");
    System.out.println("");
    System.out.println("============================================================");
    newAccount.showDescription();
    System.out.println("============================================================");
}

1. Meminta Input Data:
Pengguna diminta untuk memasukkan nama dan alamat mereka menggunakan scanner.nextLine() untuk membaca input teks dari konsol.
Kemudian, metode meminta pengguna untuk memasukkan nomor telepon dengan batasan maksimum 14 digit. Sebuah loop do-while digunakan untuk memastikan bahwa nomor telepon yang dimasukkan adalah bilangan bulat dan tidak melebihi panjang 14 digit.
2. Validasi Nomor Telepon:
Dalam loop do-while, metode melakukan validasi pada nomor telepon yang dimasukkan. Jika nomor telepon tidak berupa bilangan bulat atau melebihi 14 digit, pesan kesalahan akan ditampilkan dan pengguna diminta untuk memasukkan ulang nomor telepon yang valid.
3. Memasukkan Saldo Awal:
Pengguna diminta untuk memasukkan saldo awal akun dengan menggunakan scanner.nextInt(). Metode ini akan mengonsumsi karakter newline setelah mengambil input untuk mencegah masalah bacaan input berikutnya.
4. Membuat Akun Baru:
Setelah semua informasi yang diperlukan dimasukkan, sebuah objek BankAccount baru dibuat menggunakan data yang telah dimasukkan oleh pengguna. Objek BankAccount ini kemudian ditambahkan ke dalam ArrayList accounts yang menyimpan semua akun yang terdaftar.
5. Menampilkan Informasi Akun:
Setelah akun berhasil didaftarkan, metode mencetak informasi lengkap tentang akun baru yang telah didaftarkan, termasuk semua atribut seperti nama, alamat, nomor telepon, nomor akun, saldo, dan tanggal registrasi. Informasi akun dicetak menggunakan method showDescription() dari objek BankAccount yang baru saja dibuat.

Program:
    public void transferMoney() {
        System.out.print("Masukkan nomor akun pengirim              : ");
        String senderAccountNumber = scanner.nextLine();

        BankAccount senderAccount = findAccount(senderAccountNumber);
        if (senderAccount == null) {
            System.out.println("Invalid sender account number.");
            return;
        }

        System.out.print("Masukkan nomor akun penerima              : ");
        String recipientAccountNumber = scanner.nextLine();

        BankAccount recipientAccount = findAccount(recipientAccountNumber);
        if (recipientAccount == null) {
            System.out.println("Invalid recipient account number.");
            return;
        }

        System.out.print("Masukkan jumlah uang yang akan ditransfer : ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Check if sender has sufficient balance
        if (senderAccount.getSaldo() < amount) {
            System.out.println("Insufficient balance in sender's account.");
            return;
        } else {
            System.out.println("");
            System.out.println("Transaksi Berhasil.");
        }

        // Perform the transfer
        senderAccount.transfer(amount);
        recipientAccount.topUp(amount);

        // Print transaction details
        System.out.println("==================================================================");
        System.out.println("Nomor akun pengirim : " + senderAccount.getNomorAkun());
        System.out.println("Nama akun pengirim  : " + senderAccount.getNama());
        System.out.println("");
        System.out.println("Nomor akun penerima : " + recipientAccount.getNomorAkun());
        System.out.println("Nama akun penerima  : " + recipientAccount.getNama());
        System.out.println("Jumlah transfer     : " + amount);
        System.out.println("Waktu transaksi     : " + LocalDateTime.now());
        System.out.println("==================================================================");
    }
1. Memasukkan Nomor Akun Pengirim:
Pengguna diminta untuk memasukkan nomor akun pengirim menggunakan scanner.nextLine() untuk membaca input teks dari konsol. Metode kemudian mencari akun pengirim dengan nomor akun yang dimasukkan menggunakan method findAccount(). Jika akun pengirim tidak ditemukan, pesan kesalahan "Invalid sender account number." akan ditampilkan, dan metode akan keluar.
2. Memasukkan Nomor Akun Penerima:
Pengguna diminta untuk memasukkan nomor akun penerima menggunakan scanner.nextLine(). Metode mencari akun penerima dengan nomor akun yang dimasukkan menggunakan method findAccount(). Jika akun penerima tidak ditemukan, pesan kesalahan "Invalid recipient account number." akan ditampilkan, dan metode akan keluar.
3. Memasukkan Jumlah Uang yang Akan Ditransfer:
Pengguna diminta untuk memasukkan jumlah uang yang akan ditransfer menggunakan scanner.nextInt(). Setelah itu, scanner.nextLine() digunakan untuk mengonsumsi karakter newline agar tidak terjadi masalah bacaan input selanjutnya.
4. Validasi Saldo Pengirim:
Metode melakukan validasi untuk memastikan bahwa akun pengirim memiliki saldo yang mencukupi untuk transfer sejumlah uang yang diminta. Jika saldo pengirim kurang dari jumlah yang akan ditransfer, pesan kesalahan "Insufficient balance in sender's account." akan ditampilkan, dan metode akan keluar.
5. Melakukan Transfer:
Jika validasi saldo berhasil, metode akan melanjutkan untuk melakukan transfer dana antar akun. Panggilan senderAccount.transfer(amount) digunakan untuk mengurangi saldo akun pengirim sebesar jumlah yang ditransfer. Panggilan recipientAccount.topUp(amount) digunakan untuk menambah saldo akun penerima sebesar jumlah yang ditransfer.
6. Menampilkan Detail Transaksi:
Setelah transfer berhasil dilakukan, metode mencetak detail transaksi, termasuk informasi akun pengirim dan penerima, jumlah transfer, dan waktu transaksi menggunakan LocalDateTime.now().

Program:
    public void depositMoney() {
        System.out.print("Masukkan nomor akun                    : ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }

        System.out.print("Masukkan jumlah uang yang akan disimpan: Rp. ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Deposit uang ke dalam akun
        account.topUp(amount);
        System.out.println("Deposit successful.");

        // Print informasi transaksi deposit
        System.out.println("===============================================================");
        System.out.println("Account Number   : " + account.getNomorAkun());
        System.out.println("Current Balance  : Rp. " + account.getSaldo());
        System.out.println("Transaction Time : " + LocalDateTime.now());
        System.out.println("===============================================================");
    }
1. Memasukkan Nomor Akun:
Pengguna diminta untuk memasukkan nomor akun menggunakan scanner.nextLine() untuk membaca input teks dari konsol. Metode kemudian mencari akun berdasarkan nomor akun yang dimasukkan menggunakan method findAccount(). Jika akun tidak ditemukan, pesan kesalahan "Invalid account number." akan ditampilkan, dan metode akan keluar.
2. Memasukkan Jumlah Uang yang Akan Disimpan:
Pengguna diminta untuk memasukkan jumlah uang yang akan disimpan menggunakan scanner.nextInt().Setelah itu, scanner.nextLine() digunakan untuk mengonsumsi karakter newline agar tidak terjadi masalah bacaan input selanjutnya.
3. Melakukan Deposit:
Metode melakukan penambahan saldo akun (top-up) dengan memanggil account.topUp(amount) untuk menambah saldo akun sesuai dengan jumlah uang yang dimasukkan. Setelah deposit berhasil, pesan "Deposit successful." akan ditampilkan.
4. Menampilkan Informasi Transaksi:
Metode mencetak informasi transaksi deposit, termasuk nomor akun, saldo terbaru setelah deposit, dan waktu transaksi menggunakan LocalDateTime.now().

Program:
    public void checkAccountInfo() {
        System.out.print("Masukkan Nomor akun anda : ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
        } else {
            System.out.println("\nBerikut data registrasi anda:");
            System.out.println("");
            System.out.println("==================================================================");
            account.showDescription();
            System.out.println("==================================================================");
        }
    }
Pengguna diminta untuk memasukkan nomor akun dengan menggunakan scanner.nextLine() untuk membaca input dari pengguna. Metode findAccount(accountNumber) dipanggil untuk mencari akun berdasarkan nomor akun yang dimasukkan. Jika akun tidak ditemukan (nilai kembalian null), program akan mencetak pesan "Invalid account number." karena nomor akun yang dimasukkan tidak valid. Jika akun ditemukan (nilai kembalian tidak null), program akan mencetak informasi lengkap mengenai akun tersebut. Informasi yang dicetak termasuk nama, alamat, nomor telepon, nomor akun, saldo, dan tanggal registrasi. Informasi ini diperoleh dengan memanggil account.showDescription(), yang akan mencetak detail akun sesuai dengan format yang telah ditentukan.

Program:
    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getNomorAkun().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

Metode findAccount(String accountNumber) adalah sebuah private method yang digunakan untuk mencari objek BankAccount dalam ArrayList accounts berdasarkan nomor akun (accountNumber) yang diberikan. Metode ini menggunakan perulangan for-each untuk iterasi melalui setiap objek BankAccount dalam ArrayList. Pada setiap iterasi, metode memeriksa apakah nomor akun dari objek saat ini cocok dengan accountNumber yang dicari. Jika ditemukan, metode mengembalikan objek BankAccount, dan jika tidak ditemukan, metode mengembalikan null. Metode ini membantu dalam operasi perbankan seperti transfer uang, menyimpan uang, dan memeriksa informasi rekening dengan cara mudah mencari akun berdasarkan nomor akun yang diberikan.

program:
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
digunakan untuk memvalidasi nomor telepon saat registrasi akun baru. Nomor telepon harus berupa bilangan bulat, dan validasi ini membantu memastikan bahwa input yang dimasukkan sesuai dengan format yang diharapkan. Jika nomor telepon tidak dapat diubah menjadi bilangan bulat atau panjangnya melebihi batas, maka registrasi akan meminta input ulang.

program:
private boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    for (char c : str.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}

Fungsi isNumeric(String str) ini digunakan dalam kelas BankingSystem untuk validasi, seperti pada saat memeriksa nomor telepon yang dimasukkan saat registrasi akun. Validasi ini memastikan bahwa nomor telepon yang dimasukkan hanya terdiri dari digit numerik untuk memenuhi format yang diharapkan.
