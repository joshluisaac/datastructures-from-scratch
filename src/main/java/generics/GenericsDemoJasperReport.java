package generics;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

interface ReportData {}

// this means that the customiser interface uses (has an understanding of) some type T with certain
// constraints.
// whatever T is must either extend ReportData (if it's a class) or implement it (if it's an
// interface).
interface Customiser<T extends ReportData> {

  void customise(T data, String design);
}

class CustomReportData implements ReportData {}

class TestReportData implements ReportData {}

class TestCustomiser implements Customiser<TestReportData> {

  @Override
  public void customise(TestReportData data, String design) {}
}

interface ReportGenerator<T extends ReportData> {

  void generatePdf(T data, OutputStream outputStream);
}

// check this
// class JasperReportGenerator<K extends T, T> implements ReportGenerator<K> {

class JasperReportGenerator<T extends ReportData> implements ReportGenerator<T> {

  @Override
  public void generatePdf(T data, OutputStream outputStream) {}
}

class TransactReportGenerator<T extends ReportData> extends JasperReportGenerator<T> {}

final class TransactReports {
  public static final ReportGenerator<CustomReportData> TEST_REPORT =
      new TransactReportGenerator<>();
}

public class GenericsDemoJasperReport {
  public static void main(String[] args) {
    TransactReports.TEST_REPORT.generatePdf(new CustomReportData(), new ByteArrayOutputStream());
  }
}
