/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bandmetal;

/**
 *
 * @author muham
 */

import java.util.ArrayList;
import java.util.Scanner;

class Band {
    private String nama;
    private String genre;
    private int tahunBerdiri;
    private int jumlahAnggota;

    // Constructor
    public Band(String nama, String genre, int tahunBerdiri, int jumlahAnggota) {
        this.nama = nama;
        this.genre = genre;
        this.tahunBerdiri = tahunBerdiri;
        this.jumlahAnggota = jumlahAnggota;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTahunBerdiri() {
        return tahunBerdiri;
    }

    public void setTahunBerdiri(int tahunBerdiri) {
        this.tahunBerdiri = tahunBerdiri;
    }

    public int getJumlahAnggota() {
        return jumlahAnggota;
    }

    public void setJumlahAnggota(int jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    public void displayInfo(int nomor) {
        System.out.println(nomor + ". Nama Band: " + nama);
        System.out.println("   Genre: " + genre);
        System.out.println("   Tahun Berdiri: " + tahunBerdiri);
        System.out.println("   Jumlah Anggota: " + jumlahAnggota);
    }
}

public class BandMetal {
    private static ArrayList<Band> bands = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahBand();
                    break;
                case 2:
                    tampilkanSemuaBand();
                    break;
                case 3:
                    ubahDataBand();
                    break;
                case 4:
                    hapusBand();
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih:0");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
        
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("MANAJEMEN BAND METAL");
        System.out.println("1. Tambah Band Baru");
        System.out.println("2. Tampilkan Semua Band");
        System.out.println("3. Ubah Data pada Band");
        System.out.println("4. Hapus Band");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    private static void tambahBand() {
        System.out.println("TAMBAH BAND BARU:");
        
        System.out.print("Masukkan nama band: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan genre: ");
        String genre = scanner.nextLine();
        
        System.out.print("Masukkan tahun berdiri: ");
        int tahun = scanner.nextInt();
        
        System.out.print("Masukkan jumlah anggota: ");
        int anggota = scanner.nextInt();
        scanner.nextLine(); 

        Band bandBaru = new Band(nama, genre, tahun, anggota);
        bands.add(bandBaru);
        
        System.out.println("Band berhasil ditambahkan!");
    }

    private static void tampilkanSemuaBand() {
        System.out.println("\n=== DAFTAR SEMUA BAND ===");
        
        if (bands.isEmpty()) {
            System.out.println("Belum ada data band.");
            return;
        }
        for (int i = 0; i < bands.size(); i++) {
            bands.get(i).displayInfo(i + 1);
        }
    }

    private static void ubahDataBand() {
        System.out.println("UBAH DATA BAND");
        
        if (bands.isEmpty()) {
            System.out.println("Belum ada data band.");
            return;
        }

        tampilkanSemuaBand();
        
        System.out.print("Pilih nomor band yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan buffer

        if (index < 0 || index >= bands.size()) {
            System.out.println("Nomor band tidak valid!");
            return;
        }

        Band band = bands.get(index);
        
        System.out.print("Masukkan nama band yang baru (" + band.getNama() + "): ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) {
            band.setNama(nama);
        }
        
        System.out.print("Masukkan genre band yang baru (" + band.getGenre() + "): ");
        String genre = scanner.nextLine();
        if (!genre.isEmpty()) {
            band.setGenre(genre);
        }
        
        System.out.print("Masukkan tahun berdiri band yang baru (" + band.getTahunBerdiri() + "): ");
        String tahunInput = scanner.nextLine();
        if (!tahunInput.isEmpty()) {
            band.setTahunBerdiri(Integer.parseInt(tahunInput));
        }
        
        System.out.print("Masukkan jumlah anggota band yang baru (" + band.getJumlahAnggota() + "): ");
        String anggotaInput = scanner.nextLine();
        if (!anggotaInput.isEmpty()) {
            band.setJumlahAnggota(Integer.parseInt(anggotaInput));
        }

        System.out.println("Data band berhasil diubah!");
    }

    private static void hapusBand() {
        System.out.println("\n=== HAPUS BAND ===");
        
        if (bands.isEmpty()) {
            System.out.println("Belum ada data band.");
            return;
        }

        tampilkanSemuaBand();
        
        System.out.print("Pilih nomor band yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan buffer

        if (index < 0 || index >= bands.size()) {
            System.out.println("Nomor band tidak valid!");
            return;
        }

        Band band = bands.get(index);
        System.out.print("Yakin ingin menghapus data band '" + band.getNama() + "'? (yaa/tidak): ");
        String konfirmasi = scanner.nextLine();
        
        if (konfirmasi.equalsIgnoreCase("yaa")) {
            bands.remove(index);
            System.out.println("Band berhasil dihapus!");
        } else {
            System.out.println("Mengahpus dibatalkan.");
        }
    }
}