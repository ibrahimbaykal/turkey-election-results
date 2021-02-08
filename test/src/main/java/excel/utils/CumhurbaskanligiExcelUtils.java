package excel.utils;

import excel.model.Cumhurbaskanligi2014SecimiIlModeli;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CumhurbaskanligiExcelUtils {
    public List<Cumhurbaskanligi2014SecimiIlModeli> readCumhurbaskanligiExcel(String path){
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(path)); //"/home/ibrahim/Documents/sspsCumhurbaskani-6-21-04-2015_16-46.normal.xls"
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Sheet currentSheet;
        List<Cumhurbaskanligi2014SecimiIlModeli> ilSonucList = new ArrayList<>();
        try(Workbook workbooks = WorkbookFactory.create(file)){
            currentSheet = workbooks.getSheetAt(0);
            Iterator<Row> rowIterator = currentSheet.rowIterator();
            int rowindex =2;
            while (rowIterator.hasNext()){
                Row row = currentSheet.getRow(rowindex);
                if(row == null)
                    break;
                rowindex++;
                int ilId =  Integer.parseInt(row.getCell(0).getStringCellValue());
                int ilceId = Integer.parseInt(row.getCell(1).getStringCellValue());
                String ilAdi = row.getCell(2).getStringCellValue();
                String ilceAdi = row.getCell(3).getStringCellValue();
                int rteOy = Integer.parseInt(row.getCell(4).getStringCellValue().replace(".",""));
                int sdOy = Integer.parseInt(row.getCell(5).getStringCellValue().replace(".",""));
                int emiOy = Integer.parseInt(row.getCell(6).getStringCellValue().replace(".",""));

                Cumhurbaskanligi2014SecimiIlModeli ilSonuc = new Cumhurbaskanligi2014SecimiIlModeli();
                ilSonuc.setIlId(ilId);
                ilSonuc.setIlceId(ilceId);
                ilSonuc.setIlAdi(ilAdi);
                ilSonuc.setIlceAdi(ilceAdi);
                ilSonuc.setRecepTayyipErdoganOy(rteOy);
                ilSonuc.setSelahattiDemirtasOy(sdOy);
                ilSonuc.setEkmeleddinIhsanogluOy(emiOy);

                ilSonucList.add(ilSonuc);
            }
//            for (CumhurbaskanligiSecimiIlModeli item:ilSonucList ) {
//                System.out.println(item.toString());
//            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ilSonucList;
    }
}
