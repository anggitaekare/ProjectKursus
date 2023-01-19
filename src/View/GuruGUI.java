/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.AllObjectModel;
import Controller.MuridController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author GITA
 */
public class GuruGUI {
    
    private static MuridController murid = new MuridController();
    JFrame Guru = new JFrame();
    JTable tabelmurid = new JTable();
    JScrollPane scrollguru = new JScrollPane(tabelmurid);
    JButton back, verif;
    JLabel admin, npmlabel, passlabel;
    JTextField npmtext, passtext;
    
    public GuruGUI(){
        
        Guru.setSize(650, 500);
        Guru.setLayout(null);
        Guru.getContentPane().setBackground(Color.LIGHT_GRAY);
        admin = new JLabel("Admin");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Guru.add(admin);
        scrollguru.setBounds(30, 100, 570, 200);
        tabelmurid.setModel(murid.daftarkur());
        Guru.add(scrollguru);
        npmlabel = new JLabel("NPM");
        npmlabel.setBounds(50, 320, 100, 30);
        Guru.add(npmlabel);
        npmtext = new JTextField();
        npmtext.setBounds(50, 350, 100, 30);
        Guru.add(npmtext);
        passlabel = new JLabel("password");
        passlabel.setBounds(200, 320, 100, 30);
        Guru.add(passlabel);
        passtext = new JTextField();
        passtext.setBounds(200, 350, 100, 30);
        Guru.add(passtext);
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GREEN);
        Guru.add(verif);
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        Guru.add(back);
        Guru.setLocationRelativeTo(null);
        Guru.setVisible(true);
        Guru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Guru.dispose();
                GUI men = new GUI();
            }
        });
        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String npm = npmtext.getText();
                String pass = passtext.getText();
                int index = AllObjectModel.daftarKurModel.cekData(npm, pass);
                Allobjectrl.admin.updateIsVerified(index, Allobjectrl.murid.showDaftarKur(index).getIndexKursus(), Allobjectrl.murid.showDaftarKur(index).getMurid());
                tabelmurid.setModel(murid.daftarkur());
            }
        });
        tabelmurid.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelmurid.getSelectedRow();
                npmtext.setText(Allobjectrl.murid.daftarkur().getValueAt(i, 0).toString());
                passtext.setText(Allobjectrl.murid.daftarkur().getValueAt(i, 1).toString());
            }
        });
        
    }
    
}
