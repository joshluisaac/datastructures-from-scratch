package common;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter<T> implements IExcelExporter<T> {

  private final List<XlsField> fields = new ArrayList<>();
  private final int rowPointer = 0;

  @Override
  @SneakyThrows
  public void export(Collection<T> data, OutputStream outputStream, String sheetName) {
    checkFields();
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = createSheet(workbook, sheetName);
    fillHeader(sheet);
    fillContents(sheet, data);
    workbook.write(outputStream);
    workbook.close();
  }

  private void fillHeader(Sheet sheet) {
    Row row = sheet.createRow(rowPointer);
    List<String> headers = fields.stream().map(XlsField::getHeader).collect(Collectors.toList());
    IntStream.range(0, headers.size())
        .forEach(
            i -> {
              Cell cell = row.createCell(i);
              cell.setCellValue(headers.get(i));
            });
  }

  @SneakyThrows
  private void fillContents(Sheet sheet, Collection<T> data) {
    Iterator<T> iterator = data.iterator();
    Row currentRow;
    Row previousRow = null;
    while (iterator.hasNext()) {
      currentRow =
          previousRow != null ? sheet.createRow(previousRow.getRowNum() + 1) : sheet.createRow(1);
      System.out.println(currentRow.getRowNum());
      T t = iterator.next();
      fillCell(t);
      previousRow = currentRow;
    }
  }

  // @SneakyThrows
  private void fillCell(T t) throws IllegalAccessException {
    Field[] declaredFields = t.getClass().getDeclaredFields();
    Arrays.stream(declaredFields)
        .forEach(
            field -> {
              String fieldName = field.getName();
              System.out.println(fieldName);
              System.out.println(field.getType());
              // System.out.println(field.get(t));
              // String methodName = BeanUtils.getm

            });
  }

  public XlsField addField(String name, String header) {
    XlsField xlsField = new XlsField(name, header);
    // fields.add(xlsField);
    return xlsField;
  }

  @Override
  public InputStream export(Collection<T> data, String sheetName) {
    return null;
  }

  private void checkFields() {
    if (fields.isEmpty()) {
      throw new IllegalArgumentException(
          String.format("Fields undefined. %n You haven't specified the field(s) to be exported."));
    }
  }

  private Sheet createSheet(Workbook workbook, String sheetName) {
    return workbook.createSheet(sheetName);
  }
}
