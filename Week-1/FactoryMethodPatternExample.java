interface Document {
    public void open();   
    public void close(); 
}

class WordDocument implements Document{
    public void open(){
        System.out.println("Opening the Word document");
    }
    public void close(){
        System.out.println("Closing the Word document");
    }
}

class PdfDocument implements Document{
    public void open(){
        System.out.println("Opening the Pdf document");
    }
    public void close(){
        System.out.println("Closing the Pdf document");
    }
}

class ExcelDocument implements Document{
    public void open(){
        System.out.println("Opening the Excel document");
    }
    public void close(){
        System.out.println("Closing the Excel document");
    }
}

abstract class DocumentFactory{
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating a Word document");
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating a Pdf document");
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        System.out.println("Creating an Excel document");
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args){

        WordDocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();
        System.out.println();

        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();
        System.out.println();

        ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}

