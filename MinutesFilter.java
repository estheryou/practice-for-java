
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
	private int minminutes;
	private int maxminutes;
	
	public MinutesFilter(int min,int max) {
		minminutes=min;
		maxminutes=max;
	}
	
	@Override
	public boolean satisfies(String id) {
	    int length=MovieDatabase.getMinutes(id);
		return (length>= minminutes)&&(length<=maxminutes) ;
	}

}


