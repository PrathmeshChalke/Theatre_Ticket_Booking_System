package theatreOperations;

import java.util.HashMap;

public class Show {

	String showName;
	static HashMap<Integer ,String >morning=new HashMap<>(50);
	static HashMap<Integer ,String >afternoon=new HashMap<>(50);
	static HashMap<Integer ,String >evening=new HashMap<>(50);
	static HashMap<Integer ,String >night=new HashMap<>(50);
	
	/**
	 * @return the showName
	 */
	
	public Show(HashMap<Integer ,String >morning,HashMap<Integer ,String >afternoon,HashMap<Integer ,String >evening,HashMap<Integer ,String >night) {
     this.morning=morning;
     this.afternoon=afternoon;
     this.evening=evening;
     this.night=night ;
     

	}
	
	
	public Show() {
		
	}
	public String getShowName() {
		return showName;
	}
	/**
	 * @return the morning
	 */
	public HashMap<Integer, String> getMorning() {
		if(morning.isEmpty()) {
			for(int i=1;i<Screen.CAPACITY+1;i++) {
				morning.put(i, "empty");
			}
		}
		return morning;
	}
	/**
	 * @return the afternoon
	 */
	public HashMap<Integer, String> getAfternoon() {
		if(afternoon.isEmpty()) {
			for(int i=1;i<Screen.CAPACITY+1;i++) {
				afternoon.put(i, "empty");
			}
		}
		return afternoon;
	}
	/**
	 * @return the evening
	 */
	public HashMap<Integer, String> getEvening() {
		if(evening.isEmpty()) {
			for(int i=1;i<Screen.CAPACITY+1;i++) {
				evening.put(i, "empty");
			}
		}
		return evening;
	}
	/**
	 * @return the night
	 */
	public HashMap<Integer, String> getNight() {
		if(night.isEmpty()) {
			for(int i=1;i<Screen.CAPACITY+1;i++) {
				night.put(i, "empty");
			}
		}
		return night;
	}
	
}
