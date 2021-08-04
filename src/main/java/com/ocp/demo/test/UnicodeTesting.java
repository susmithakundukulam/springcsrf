package com.ocp.demo.test;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;

public class UnicodeTesting {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
			
        String path = "D:\\test\\input.html";        
        String outPath = "D:\\test\\output.pdf";
        String fontPath1 = "/font/Manjari-Regular.otf";
       // String fontPath2 = "/font/KARTIKAB.TTF";
        File htmlSource = new File(path);
        FontProvider font = new FontProvider();
        font.addFont(fontPath1);  
        //font.addFont(fontPath2);
        File pdfDest = new File(outPath);
        System.out.println("");

        
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
        //converterProperties.setCharset("UTF-8");
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
       new FileOutputStream(pdfDest), converterProperties);
	
	}
	

   

}
