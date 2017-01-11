import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstRatings {
   private String[] FILE_HEADER={"id","title","year","country","genre","director","minutes","poster"};
   private String[] FILE_HEADER_Rater={"rater_id","movie_id","rating","time"};
   public ArrayList<Movie> loadMovies(String fileName){
    FileReader fileReader = null;
    CSVParser csvFileParser = null;
    ArrayList<Movie> movies=new ArrayList<Movie>();
     //创建CSVFormat（header mapping）
     CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER);
     try {
        //初始化FileReader object
          fileReader = new FileReader(fileName);
        //初始化 CSVParser object
          csvFileParser = new CSVParser(fileReader, csvFileFormat);
        //CSV文件records
          List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
        // 
        int maxmovies=0;
            String name=new String();
             String x="comedy";
            int counts=0;
            int countss=0;
            HashMap<String,Integer> directors=new HashMap<String,Integer>();     
         for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                //创建用户对象填入数据
                Movie newMovies = new Movie(record.get("id"), record.get("title"),
                            record.get("year"), record.get("genre"),record.get("director"),
                            record.get("country"),record.get("poster"),Integer.parseInt(record.get("minutes")));
                movies.add(newMovies); 
            }
           
            for(Movie movie:movies){
                
            if(movie.getGenres().toLowerCase().contains(x)){
              counts=counts+1;
              //System.out.println("the one belongs to comedy is :"+movie.getGenres());
            }
            if(movie.getMinutes()>150){
                countss=countss+1;
                //System.out.println("the length of the movie is :"+movie.getMinutes());
            }
            if(!movie.getDirector().contains(",")){
              fordirector(movie.getDirector(),directors);
            }
            else{
              String[] directornames=movie.getDirector().split(",");
              for(int i=0;i<directornames.length;i++){
                fordirector(directornames[i],directors);
                }
            }
            
            for(String key:directors.keySet()){
              if(maxmovies<directors.get(key)){
                  maxmovies=directors.get(key);
                  name=key;
               }
               
            }
            
           // 遍历打印
            /*for (Movie everymovie : movies) {
                System.out.println(everymovie.toString());
            }*/
        }
        //System.out.println("the number of movies contains comedy is :"+counts);    
          //  System.out.println("the number of movies more than 150minutes is :"+countss);  
            //System.out.println("the number of most movies by "+name+" is :"+maxmovies);
            //System.out.println("the directors with the # of the movies they directed is :"+directors
         }
        
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }   
   public void fordirector(String director,HashMap<String, Integer> directors){
    if(directors.containsKey(director)){
                    directors.put(director,directors.get(director)+1);
                }
                else{
                    directors.put(director,1);
                }
    
    }
   public  void test(){
     System.out.println("new try");
     ArrayList<Movie> movies=loadMovies("/Users/You/Downloads/StepOneStarterProgram 2/data/ratedmoviesfull.csv");
    
    }
    
   public ArrayList<Rater> loadRaters(String fileName){
    FileReader fileReader = null;
    CSVParser csvFileParser = null;
    ArrayList<Rater> rating=new ArrayList<Rater>();
     //创建CSVFormat（header mapping）
     CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_Rater);
     try {
        //初始化FileReader object
          fileReader = new FileReader(fileName);
        //初始化 CSVParser object
          csvFileParser = new CSVParser(fileReader, csvFileFormat);
        //CSV文件records
          List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
        // 
          ArrayList<String> IdList=new ArrayList<String>();
          ArrayList<String> mvidList=new ArrayList<String>();
         for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                //创建用户对象填入数据
                String id=record.get("rater_id");
                //System.out.println("this obs is :"+id);
                String movie=record.get("movie_id");
                if(!mvidList.contains(movie)){
                  mvidList.add(movie);
                }
                
                if(IdList.contains(id)){
                    /*System.out.println("the one is :"+IdList);*/
                    
                for(int j=0;j<rating.size();j++){
                    String idoccured=rating.get(j).getID();
                   // System.out.println("the one that is already in the rating"+idoccured);
                  if(rating.get(j).getID().equals(id)){
                    rating.get(j).addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                    //System.out.println("the one is "+rating.get(j));
                  }
                  /*else{
                    System.out.println("the id is not equal");}*/
                }
                
               }
               else{
                IdList.add(id);
                Rater x=new EfficientRater(id);
                x.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                int ratingsizebefore=rating.size();
                rating.add(x);
                
                //System.out.println("the first occurance for user"+id+"is"+rating.get(ratingsizebefore));
                }
                
            }
          // System.out.println("there are"+mvidList.size()+"movies that are rated by the raters");
        } 
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rating;
    }   
   public void testforrating(){
       System.out.println(" this is a  new try 2");
       ArrayList<Rater> rate=loadRaters("/Users/You/Downloads/StepOneStarterProgram 2/data/ratings.csv");
       
       String raternum="193";
       for(Rater rater:rate){
          if(rater.getID().equals(raternum)){
           // System.out.println("the # of movies rated by "+rater.getID()+"is"+rater.numRatings());
        }
       }
       //System.out.println(rate);
       /*for(int i=0;i<rate.size();i++){
        System.out.println("the size is "+rate.get(i).myRatings);
        
        }*/
       int maxrate=0;
       int the_one_with_most_rate=0;
       for(int p=0;p<rate.size();p++){
        if(maxrate<rate.get(p).numRatings()){
          maxrate=rate.get(p).numRatings();
          the_one_with_most_rate=p;
         }
        }
       //System.out.println("THE ONE WITH MOST"+rate.get(the_one_with_most_rate).getID()+" with movies"+maxrate);
       /*for(int j=0;j<rate.size();j++){
        if(rate.get(j).getID().equals(maxrate)){
         System.out.println("the one with the maximum rate movie is"+maxrate+"rater"+rate.get(j).getID());       
        }
        }*/
        int numofraterforone=0;
        String target=new String();
        target="1798709";
       for(Rater rater:rate){
         ArrayList<String> ratedones= rater.getItemsRated();
        if(ratedones.contains(target)){
         numofraterforone+=1;
         }
        }
       //System.out.println("the movie"+target+"rated by"+numofraterforone);
    }
 }

 