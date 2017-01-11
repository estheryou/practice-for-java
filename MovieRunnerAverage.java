import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
  public void printAverageRatings (){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    SecondRatings ratings=new SecondRatings(moviefile,raterfile);
    int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+movienum+"with ratings: "+raternum);
    
    int minimal=20;
    ArrayList<Rating> avg_rates=ratings.getAverageRatings(minimal);
    
    //ArrayList<Rating> sortedavg_rates=ratings.sortgetAverageRatings(avg_rates);
    int size=avg_rates.size();
    for(int i=0;i<size;i++){
      for(int j=0;j<size-1;j++){
       if((avg_rates.get(j).getValue())>(avg_rates.get(j+1).getValue())){
        Rating temp1=avg_rates.get(j);
        Rating temp2=avg_rates.get(j+1);
        avg_rates.set(j,temp2);
        avg_rates.set(j+1,temp1);
        } 
       }
    }
    for(int q=0;q<5;q++){
     String title=ratings.getTitle(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title);
    
    }
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+ratings.getTitle(avg_rates.get(0).getItem()));
    
  }
  public void getAverageRatingOneMovie(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    SecondRatings ratings=new SecondRatings(moviefile,raterfile);
    int minimal=0;
    ArrayList<Rating> avg_rates=ratings.getAverageRatings(minimal);
    //String title="The Godfather";
    //String title="The Maze Runner";
    String title="Vacation";
    System.out.println("this is a new try");
    for(Rating rating:avg_rates){
      if(title.equals(ratings.getTitle((rating.getItem())))){
        System.out.println(title+"is with average score "+rating.getValue());
        break;
      }
      //else{System.out.println("not found");}
    }
    
    }
}
