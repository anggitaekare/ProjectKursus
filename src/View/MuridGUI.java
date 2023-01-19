/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.MapelEntity;
import Entity.MuridEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author GITA
 */
public class MuridGUI {
    
    JFrame Murid = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarmapel;
    JComboBox pilkur = new JComboBox(MapelEntity.mapel);
    int cek = Allobjectrl.murid.cekDaftarKur(Allobjectrl.murid.MuridEntity().getNpm());
    
    public MuridGUI(){
        Murid.setSize(720, 600);
        Murid.setLayout(null);
        Murid.getContentPane().setBackground(Color.LIGHT_GRAY);
        datadiri = new JLabel("Data Murid");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Murid.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Murid.add(area);
        daftarmapel = new JLabel("Daftar Kursus");
        daftarmapel.setBounds(450, 30, 250, 30);
        daftarmapel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Murid.add(daftarmapel);
        pilkur.setBounds(450, 90, 230, 30);
        Murid.add(pilkur);
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Murid.add(daftarbtn);
        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GREEN);
        Murid.add(back);
        Murid.setVisible(true);
        Murid.setLocationRelativeTo(null);
        Murid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Kursus", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belun Daftar Kursus", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datamurid());
        }
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexkur = pilkur.getSelectedIndex();
                Allobjectrl.murid.daftarMurid(indexkur, Allobjectrl.murid.getData(), false);
                area.setText(datamurid());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Murid.dispose();
                GUI men = new GUI();
            }
        });
    }

    public String datamurid() {
        int cek = Allobjectrl.murid.cekDaftarKur(Allobjectrl.murid.MuridEntity().getNpm());
        String cekverif;
        if (Allobjectrl.murid.showDaftarKur(cek).isVerified() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text = "Npm = " + Allobjectrl.murid.showDaftarKur(cek).getMurid().getNpm() + "\n" + "Nama = " + Allobjectrl.murid.showDaftarKur(cek).getMurid().getNama() + "\n"
                + "No Telp = " + Allobjectrl.murid.showDaftarKur(cek).getMurid().getNo_telp() + "\n" + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").
                format(Allobjectrl.murid.showDaftarKur(cek).getMurid().getTglLahir()) + "\n" + "verifikasi = " + cekverif + "\n" + "Kelas = " + Allobjectrl.murid.
                showDaftarKur(cek).getMurid().getKelas() + "\n" + "mapel = " + MapelEntity.mapel[Allobjectrl.murid.showDaftarKur(cek).getIndexKursus()];
        return text;
    }


    
}
