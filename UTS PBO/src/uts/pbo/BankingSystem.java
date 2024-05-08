/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pbo;

/**
 *
 * @author TUFF
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class BankingSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public BankingSystem() {
        // Constructor kosong
    }

    // Method untuk menampilkan menu dan mengelola operasi perbankan
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
            scanner.nextLine(); // Consume newline character

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
                    return; // Keluar dari method showMenu() dan selesai program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
// Method untuk memeriksa apakah sebuah string berisi hanya digit
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

    // Method untuk registrasi akun baru
// Method untuk registrasi akun baru
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

    // Method untuk transfer uang antar akun
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

    // Method untuk menyimpan uang ke dalam akun
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

    // Method untuk mengecek informasi rekening
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

    // Method untuk mencari akun berdasarkan nomor akun
    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getNomorAkun().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Method untuk memeriksa apakah sebuah string dapat diubah menjadi integer
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method main sesuai dengan spesifikasi
    public static void main(String[] args) {
        try {
            BankingSystem bankingSystem = new BankingSystem();
            bankingSystem.showMenu(); // Memulai program dengan menampilkan menu
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
