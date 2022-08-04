import java.util.ArrayList;

/**
 * @author 21010539
 *
 */
public class Category {

	private String Cname;
	private ArrayList<CCA> ccaList;
	
	public Category(String Cname, ArrayList<CCA> ccaList) {
		this.Cname = Cname;
		this.ccaList = ccaList;
	}

	public ArrayList<CCA> getCcaList() {
		return ccaList;
	}

	public void setCcaList(ArrayList<CCA> ccaList) {
		this.ccaList = ccaList;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}
	
}
