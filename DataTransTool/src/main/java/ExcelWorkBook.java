import java.util.List;

public class ExcelWorkBook {
	private String path;
	private String name;
	List<ExcelSheet> listSheet;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<ExcelSheet> getListSheet() {
		return listSheet;
	}
	public void setListSheet(List<ExcelSheet> listSheet) {
		this.listSheet = listSheet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
