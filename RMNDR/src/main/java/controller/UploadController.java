package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import services.TrReportServicesImpl;
import entities.TrReports;

/**
 * @author Nana Febriana
 */

@Controller
public class UploadController {
	
	@Autowired
	TrReportServicesImpl trReportsDAO;

	@RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView singleFileUpload(
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Please select a file to upload");
			return new ModelAndView("upload", "message", "Please select a file to upload");
		} else if (!file.isEmpty()) {
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			System.out.println(" ekstensi " + ext);
			if ( ext.equals("xlsx") || ext.equalsIgnoreCase("xlsx") ||
				 ext.equals("xls") || ext.equalsIgnoreCase("xls") ){								
					try {		
						// Get the file and save it somewhere
						byte[] bytes = file.getBytes();
						Path path = Paths.get("C://temp//" + file.getOriginalFilename());
						Files.write(path, bytes);
						
						/* Save File */
//						FilesUpload fileUpload = new FilesUpload();
//						FilesUploadDAO filesUploadDAO = new FilesUploadDAO();
//						fileUpload.setFileName(file.getOriginalFilename());
//						filesUploadDAO.insertFile(fileUpload);
						
						String FILE_NAME = path.toString();
						System.out.println(FILE_NAME);
						parsingFileXlsx(FILE_NAME);
						redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename()+ "'");
					} catch (IOException e) {
						redirectAttributes.addFlashAttribute("message","Failure occured during upload '"+ file.getOriginalFilename() + "'");
						e.printStackTrace();
					}
				} else {
					return new ModelAndView("upload", "message","file not xls.");
				}
		}
		return new ModelAndView("upload", "message","You successfully uploaded '" + file.getOriginalFilename()+ "'");
	}
	
	public void parsingFileXlsx(String FILE_NAME){
		try {
			TrReports trReports = new TrReports();
			List<TrReports> listTrReports = new ArrayList<TrReports>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row header = iterator.next(); // Move 2 Line
            Row header2 = iterator.next(); // Move 2 Line
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();                                  
                    int columnIndex = currentCell.getColumnIndex();
                    System.out.println( "coloumn index "  + columnIndex);   
                    switch (columnIndex) {
                    	case 0:
                    		if (currentCell.getStringCellValue() != null){
	                    		System.out.println("0. Customer " + currentCell.getStringCellValue());
	                    		trReports.setCustomer(currentCell.getStringCellValue());                    
                    		}
                    		break;
                    	case 1:	
                    		if ( currentCell.getStringCellValue() != null ){ 
	                    		System.out.println("1. Project " + currentCell.getStringCellValue());
	                    		trReports.setProject(currentCell.getStringCellValue());                    	
                    		}
                    		break;
                    	case 2:
                    		if ( currentCell.getStringCellValue() != null ){
	                    		System.out.println("2. Remarks " + currentCell.getStringCellValue());
	                    		trReports.setRemarks(currentCell.getStringCellValue());                    		
                    		}
                    		break;
                    	case 3:	
                    		if (currentCell.getStringCellValue() != null){
	                    		System.out.println("3. NoPo " + currentCell.getStringCellValue());
	                    		trReports.setNoPo(currentCell.getStringCellValue());                    		
                    		}
                    		break;
                    	case 4:	
                    		if ( currentCell.getStringCellValue() != null ){
	                    		System.out.println("4. Marketing " + currentCell.getStringCellValue());
	                    		trReports.setMarketing(currentCell.getStringCellValue());                    		
                    		}
                    		break;
                    	case 5:	
                    		if ( currentCell.getStringCellValue() != null ){
	                    		System.out.println("5. NoInvoice " + currentCell.getStringCellValue());
	                    		trReports.setNoInvoice(currentCell.getStringCellValue());                    		
                    		}
                    		break;
                    	case 6:	                    		
                    		if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    			System.out.println("6. NomorPajak " + currentCell.getStringCellValue());
        						trReports.setNomorPajak(currentCell.getStringCellValue());    
        					} 
                    		break;
                    	case 7:	
                    		if (currentCell.getDateCellValue() != null){
	                    		System.out.println("7. TanggalInvoice " + dateFormat.format(currentCell.getDateCellValue()));
	                    		dateFormat = new SimpleDateFormat("dd-MM-yyyy");                    		
	                    		trReports.setTanggalInvoice(currentCell.getDateCellValue());                    		
                    		}
                    		break;
                    	case 8:	
                    		if (currentCell.getDateCellValue() != null){
	                    		System.out.println("8. TanggalTt " + dateFormat.format(currentCell.getDateCellValue()));
	                    		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	                    		trReports.setTanggalTt(currentCell.getDateCellValue());                    		
                    		}
                    		break;
                    	case 9:	
                    		if (currentCell.getNumericCellValue() != 0  ) {
	                    		System.out.println("9. Term " + currentCell.getNumericCellValue());
	                    		trReports.setTerm(doubleToInt(currentCell.getNumericCellValue()));                    		
                    		}
                    		break;
                    	case 10:
                    		if ( currentCell.getDateCellValue() != null ){
	                    		System.out.println("10. TanggalJthTempo " + dateFormat.format(currentCell.getDateCellValue()));
	                    		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	                    		trReports.setTanggalJthTempo(currentCell.getDateCellValue());                    	
                    		}
                    		break;
                    	case 11:
                    		if ( currentCell.getNumericCellValue() != 0  ) {
	                    		System.out.println("11. PiutangUsaha " + currentCell.getNumericCellValue());
	                    		trReports.setPiutangUsaha(doubleToLong(currentCell.getNumericCellValue()));                    		
                    		}
                    		break;
                    	case 12:	
                    		if ( currentCell.getNumericCellValue() != 0  ) {
	                    		System.out.println("12. Dpp " + currentCell.getNumericCellValue());
	                    		trReports.setDpp(doubleToLong(currentCell.getNumericCellValue()));   
                    		}
                    		break;
                    	case 13:	
                    		if ( currentCell.getNumericCellValue() != 0  ) {
	                    		System.out.println("13. Ppn " + currentCell.getNumericCellValue());
	                    		trReports.setPpn(doubleToLong(currentCell.getNumericCellValue()));
                    		}
                    		break;
                    	case 14:	
                    		if ( currentCell.getNumericCellValue() != 0  ) {
	                    		System.out.println("14. Pph " + currentCell.getNumericCellValue());
	                    		trReports.setPph(doubleToLong(currentCell.getNumericCellValue()));                    		
                    		}
                    		break;
                    	case 15:	
                    		if (doubleToLong(currentCell.getNumericCellValue()) != 0) {
	                    		System.out.println("15. UangMasuk " + currentCell.getNumericCellValue());
	                    		trReports.setUangMasuk(doubleToLong(currentCell.getNumericCellValue()));                    
                    		}
                    		break;
                    }                    
                }
                trReportsDAO.insertTrReport(trReports);         
                System.out.println("----------------------------------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public long doubleToLong(double value){
		long values = (long) value;
		return values;
	}
	
	public int doubleToInt(double value){
		Double d = new Double(value);
		int values = d.intValue();
		return values;
	}
	
}