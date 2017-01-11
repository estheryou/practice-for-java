import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FourthRatings {
    
    private double getAverageByID(String id,int minimalRaters){
       double average = 0;
    	double sum = 0;
    	int countRaters = 0;
    	ArrayList<Rater> myRaters=RaterDatabase.getRaters();
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
    
    private double dotProduct(Rater me, Rater r){
      double product=0.0;
      ArrayList<String> merated=me.getItemsRated();
      for(String id:merated){
          if(r.hasRating(id)){
            double ratedbyr=r.getRating(id);
            double ratedbyme=me.getRating(id);
            ratedbyr=ratedbyr-5;
            ratedbyme=ratedbyme-5;
            product+=ratedbyr*ratedbyme;
            }
        }
      return product;
    }
    private ArrayList<Rating> getSimilarities(String id){
      ArrayList<Rating> ratersalike=new ArrayList<Rating>();
      ArrayList<Rater>  myRaters=RaterDatabase.getRaters();
      Rater me = RaterDatabase.getRater(id);
      for(Rater rater:myRaters){
        if(!rater.equals(me)){
          double similarity=dotProduct(me,rater);
          if(similarity>0){
           Rating therater= new Rating(rater.getID(),similarity);
           ratersalike.add(therater);
           }
         }
        }
       Collections.sort(ratersalike, Collections.reverseOrder());
       return ratersalike;
    } 
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters,int minimalRaters){
      ArrayList<Rating>  weighted= new ArrayList<Rating>();   
      ArrayList<Rating>  similar= getSimilarities(id);
      ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());	
      for(String movie:movies){
        double weightedrate=0.0;
        int count=0;
        double sum=0.0;
         for(int i = 0; i < numSimilarRaters; i++){
            Rating rater=similar.get(i);
            String raterid=rater.getItem();
            double raterweight=rater.getValue();
            Rater myRater = RaterDatabase.getRater(raterid);
            if(myRater.hasRating(movie)){
                count++;
                sum+=raterweight*myRater.getRating(movie);
            }
            
            
            }
         if(count>=minimalRaters){
            weightedrate=sum/count;
            weighted.add(new Rating(movie,weightedrate));
            
            }
        
        }
      Collections.sort(weighted, Collections.reverseOrder());
      return weighted;
    }
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
    ArrayList<Rating>  weighted= new ArrayList<Rating>();   
      ArrayList<Rating>  similar= getSimilarities(id);
      ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);	
      for(String movie:movies){
        double weightedrate=0.0;
        int count=0;
        double sum=0.0;
         for(int i = 0; i < numSimilarRaters-1; i++){
            Rating rater=similar.get(i);
            String raterid=rater.getItem();
            double raterweight=rater.getValue();
            Rater myRater = RaterDatabase.getRater(raterid);
            if(myRater.hasRating(movie)){
                count+=1;
                sum+=raterweight*myRater.getRating(movie);
            }
            
            
            }
         if(count>=minimalRaters){
             double value=sum/count;
            weighted.add(new Rating(movie,value));
            
            }
        
        }
      Collections.sort(weighted, Collections.reverseOrder());
      return weighted;
    
    }
    
    public ArrayList<Rating> getRecommendations(String id, int numRaters) {
    	ArrayList<Rating> list = getSimilarities(id);
    	ArrayList<Rating> res = new ArrayList<Rating>();
    	ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
    	for(String movieID: movies) {
        	double weightedAverage = 0;
        	double sum = 0;
        	int countRaters = 0;
    		for(int k=0; k < numRaters; k++) {
    			Rating r = list.get(k);
    			String raterID = r.getItem();
    			double weight = r.getValue();
    			Rater myRater = RaterDatabase.getRater(raterID);
    			if(myRater.hasRating(movieID)) {
    				countRaters++;
    				sum += weight * myRater.getRating(movieID);
    			}
    		}
    		weightedAverage = sum / countRaters;
    		res.add(new Rating(movieID, weightedAverage));
    	}
	
		return res;
    }
}
    
