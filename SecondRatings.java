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
public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String moviefile,String ratingsfile) {
         FirstRatings newrate=new FirstRatings();
         myMovies=newrate.loadMovies(moviefile);
         myRaters=newrate.loadRaters(ratingsfile);
    }
    public int  getMovieSize(){
      int i= myMovies.size();
      return i;
    }
    public int getRaterSize(){
      int i= myRaters.size();
      return i;
    }
    private double getAverageByID(String id,int minimalRaters){
       HashMap<String,ArrayList<Double>> movies=get_movie_with_raters();
       double avgrates=0;
       int size=movies.get(id).size();
       double sum=0;
       if(size>=minimalRaters){
          ArrayList<Double> rates=movies.get(id);
          
          for(Double rate_for_id: rates){
            sum+=rate_for_id; 
            
            }
          avgrates=sum/size;
        }
        else{
           avgrates=0.0;
        }
        return avgrates;
    
    }
    private HashMap<String,ArrayList<Double>> get_movie_with_raters(){
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
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
      ArrayList<Rating>  avgrate=new ArrayList<Rating>();
      HashMap<String,ArrayList<Double>> movies=get_movie_with_raters();
      for(String mvid:movies.keySet()){
       int size=movies.get(mvid).size();
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
    public String getTitle(String id){
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
    }
    public String getID(String title){
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
      
    }
}
    
