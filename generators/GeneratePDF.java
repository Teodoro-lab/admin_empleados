package generators;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.Printable;

/**
 * GeneratePDF
 */
public class GeneratePDF {
    private Printable object;
    private String path;

    public GeneratePDF(Printable object, String path) {
        this.object = object;
        this.path = path;
    }

    public void generate() {
        Document doc = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(doc,
                    new FileOutputStream(path));
            doc.open();
            doc.add(new Paragraph(object.infoToPrint()));
            doc.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}