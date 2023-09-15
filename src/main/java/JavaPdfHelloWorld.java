
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class JavaPdfHelloWorld {
    public static void main(String[] args) {
        Document document = new Document();

        // -START- Inicializacia spravneho fontu
        BaseFont baseFont = null;

        try {
            baseFont = BaseFont.createFont("ARIAL.TTF",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
            Font font=new Font(baseFont, 12);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("A Hello World PDF document loveäú+ľšľ+čťžťčýáíéýô).",font));
            document.add(new Paragraph("Auto je cervene, nebo modre",font));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            System.out.println("Problem pri generovani dokumentu");
        } catch (FileNotFoundException e) {
            System.out.println("Problem pri vytvarani suboru");
        } catch (IOException e) {
            System.out.println("Neznama chyba na vstupe/vystupe");
        }
    }
}