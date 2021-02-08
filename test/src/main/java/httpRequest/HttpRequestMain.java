package httpRequest;

import httpRequest.apacheHttpClient.FileUtils;
import httpRequest.apacheHttpClient.HttpClientExample1_1;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpRequestMain {

    private static HttpClientExample1_1 httpClientExample = new HttpClientExample1_1();
    private static FileUtils fileUtils = new FileUtils();
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        getSecim2018Cumhurbaskanligi();
    }

    private static void getSecim2014Cumhurbaskanligi(){
        int plaka= 1;
        while(plaka<82) {
            //do your job...
            String url = "https://sonuc.ysk.gov.tr/api/getSecimSandikSonucList?secimId=40122&secimTuru=9&ilceId=&beldeId=&birimId=&muhtarlikId=&cezaeviId=&sandikTuru=&sandikNoIlk=&sandikNoSon=&ulkeId=&disTemsilcilikId=&gumrukId=&yurtIciDisi=1&sandikRumuzIlk=&sandikRumuzSon=&secimCevresiId=258209&sandikId=&sorguTuru=2&ilId="+plaka;
            plaka++;
            try {
                String result = httpClientExample.sendGet(url);
                fileUtils.createAndWriteFile(result);
                fileUtils.createAndWriteFileByPureMOdel(result);
                Thread.sleep( 15000);
            } catch (InterruptedException | IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getSecim2018Cumhurbaskanligi(){
        int plaka= 32;
        while(plaka<82) {
            //do your job...
            String url = "https://sonuc.ysk.gov.tr/api/getSecimSandikSonucList?secimId=49002&secimTuru=9&ilceId=&beldeId=&birimId=&muhtarlikId=&cezaeviId=&sandikTuru=&sandikNoIlk=&sandikNoSon=&ulkeId=&disTemsilcilikId=&gumrukId=&yurtIciDisi=1&sandikRumuzIlk=&sandikRumuzSon=&secimCevresiId=271600&sandikId=&sorguTuru=2&ilId="+plaka;
            plaka++;
            try {
                String result = httpClientExample.sendGet(url);
                fileUtils.createAndWriteFile(result);
                fileUtils.createAndWriteFileByPureMOdel(result);
                Thread.sleep( 15000);
            } catch (InterruptedException | IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }
        }
    }
}
