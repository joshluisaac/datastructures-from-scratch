package common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

public interface IExcelExporter<T> {

  void export(Collection<T> data, OutputStream outputStream, String sheetName)
      throws IOException;

  InputStream export(Collection<T> data, String sheetName) throws IOException;
}
