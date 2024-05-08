/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.pbo;

/**
 *
 * @author TUFF
 */
import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    private String nama;
    private String alamat;
    private String nomor_telepon;
    private String nomor_akun;
    private int saldo;
    private LocalDateTime tanggal_registrasi;

    // Constructor
    public BankAccount(String nama, String alamat, String nomor_telepon, int saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomor_telepon = nomor_telepon;

        // Generate random 7-digit account number
        this.nomor_akun = generateNomorAkun();

        this.saldo = saldo;
        this.tanggal_registrasi = LocalDateTime.now();
    }
    
    public String getNama() {
        return nama;
    }

    // Method to generate random account number
    private String generateNomorAkun() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10)); // Generates random digits (0-9)
        }
        return sb.toString();
    }

    // Method to add funds to the account (top-up)
    public void topUp(int jumlahTopUp) {
        if (jumlahTopUp > 0) {
            saldo += jumlahTopUp;
        } else {
            System.out.println("Invalid amount for top-up. Amount must be positive.");
        }
    }

    // Method to transfer funds to another account
    public void transfer(int jumlahTransfer) {
        if (jumlahTransfer > 0 && saldo >= jumlahTransfer) {
            saldo -= jumlahTransfer;
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
        }
    }

    // Method to display account information
    public void showDescription() {
        System.out.println("Nama              : " + nama);
        System.out.println("Alamat            : " + alamat);
        System.out.println("Nomor HP          : " + nomor_telepon);
        System.out.println("Nomor Akun        : " + nomor_akun);
        System.out.println("Saldo             : Rp. " + saldo);
        System.out.println("Tanggal Registrasi: " + tanggal_registrasi);
    }

    // Getter for account number
    public String getNomorAkun() {
        return nomor_akun;
    }

    // Getter for saldo (balance)
    public int getSaldo() {
        return saldo;
    }
}
