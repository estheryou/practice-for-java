import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecommendationRunner implements Recommender{
    public ArrayList<String> getItemsToRate(){
      ArrayList<String> movieID= new ArrayList<String>();
     FourthRatings user=new FourthRatings();
     int number=10;
      Filter Year = new YearAfterFilter(2000);
     int minimal=10;
     ArrayList<Rating> avg_rates=user.getAverageRatingByFilter(minimal,Year);
     for(int i=0;i<number;i++){
      movieID.add(avg_rates.get(i).getItem());
    
      }
     return movieID;
    }
    public void printRecommendationsFor(String webRaterID){
      FourthRatings user= new FourthRatings();
      //Filter year=new YearAfterFilter(2010);
     
       
    int topsimilar=10;
    ArrayList<Rating> recommend=user.getRecommendations(webRaterID,topsimilar);
      int min=10;
      ArrayList<String> recmovieID= new ArrayList<String>();
      
      for(int j=0;j<min;j++){
        recmovieID.add(recommend.get(j).getItem());
      }
      
     System.out.println("<!DOCTYPE html>");
     System.out.println("<html>");
     System.out.println("<head>");
     System.out.println("<style media="+"screen"+" type="+"text/css"+">");
     System.out.println("table {"+
    "border-collapse: collapse;"+
    "text-align:center;"+"}");
     System.out.println("</style>");
     System.out.println("<h1>"+" movies recommended for you "+" </h1>");
     System.out.println("</head>");
     System.out.println("<body>"); 
     System.out.println("<table >");
     for(String id:recmovieID){
        String photo=MovieDatabase.getPoster(id);
        int Year = MovieDatabase.getYear(id);
        String Title= MovieDatabase.getTitle(id);
        System.out.println("<tr>");
        System.out.println("<td>"+Title+"</td>");
        System.out.println("<td>"+"<img src= \""+photo+ " \""+"width=80>"+"</td>");
        System.out.println("<td>"+Year+"</td>");
        System.out.println("</tr>");
        }
       System.out.println("</table>");
     System.out.println("</body>");
    System.out.println("</html>");
     
    }

}
