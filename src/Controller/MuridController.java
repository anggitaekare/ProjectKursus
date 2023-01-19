package Controller;

import Entity.DaftarkurEntity;
import Entity.MapelEntity;
import Entity.MuridEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class MuridController implements ControllerInterface{

    int indexLogin = 0;
    public MuridController(){

    }

    public MuridEntity getData() {
        return AllObjectModel.muridModel.getMuridEntityArrayList(indexLogin);
    }

    public void daftarMurid(int indexMurid, MuridEntity muridEntity, boolean isVerified) {
        AllObjectModel.daftarKurModel.insertDataDaftarkur(new DaftarkurEntity(muridEntity, isVerified, indexMurid));
    }

    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel.muridModel.cekData(npm, password);
    }

    public void insert(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        AllObjectModel.muridModel.insert(new MuridEntity(npm, password, nama, no_telp, tglLahir, kelas));
    }

    public MuridEntity MuridEntity() {
        return AllObjectModel.muridModel.getMuridEntityArrayList(indexLogin);
    }

    public int cekDaftarKur(String npm) {
        int cek = AllObjectModel.daftarKurModel.cekData(npm, null);
        return cek;
    }

    public DaftarkurEntity showDaftarKur(int index) {
        return AllObjectModel.daftarKurModel.showDaftarkur(index);
    }
    
    public DefaultTableModel daftarkur(){
        DefaultTableModel dtmdaftarkur = new DefaultTableModel();
        Object[] kolom ={"NPM","Nama","Password","No Telp","Tgl Lahir","Mapel","Verified","Kelas"};
        dtmdaftarkur.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarKurModel.alldatakur().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(AllObjectModel.daftarKurModel.alldatakur().get(i).isVerified()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[8];
    data[0] = AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getNpm();
    data[1] = AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getNama();
    data[2] = AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getPassword();
    data[3] = AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getTglLahir();
    data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getTglLahir());
    data[5] = MapelEntity.mapel[AllObjectModel.daftarKurModel.alldatakur().get(i).getIndexKursus()];
    data[6] = verif;
    data[7] = AllObjectModel.daftarKurModel.alldatakur().get(i).getMurid().getKelas();
    dtmdaftarkur.addRow(data);
        }
    return dtmdaftarkur;
    }
}
