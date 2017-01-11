import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdRatings {
    
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    public ThirdRatings(String ratingsfile) {
         FirstRatings newrate=new FirstRatings();
         //myMovies=newrate.loadMovies(moviefile);
         myRaters=newrate.loadRaters(ratingsfile);
    }
    
    public int getRaterSize(){
      int i= myRaters.size();
      return i;
    }
    private double getAverageByID(String id,int minimalRaters){
       double average = 0;
    	double sum = 0;
    	int countRaters = 0;
    	for(Rater r: myRaters) {
    		if(r.hasRating(id)) {
    			countRaters++;  
    			sum += r.getRating(id);
    		}
    	}
    	if(countRaters >= minimalRaters)
    		average = sum / countRaters;
    	return average;
    }
    /*private HashMap<String,ArrayList<Double>> get_movie_with_raters(){
      HashMap<String,ArrayList<Double>> movie_rated=new HashMap<String,ArrayList<Double>>();
      for(Rater rater:myRaters){
          HashMap<String,Rating> ratings=rater.getRating();
          for( String key:ratings.keySet()){
          String movie_id=key;
          double movie_id_rated=ratings.get(key).getValue();
          if(movie_rated.containsKey(movie_id)){
              movie_rated.get(movie_id).add(movie_id_rated);
            }
          else {
             ArrayList<Double> rates=new ArrayList<Double>();
             rates.add(movie_id_rated);
             movie_rated.put(movie_id,rates);
            }
        }
      }
      return movie_rated;
    }*/
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
      ArrayList<Rating>  avgrate=new ArrayList<Rating>();
      //HashMap<String,ArrayList<Double>> movies=get_movie_with_raters();
      ArrayList<String> movies=MovieDatabase.filterBy(new TrueFilter());
      for(String mvid:movies){
       double rates_for_this_one=getAverageByID(mvid,minimalRaters);
       if(!(rates_for_this_one==0.0)){
        Rating this_one=new Rating(mvid,rates_for_this_one);
        avgrate.add(this_one);
        }
       }
       return avgrate;
    }
    /*public void sortgetAverageRatings(){
     int size=avgrate.size();
     for(int i=0;i<size;i++){
      for(int j=i;j<size-i-1;j++){
       if(avgrate.get(j).getValue()>avgrate.get(j+1).getValue()){
        Rating temp1=avgrate.get(j);
        Rating temp2=avgrate.get(j+1);
        avgrate.set(j,temp2);
        avgrate.set(j+1,temp1);
        }  
        
       }
     }
    
    }*/
    /*public String getTitle(String id){
        String x=new String();
      for(int i=0;i<myMovies.size();i++){
        // System.out.println("the one is "+movie.getID());
         if(id.equals(myMovies.get(i).getID())){
          x=myMovies.get(i).getTitle();
          break;      
        }
        if(!id.equals(myMovies.get(i).getID())){
          x= "the movie with this id is not found~";
        } 
       }
       return x;
    }*/
    /*public String getID(String title){
      String ID=new String();
      for(int i=0;i<myMovies.size();i++){
        // System.out.println("the one is "+movie.getID());
         if(title.toLowerCase().equals(myMovies.get(i).getTitle().toLowerCase())){
          ID=myMovies.get(i).getID();
          break;      
        }
        else{
          ID= "no such title";
        } 
       }
       return ID;
      
    }*/
    //helper method
    public ArrayList<Rating> getAverageRatingByFilter(int minimalRaters , Filter filterCriteria){
     ArrayList<Rating> moviedesired= new ArrayList<Rating>();
     ArrayList<String> moviefiltered= MovieDatabase.filterBy(filterCriteria);
      for(String mvid:moviefiltered){
       double rates_for_this_one=getAverageByID(mvid,minimalRaters);
       if(!(rates_for_this_one==0.0)){
        Rating this_one=new Rating(mvid,rates_for_this_one);
        moviedesired.add(this_one);
        }
       }
       return moviedesired;    
    }
}
    
