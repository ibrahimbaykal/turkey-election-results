package httpRequest.apacheHttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import excel.model.Cumhurbaskanligi2014SecimiIlModeli;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    final static Logger logger = Logger.getLogger(FileUtils.class);

    public void createAndWriteFile(String result){
        JsonArray convertedArray = new Gson().fromJson(result, JsonArray.class);
        JsonObject jsonObject = convertedArray.get(0).getAsJsonObject();
        String ilAdi = jsonObject.get("il_ADI").toString().toLowerCase().replace("\"","");

        String filePath = "/home/ibrahim/Documents/2018/normal/";
        String fileName = filePath+ilAdi+"_cumhurbaskanligiSecimSonuc2018.json";
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(result);
                myWriter.close();
                System.out.println(ilAdi + " ili sonuları tamamlandı");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void createAndWriteFileByPureMOdel(String result){
        JsonArray convertedArray = new Gson().fromJson(result, JsonArray.class);
        JsonObject jsonObject2 = convertedArray.get(0).getAsJsonObject();
        String ilAdi = jsonObject2.get("il_ADI").toString().toLowerCase().replace("\"","");

        List<String> modelList = new ArrayList<>();
        Gson gson = new Gson();
        for (JsonElement element: convertedArray) {

            JsonObject jsonObject = element.getAsJsonObject();
            // For Pure Model
            int mIOy = Integer.parseInt(jsonObject.get("bagimsiz1_ALDIGI_OY").toString());
            int mAOy = Integer.parseInt(jsonObject.get("bagimsiz2_ALDIGI_OY").toString());
            int rTEOy = Integer.parseInt(jsonObject.get("bagimsiz3_ALDIGI_OY").toString());

            //2018 extend
            int sDOy = Integer.parseInt(jsonObject.get("bagimsiz4_ALDIGI_OY").toString());
            int tkOy = Integer.parseInt(jsonObject.get("bagimsiz5_ALDIGI_OY").toString());
            int dPOy = Integer.parseInt(jsonObject.get("bagimsiz6_ALDIGI_OY").toString());

            int secmenSayisi = Integer.parseInt(jsonObject.get("secmen_SAYISI").toString());
            int gecersiz_OY_TOPLAMI = Integer.parseInt(jsonObject.get("gecersiz_OY_TOPLAMI").toString());
            int itirazsiz_GECERLI_OY_SAYISI = Integer.parseInt(jsonObject.get("itirazsiz_GECERLI_OY_SAYISI").toString());
            int gecerli_OY_TOPLAMI = Integer.parseInt(jsonObject.get("gecerli_OY_TOPLAMI").toString());
            int itirazli_GECERLI_OY_SAYISI = Integer.parseInt(jsonObject.get("itirazli_GECERLI_OY_SAYISI").toString());
            int secim_ID = Integer.parseInt(jsonObject.get("secim_ID").toString());
            int oy_KULLANAN_SECMEN_SAYISI = Integer.parseInt(jsonObject.get("oy_KULLANAN_SECMEN_SAYISI").toString());
            int il_ID = Integer.parseInt(jsonObject.get("il_ID").toString());
            String il_ADI = jsonObject.get("il_ADI").toString().replace("\"","");
            int ilce_ID = Integer.parseInt(jsonObject.get("ilce_ID").toString());
            String ilce_ADI = jsonObject.get("ilce_ADI").toString().replace("\"","");;
            String son_ISLEM_TARIHI = jsonObject.get("son_ISLEM_TARIHI").toString().replace("\"","");;

            Cumhurbaskanligi2014SecimiIlModeli model = new Cumhurbaskanligi2014SecimiIlModeli();
            model.setRecepTayyipErdoganOy(rTEOy);
            model.setSelahattiDemirtasOy(sDOy);
            model.setMuharremInceOy(mIOy);
            model.setMeralAksenerOy(mAOy);
            model.setDoguPerincekOy(dPOy);
            model.setTemelKaramollaogluOy(tkOy);

            model.setSecmenSayisi(secmenSayisi);
            model.setGecersizOyToplami(gecersiz_OY_TOPLAMI);
            model.setItirazsizGecerliOySayisi(itirazsiz_GECERLI_OY_SAYISI);
            model.setItirazliGecerliOySayisi(itirazli_GECERLI_OY_SAYISI);
            model.setGecerliOyToplami(gecerli_OY_TOPLAMI);
            model.setSecimId(secim_ID);
            model.setOyKullananSecmenSayisi(oy_KULLANAN_SECMEN_SAYISI);
            model.setIlId(il_ID);
            model.setIlAdi(il_ADI);
            model.setIlceId(ilce_ID);
            model.setIlceAdi(ilce_ADI);
            model.setSonIslemTarihi(son_ISLEM_TARIHI);

            String jsonModel = gson.toJson(model);
            modelList.add(jsonModel);
        }

//        JsonArray convertedArray2 = new Gson().fromJson(String.valueOf(modelList), JsonArray.class);

        String filePath = "/home/ibrahim/Documents/2018/puremodel/";
        String fileName = filePath+ilAdi+"_cumhurbaskanligiSecimSonuc2018_pure.json";
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(String.valueOf(modelList));
                myWriter.close();
                logger.info("This is info : " + ilAdi+" is succesfull complete");
            } else {
                logger.info("File already exists.");
            }
        } catch (IOException e) {
            logger.info("An error occurred.");
            e.printStackTrace();
        }
    }
}
