package utilites;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SpreedSheet {

    private File sheet;
    private Sheet currentsheet;
    private Map<String, Integer> columns;



    public SpreedSheet(File file){

        sheet = file;
        columns = new HashMap();

    }

    public void switchToSheets(String name){
       try (var workbooks = WorkbookFactory.create(sheet)){
           currentsheet =workbooks.getSheet(name);
           currentsheet.getRow(0).forEach(cell -> {
               columns.put(cell.getStringCellValue(), cell.getColumnIndex());
           });
           System.out.println(columns);

       }catch (Exception e){
           e.printStackTrace();
       }


    }

    public String GetCellData(String column, int row){
       var dataRow =  currentsheet.getRow(row);
       return getCellDataAsString(dataRow.getCell(columns.get(column)));
    }

    private String getCellDataAsString(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
            default -> "";
        };

    }

}
