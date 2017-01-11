import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {
  public void printAverageRatings (){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmovies_short.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings_short.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    int minimal=1;
    ArrayList<Rating> avg_rates=ratings.getAverageRatings(minimal);
    int size=avg_rates.size();
    System.out.println("found"+size+"movies");
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
    for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title);
    
    }
    System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    
  }
  
  public void printAverageRatingsByYearAfterAndGenre(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmovies_short.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings_short.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    AllFilters criteria= new AllFilters();
    Filter Genre=new GenreFilter("Romance");
    Filter Year = new YearAfterFilter(1980);
    criteria.addFilter(Genre);
    criteria.addFilter(Year);
    int minimal=1;
    ArrayList<Rating> avg_rates=ratings.getAverageRatingByFilter(minimal,criteria);
 
    //ArrayList<Rating> sortedavg_rates=ratings.sortgetAverageRatings(avg_rates);
    int size=avg_rates.size();
    System.out.println("found"+size+"movies");
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
    for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
     
    }
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
   }
  public void pringSimilarRatings(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String raterid="337";
    int minimalrater=3;
    int topsimilar=10;
    ArrayList<Rating> avg_rates=ratings.getSimilarRatings(raterid,topsimilar,minimalrater);
   int size=avg_rates.size();
   System.out.println("found "+size+" that matchtes");
    for(int q=0;q<1;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
    }
    }
  public void printSimilarRatingsByGenre(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String raterid="964";
    int minimalrater=5;
    int topsimilar=20;
    Filter filter=new GenreFilter("Mystery");
    ArrayList<Rating> avg_rates=ratings.getSimilarRatingsByFilter(raterid,topsimilar,minimalrater,filter);
   int size=avg_rates.size();
   System.out.println("found "+size+" that matchtes");
    for(int q=0;q<1;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
    }
    }
    public void printSimilarRatingsByDirector(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String raterid="120";
    int minimalrater=2;
    int topsimilar=10;
    Filter filter=new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
    ArrayList<Rating> avg_rates=ratings.getSimilarRatingsByFilter(raterid,topsimilar,minimalrater,filter);
   int size=avg_rates.size();
   System.out.println("found "+size+" that matchtes");
    for(int q=0;q<1;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
    }
    }
   public void printSimilarRatingsByGenreAndMinutes(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String raterid="168";
    int minimalrater=3;
    int topsimilar=10;
    AllFilters x=new AllFilters();
    Filter a=new GenreFilter("Drama");
    Filter b=new MinutesFilter(80,160);
    x.addFilter(a);
    x.addFilter(b);
    ArrayList<Rating> avg_rates=ratings.getSimilarRatingsByFilter(raterid,topsimilar,minimalrater,x);
   int size=avg_rates.size();
   System.out.println("found "+size+" that matchtes");
    for(int q=0;q<1;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
    }
    }
    public void printSimilarRatingsByYearAfterAndMinutes(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    FourthRatings ratings=new FourthRatings();
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String raterid="314";
    int minimalrater=5;
    int topsimilar=10;
    AllFilters x=new AllFilters();
    Filter a=new YearAfterFilter(1975);
    Filter b=new MinutesFilter(70,200);
    x.addFilter(a);
    x.addFilter(b);
    ArrayList<Rating> avg_rates=ratings.getSimilarRatingsByFilter(raterid,topsimilar,minimalrater,x);
   int size=avg_rates.size();
   System.out.println("found "+size+" that matchtes");
    for(int q=0;q<1;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
    }
    }
    public void printtest(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    
    MovieDatabase.initialize(moviefile);
    RaterDatabase.initialize(raterfile);
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+RaterDatabase.size());
    String webRaterID="314";
    FourthRatings user= new FourthRatings();
      int number=10;
      ArrayList<Rating> recommend=user.getRecommendations(webRaterID,number);
      int minimal=5;
      ArrayList<String> recmovieID= new ArrayList<String>();
      
      for(int i=0;i<minimal;i++){
        recmovieID.add(recommend.get(i).getItem());
      }
    String raterid="314";
  
    for(int q=0;q<minimal;q++){
     String title=MovieDatabase.getTitle(recmovieID.get(q));
     String genre=MovieDatabase.getGenres(recmovieID.get(q));
     int year=MovieDatabase.getYear(recmovieID.get(q));
     System.out.println("the movie "+title+"is made in "+year+"its genres cover: "+genre);
    }
    }
}
