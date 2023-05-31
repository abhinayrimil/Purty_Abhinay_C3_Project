import org.junit.jupiter.api.*;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;
class RestaurantServiceTest {
    RestaurantService service;
    Restaurant restaurant;
    @BeforeEach
    public void setup() throws restaurantNotFoundException {
        service = new RestaurantService();
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        service.addRestaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant = service.findRestaurantByName("Amelie's cafe");
    }
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws restaurantNotFoundException {
        Restaurant foundRestaurant = service.findRestaurantByName("Amelie's cafe");
        assertNotNull(foundRestaurant);
        assertEquals(restaurant, foundRestaurant);
    }
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() throws restaurantNotFoundException {
        assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("Pantry d'or"));
    }
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants - 1, service.getRestaurants().size());
        assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("Amelie's cafe"));
    }
    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception() throws restaurantNotFoundException {
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants - 1, service.getRestaurants().size());
        assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("Amelie's cafe"));
    }
    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales", "Chennai", LocalTime.parse("12:00:00"), LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1, service.getRestaurants().size());
    }
    @Test
    public void getOrderValue_should_return_correct_total_price_for_selected_items() {
        restaurant.addToMenu("Item 1", 100);
        restaurant.addToMenu("Item 2", 200);
        restaurant.addToMenu("Item 3", 300);
    }
}