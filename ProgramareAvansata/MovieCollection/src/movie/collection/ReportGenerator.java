/**
 * 
 */
package movie.collection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.examples.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Virgil Barcan
 *
 */
public class ReportGenerator {

	private ArrayList<Movie> moviesSortedByTitle;
	private ArrayList<Movie> moviesSortedByRating;
	private ArrayList<Movie> moviesSortedByReleaseDate;
	
	private static String[] titles = {"ImdbID", "Movie Title", "Movie Rating", "Movie Categories", "Movie Release Date", "Movie Short Description"};
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	
	/**
	 * @param moviesSortedByTitle
	 * @param moviesSortedByRating
	 * @param moviesSortedByReleaseDate
	 */
	public ReportGenerator(ArrayList<Movie> moviesSortedByTitle,
			ArrayList<Movie> moviesSortedByRating,
			ArrayList<Movie> moviesSortedByReleaseDate) {
		super();
		this.moviesSortedByTitle = moviesSortedByTitle;
		this.moviesSortedByRating = moviesSortedByRating;
		this.moviesSortedByReleaseDate = moviesSortedByReleaseDate;
	}



	public void generateReport(String filePath){
		Workbook workbook;
		try {
			FileOutputStream out = new FileOutputStream(filePath);
			
			workbook = new XSSFWorkbook();
			
			Map<String, XSSFCellStyle> styles = createStyles(workbook);
			
			Sheet sheetTitleOrdered = workbook.createSheet("Title Ordered");
			
	        //turn off gridlines
			sheetTitleOrdered.setDisplayGridlines(false);
			sheetTitleOrdered.setPrintGridlines(false);
			sheetTitleOrdered.setFitToPage(true);
			sheetTitleOrdered.setHorizontallyCenter(true);
	        PrintSetup printSetup = sheetTitleOrdered.getPrintSetup();
	        printSetup.setLandscape(true);
	        
	        //the header row: centered text in 48pt font
	        Row headerRow = sheetTitleOrdered.createRow(0);
	        headerRow.setHeightInPoints(12.75f);
	        for (int i = 0; i < titles.length; i++) {
	            Cell cellHeader = headerRow.createCell(i);
	            cellHeader.setCellValue(titles[i]);
	            cellHeader.setCellStyle(styles.get("header"));
	        }

	        Row row;
	        Cell cell;
	        int rownum = 1;
	        
	        for (int i = 0; i < moviesSortedByTitle.size(); ++i){
	        	row = sheetTitleOrdered.createRow(rownum);
	        	
	        	int j = 0;
	        	Cell cellImdbID = row.createCell(j); ++j;
	        	cellImdbID.setCellValue(moviesSortedByTitle.get(i).getImdbID());
	        	Cell cellTitle = row.createCell(j); ++j;
	        	cellTitle.setCellValue(moviesSortedByTitle.get(i).getTitle());
	        	Cell cellRating = row.createCell(j); ++j;
	        	cellRating.setCellValue(moviesSortedByTitle.get(i).getRating());
	        	Cell cellCategories = row.createCell(j); ++j;
	        	cellCategories.setCellValue(moviesSortedByTitle.get(i).getCategoriesAsString());
	        	Cell cellReleaseDate = row.createCell(j); ++j;
	        	cellReleaseDate.setCellValue(moviesSortedByTitle.get(i).getReleaseDate());
	        	Cell cellShortDescription = row.createCell(j); ++j;
	        	cellShortDescription.setCellValue(moviesSortedByTitle.get(i).getShortDescription());
	        	++rownum;
	        	
	        }

	        
			Sheet sheetRatingOrdered = workbook.createSheet("Rating Ordered");
			
	        //turn off gridlines
			sheetRatingOrdered.setDisplayGridlines(false);
			sheetRatingOrdered.setPrintGridlines(false);
			sheetRatingOrdered.setFitToPage(true);
			sheetRatingOrdered.setHorizontallyCenter(true);
	        printSetup = sheetRatingOrdered.getPrintSetup();
	        printSetup.setLandscape(true);
	        
	        //the header row: centered text in 48pt font
	        headerRow = sheetRatingOrdered.createRow(0);
	        headerRow.setHeightInPoints(12.75f);
	        for (int i = 0; i < titles.length; i++) {
	            Cell cellHeader = headerRow.createCell(i);
	            cellHeader.setCellValue(titles[i]);
	            cellHeader.setCellStyle(styles.get("header"));
	        }

	        rownum = 1;
	        
	        for (int i = 0; i < moviesSortedByRating.size(); ++i){
	        	row = sheetRatingOrdered.createRow(rownum);
	        	
	        	int j = 0;
	        	Cell cellImdbID = row.createCell(j); ++j;
	        	cellImdbID.setCellValue(moviesSortedByRating.get(i).getImdbID());
	        	Cell cellTitle = row.createCell(j); ++j;
	        	cellTitle.setCellValue(moviesSortedByRating.get(i).getTitle());
	        	Cell cellRating = row.createCell(j); ++j;
	        	cellRating.setCellValue(moviesSortedByRating.get(i).getRating());
	        	Cell cellCategories = row.createCell(j); ++j;
	        	cellCategories.setCellValue(moviesSortedByRating.get(i).getCategoriesAsString());
	        	Cell cellReleaseDate = row.createCell(j); ++j;
	        	cellReleaseDate.setCellValue(moviesSortedByRating.get(i).getReleaseDate());
	        	Cell cellShortDescription = row.createCell(j); ++j;
	        	cellShortDescription.setCellValue(moviesSortedByRating.get(i).getShortDescription());
	        	++rownum;
	        	
	        }
	        
			Sheet sheetReleaseDateOrdered = workbook.createSheet("Release Date Ordered");
			
	        //turn off gridlines
			sheetReleaseDateOrdered.setDisplayGridlines(false);
			sheetReleaseDateOrdered.setPrintGridlines(false);
			sheetReleaseDateOrdered.setFitToPage(true);
			sheetReleaseDateOrdered.setHorizontallyCenter(true);
	        printSetup = sheetReleaseDateOrdered.getPrintSetup();
	        printSetup.setLandscape(true);
	        
	        //the header row: centered text in 48pt font
	        headerRow = sheetReleaseDateOrdered.createRow(0);
	        headerRow.setHeightInPoints(12.75f);
	        for (int i = 0; i < titles.length; i++) {
	            Cell cellHeader = headerRow.createCell(i);
	            cellHeader.setCellValue(titles[i]);
	            cellHeader.setCellStyle(styles.get("header"));
	        }

	        rownum = 1;
	        
	        for (int i = 0; i < moviesSortedByReleaseDate.size(); ++i){
	        	row = sheetReleaseDateOrdered.createRow(rownum);
	        	
	        	int j = 0;
	        	Cell cellImdbID = row.createCell(j); ++j;
	        	cellImdbID.setCellValue(moviesSortedByReleaseDate.get(i).getImdbID());
	        	Cell cellTitle = row.createCell(j); ++j;
	        	cellTitle.setCellValue(moviesSortedByReleaseDate.get(i).getTitle());
	        	Cell cellRating = row.createCell(j); ++j;
	        	cellRating.setCellValue(moviesSortedByReleaseDate.get(i).getRating());
	        	Cell cellCategories = row.createCell(j); ++j;
	        	cellCategories.setCellValue(moviesSortedByReleaseDate.get(i).getCategoriesAsString());
	        	Cell cellReleaseDate = row.createCell(j); ++j;
	        	cellReleaseDate.setCellValue(moviesSortedByReleaseDate.get(i).getReleaseDate());
	        	Cell cellShortDescription = row.createCell(j); ++j;
	        	cellShortDescription.setCellValue(moviesSortedByReleaseDate.get(i).getShortDescription());
	        	++rownum;
	        	
	        }
	        	        
	        
	        workbook.write(out);
	        out.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
	}
	
	private static Map<String, XSSFCellStyle> createStyles(Workbook wb){
        Map<String, XSSFCellStyle> styles = new HashMap<String, XSSFCellStyle>();
        DataFormat df = wb.createDataFormat();

        XSSFCellStyle style;
        Font headerFont = wb.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("header", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("header_date", style);

        Font font1 = wb.createFont();
        font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setFont(font1);
        styles.put("cell_b", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setFont(font1);
        styles.put("cell_b_centered", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_b_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_g", style);

        Font font2 = wb.createFont();
        font2.setColor(IndexedColors.BLUE.getIndex());
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setFont(font2);
        styles.put("cell_bb", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_bg", style);

        Font font3 = wb.createFont();
        font3.setFontHeightInPoints((short)14);
        font3.setColor(IndexedColors.DARK_BLUE.getIndex());
        font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setFont(font3);
        style.setWrapText(true);
        styles.put("cell_h", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setWrapText(true);
        styles.put("cell_normal", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        styles.put("cell_normal_centered", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style.setWrapText(true);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_normal_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style.setIndention((short)1);
        style.setWrapText(true);
        styles.put("cell_indented", style);

        style = createBorderedStyle(wb);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        styles.put("cell_blue", style);

        return styles;
    }

    private static XSSFCellStyle createBorderedStyle(Workbook wb){
        XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }
	
}
