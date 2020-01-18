package common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelExporterRunner {

  public static void main(String[] args) throws Exception {
    FileOutputStream outputStream = new FileOutputStream(new File("out.xlsx"));
    new ExcelExporter<>().export(List.of(1, 2, 3, 4, 5, 6, 90, 10), outputStream, "");
  }
}
