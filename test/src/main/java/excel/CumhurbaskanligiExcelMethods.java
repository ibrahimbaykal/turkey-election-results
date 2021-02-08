package excel;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import excel.model.Cumhurbaskanligi2014SecimiIlModeli;
import excel.utils.CumhurbaskanligiExcelUtils;
import excel.utils.FileUtil;
import excel.utils.MongoUtils;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CumhurbaskanligiExcelMethods {

    public void getIlSonucWithIlce(){
        List<Cumhurbaskanligi2014SecimiIlModeli> cumhurbaskanligi2014SecimiIlModeliList;
        String folderPath = "/home/ibrahim/Documents/cumhurbaskanligi/bütün iller/";
        FileUtil fileUtil = new FileUtil();
        List<String> cumhurbaskanligiSecimi2018FileNameList = fileUtil.getFileNames(folderPath);
        CumhurbaskanligiExcelUtils cbExcelUtils = new CumhurbaskanligiExcelUtils();
        for (String filename: cumhurbaskanligiSecimi2018FileNameList) {
            cumhurbaskanligi2014SecimiIlModeliList = new ArrayList<>();
            cumhurbaskanligi2014SecimiIlModeliList = cbExcelUtils.readCumhurbaskanligiExcel(folderPath + filename);
            for (Cumhurbaskanligi2014SecimiIlModeli model: cumhurbaskanligi2014SecimiIlModeliList) {
                System.out.println(model.toString());
            }

        }
    }

    private void setMongoDBCollectionData(Cumhurbaskanligi2014SecimiIlModeli model){
        MongoUtils mongoUtils = new MongoUtils();
        MongoCollection<Document> collection = mongoUtils.getDatabase().getCollection(model.getIlAdi());
        Gson gson = new Gson();
        String jsonModel = gson.toJson(model);

        Document doc = Document.parse(jsonModel);
        collection.insertOne(doc);
    }

    public void insertMongoDBCollectionData(){
        List<Cumhurbaskanligi2014SecimiIlModeli> cumhurbaskanligi2014SecimiIlModeliList;
        String folderPath = "/home/ibrahim/Documents/cumhurbaskanligi/bütün iller/";
        FileUtil fileUtil = new FileUtil();
        List<String> cumhurbaskanligiSecimi2018FileNameList = fileUtil.getFileNames(folderPath);
        CumhurbaskanligiExcelUtils cbExcelUtils = new CumhurbaskanligiExcelUtils();
        for (String filename: cumhurbaskanligiSecimi2018FileNameList) {
            cumhurbaskanligi2014SecimiIlModeliList = new ArrayList<>();
            cumhurbaskanligi2014SecimiIlModeliList = cbExcelUtils.readCumhurbaskanligiExcel(folderPath + filename);
            for (Cumhurbaskanligi2014SecimiIlModeli model: cumhurbaskanligi2014SecimiIlModeliList) {
                setMongoDBCollectionData(model);
            }
        }
    }

    public void getIlSonuc(){
        List<Cumhurbaskanligi2014SecimiIlModeli> cumhurbaskanligi2014SecimiIlModeliList;
        String folderPath = "/home/ibrahim/Documents/cumhurbaskanligi/bütün iller/";
        FileUtil fileUtil = new FileUtil();
        List<String> cumhurbaskanligiSecimi2018FileNameList = fileUtil.getFileNames(folderPath);
        CumhurbaskanligiExcelUtils cbExcelUtils = new CumhurbaskanligiExcelUtils();
        List<Cumhurbaskanligi2014SecimiIlModeli> ilSonuclist = new ArrayList<>();
        int ilId = 0;
        int ilRTEOy=0;
        int ilEMIOy=0;
        int ilSDOy=0;
        for (String filename: cumhurbaskanligiSecimi2018FileNameList) {
            cumhurbaskanligi2014SecimiIlModeliList = cbExcelUtils.readCumhurbaskanligiExcel(folderPath + filename);
            for (Cumhurbaskanligi2014SecimiIlModeli model: cumhurbaskanligi2014SecimiIlModeliList) {
                if(ilId == model.getIlId()){
                    ilRTEOy += model.getRecepTayyipErdoganOy();
                    ilEMIOy += model.getEkmeleddinIhsanogluOy();
                    ilSDOy += model.getSelahattiDemirtasOy();
                }else {
                    ilId = model.getIlId();
                    ilRTEOy = model.getRecepTayyipErdoganOy();
                    ilEMIOy = model.getEkmeleddinIhsanogluOy();
                    ilSDOy = model.getSelahattiDemirtasOy();
                }
            }
            Cumhurbaskanligi2014SecimiIlModeli cmodel = new Cumhurbaskanligi2014SecimiIlModeli();
            cmodel.setRecepTayyipErdoganOy(ilRTEOy);
            cmodel.setEkmeleddinIhsanogluOy(ilEMIOy);
            cmodel.setSelahattiDemirtasOy(ilSDOy);
            cmodel.setIlId(ilId);
            ilSonuclist.add(cmodel);
        }
        for (Cumhurbaskanligi2014SecimiIlModeli ilModel : ilSonuclist) {
            System.out.println(ilModel);
        }
    }

}
