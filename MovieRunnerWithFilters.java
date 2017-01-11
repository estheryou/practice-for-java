import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerWithFilters {
     public void printAverageRatings (){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    
    int minimal=35;
    ArrayList<Rating> avg_rates=ratings.getAverageRatings(minimal);
    
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
     System.out.println(avg_rates.get(q).getValue()+"  "+title);
    
    }
    System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    
  }
  
  public void printAverageRatingsByYear(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    Filter year=new YearAfterFilter(2000);
    int minimal=20;
    ArrayList<Rating> avg_rates=ratings.getAverageRatingByFilter(minimal,year);
 
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title);
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    }
   public void printAverageRatingsByGenre(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    Filter genre=new GenreFilter("Comedy");
    int minimal=20;
    ArrayList<Rating> avg_rates=ratings.getAverageRatingByFilter(minimal,genre);
 
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genres=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title);
     System.out.println("the genres are:"+genres);
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    } 
    
    public void printAverageRatingsByMinutes(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    Filter genre=new MinutesFilter(105,135);
    int minimal=5;
    ArrayList<Rating> avg_rates=ratings.getAverageRatingByFilter(minimal,genre);
 
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     int minutes=MovieDatabase.getMinutes(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+"with length"+minutes);
     
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    } 
    
     public void printAverageRatingsByDirectors(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    //String directs="Charles chaplin,Michael Mann,Spike Jonze";
    String directs="Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
    Filter directors=new DirectorsFilter(directs);
    int minimal=4;
    ArrayList<Rating> avg_rates=ratings.getAverageRatingByFilter(minimal,directors);
 
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String name=MovieDatabase.getDirector(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+"with director"+name);
     
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    } 
    
  public void printAverageRatingsByYearAfterAndGenre(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    AllFilters criteria= new AllFilters();
    Filter Genre=new GenreFilter("Drama");
    Filter Year = new YearAfterFilter(1990);
    criteria.addFilter(Genre);
    criteria.addFilter(Year);
    int minimal=8;
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String genre=MovieDatabase.getGenres(avg_rates.get(q).getItem());
     int year=MovieDatabase.getYear(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the movie is made in "+year+"its genres cover: "+genre);
     
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    } 
    
  public void printAverageRatingsByDirectorsAndMinutes(){
    String moviefile="/Users/You/Desktop/java/2week/data/ratedmoviesfull.csv";
    String raterfile="/Users/You/Desktop/java/2week/data/ratings.csv";
    ThirdRatings ratings=new ThirdRatings(raterfile);
    MovieDatabase.initialize(moviefile);
    //int movienum=ratings.getMovieSize();
    int raternum=ratings.getRaterSize();
    System.out.println("this is a new try");
    System.out.println("the imported csv files have movies "+MovieDatabase.size()+"with ratings: "+raternum);
    AllFilters criteria= new AllFilters();
    //Filter Directors=new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola");
    Filter Directors=new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollak");
    Filter Minute= new MinutesFilter(90,180);
    criteria.addFilter(Directors);
    criteria.addFilter(Minute);
    int minimal=3;
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
    /*for(int q=0;q<size;q++){
     String title=MovieDatabase.getTitle(avg_rates.get(q).getItem());
     String director=MovieDatabase.getDirector(avg_rates.get(q).getItem());
     int time=MovieDatabase.getMinutes(avg_rates.get(q).getItem());
     System.out.println(avg_rates.get(q).getValue()+"  "+title+" with director");
     System.out.println("the length of the movie is "+time+"its genres cover: "+director);
     
    }*/
    //System.out.println("there are"+size+"that is over"+minimal+"with the lowest one :"+MovieDatabase.getTitle(avg_rates.get(0).getItem()));
    } 
}
