import java.time.LocalTime;

public class Main{
    public static void main(String args[]){
       //System.out.println("Hi");
       Restaurant r1 = new Restaurant("KFC", "Mumbai", LocalTime.parse("12:30:00"), LocalTime.parse("11:30:00"));
       r1.displayDetails();
       RestaurantService r2 = new RestaurantService();
        System.out.println(r2.getRestaurants());
    }
}