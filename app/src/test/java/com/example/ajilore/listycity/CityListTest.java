package com.example.ajilore.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        // This is a mock city list that contains one city
        CityList cityList = new CityList();

        // This line adds the mock city to the list
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton","Alberta");
    }

    @Test
    void testAdd(){
        // This is a mock city list that contains one city
        CityList cityList = mockCityList();

        //This line checks if the size of the cityList is 1
        assertEquals(1, cityList.getCities().size());

        //Create a new city
        City city = new City("Regina", "Saskatchewan");

        //Add the city to the list
        cityList.add(city);

        //Check if the size of the cityList is 2
        assertEquals(2, cityList.getCities().size());

        //Check if the city is in the list
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        //This makes a mock city list
        CityList cityList = mockCityList();

        //Create a new city
        City city = new City("Yellowknife", "Northwest Territories");

        //Add the city to the cityList
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            //This line should throw an exception because the city already exists
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        //This makes a mock city list
        CityList cityList = mockCityList();

        //Create a new city
        City city = new City("Yellowknife", "Northwest Territories");

        assertFalse(cityList.hasCity(city));

        //Add the city to the cityList
        cityList.add(city);

        //Check if the city is in the list
        assertTrue(cityList.hasCity(city));

    }

    @Test
    void testDelete() {
        //This makes a mock city list
        CityList cityList = mockCityList();

        //Create a new city
        City city = new City("Yellowknife", "Northwest Territories");

        //Try and remove the city from the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

        //Add the city to the list
        cityList.add(city);

        //Remove the city from the list
        cityList.delete(city);

        //Check if the city is in the list
        assertFalse(cityList.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });


    }

    @Test
    void testCountCities(){
        //This makes a mock city list
        CityList cityList = mockCityList();

        //Checks if the size of the cityList is 1
        assertEquals(1, cityList.countCities());

        //Make a new city
        City city = new City("Yellowknife", "Northwest Territories");

        //Add the city to the list
        cityList.add(city);

        //Checks if the size of the cityList is 2
        assertEquals(2, cityList.countCities());

        //Remove the city from the list
        cityList.delete(city);

        //Checks if the size of the cityList is 1
        assertEquals(1, cityList.countCities());
    }

}
