package common;

public class XlsField {
  private String name;
  private String header;

  public XlsField(String name, String header) {
    this.name = name;
    this.header = header;
  }

  public String getHeader() {
    return header;
  }

  public String getName() {
    return name;
  }
}
