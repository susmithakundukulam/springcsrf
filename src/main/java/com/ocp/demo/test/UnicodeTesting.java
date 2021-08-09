package com.ocp.demo.test;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramDescriptor;
import com.itextpdf.io.font.FontProgramDescriptorFactory;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.licensekey.LicenseKey;


public class UnicodeTesting {
	public static final String FONTS = "./src/main/resources/font/";
	public static final String[] FONTSARR = {
			
			"/font/NotoSansMalayalam-Regular.ttf",
			"/font/NotoSans-Regular.ttf",
			"/font/NotoSansDevanagari-Regular.ttf",
			"/font/NotoSansTamil-Regular.ttf"
			
	};
	
	public static final String DEST = "D:\\test\\output.pdf";
    public static final String ITEXT7_LICENSEKEY= "D:\\test\\eula\\itextkey1628182831903_0.xml";
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
//        LicenseKey.loadLicenseFile(ITEXT7_LICENSEKEY);
//        File file = new File(DEST);
//    	file.getParentFile().mkdirs();   
    	
    	
        String path = "D:\\test\\inputhead.html";        
        String outPath = "D:\\test\\output.pdf";

        int count =1;
              
        File htmlSource = new File(path);

        FontProvider font = new DefaultFontProvider(false,false,false);
        //font.addDirectory(FONTS);
        
        for(String fontstr: FONTSARR) {
        	FontProgram fontProgram = FontProgramFactory.createFont(fontstr);
        	font.addFont(fontProgram);
        	System.out.println("count : "+count++);
        }
        
        
        File pdfDest = new File(outPath);

        
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
        System.out.println(content); 
        
    
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(font);
        converterProperties.setCharset("UTF-8");
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
       new FileOutputStream(pdfDest), converterProperties);
        
//        
		
//		String path = "D:\\test\\input.html";        
//        String outPath = "D:\\test\\output.pdf";
//        String fontPath1 = "/font/Manjari-Regular.otf";
//        
//        PdfWriter writer = new PdfWriter(outPath);
//        PdfDocument pdfDocument = new PdfDocument(writer);
//        Document document = new Document(pdfDocument);
//        
//        
//        PdfFont rachana = PdfFontFactory.createFont(fontPath1);
//        
//        StringBuilder contentBuilder = new StringBuilder();
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(path));
//            String str;
//            while ((str = in.readLine()) != null) {
//                contentBuilder.append(str);
//            }
//            in.close();
//        } catch (IOException e) {
//        }
//        String content = contentBuilder.toString();
//        System.out.println(content); 
//        
//        
//        Text text = new Text(content).setFont(rachana);
//        
//        Paragraph paragraph = new Paragraph()
//        		.add(text);
//        
//        document.add(paragraph);
//        
//        
//        document.close();
		

	
	}
	

   

}
