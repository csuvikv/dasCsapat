package hu.szte.rf1.das.csapat.model;

import java.util.List;

import hu.szte.rf1.das.csapat.model.bean.BullShit;

public interface VidaCsardaDAO {
	
	public boolean addBullShit(BullShit bullShit);
	public List<BullShit> listBullShit();
	
}
