package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Test_api {

    static String greeting = "Hello";
    static ArrayList<Integer> number = new ArrayList<Integer>(3);

    static String motor = "Cars";
    static ArrayList<String> cars = new ArrayList<String>();

    @GetMapping("api/hello")
    public static String Hello()
    {
        initArray();
        return greeting;
    }

    @PostMapping("api/postmsg")
    public static String Post(@RequestBody String addedString)
    {
        greeting = greeting + " " + addedString;

        return  greeting;
    }

    @PostMapping("api/postInit")
    public static ArrayList<Integer> Post2(@RequestBody String addedNum)
    {
        number.add(Integer.parseInt(addedNum));

        return  number;
    }

    @PutMapping ("api/updateIndex/{index}")
    public static Object Put(@PathVariable int index, @RequestBody String newNum)
    {
        try {
            number.set(index, Integer.parseInt(newNum));
        }catch (Exception e)
        {
            return "The following exception occured: " + e; // the return is of type String
        }
        return  number; // of type ArrayList
    }


    @GetMapping("api/GetArrayList")
    public static ArrayList<Integer> ArrayList()
    {
        return number;
    }

    @DeleteMapping("api/DeleteIndex/{index}")
    public static ArrayList<Integer> DeleteName(@PathVariable int index)
    {
        number.remove(index);
        return number;
    }

@GetMapping("api/getURL")
        public static String URL(String url) {
         url = "www.google.com";
           return url;
}

@GetMapping("api/getCars")
      public static String Cars(){
         initCars();
        return motor;
}
@GetMapping("api/getCarList")
    public static ArrayList<String> GetCarsList(){
        return cars;
    }


    @PostMapping("api/postCars")
    public static ArrayList<String> addCar(@RequestBody String carName)
    {
        cars.add(carName);
        return  cars;
    }

    @PostMapping("api/postName")
public static String Name1() {
        return "https://www.maps.google.com";
    }
 @PutMapping("api/putLastName")
 public static String Name2(){
        return "putLastName";
    }
 @DeleteMapping ("api/DeleteIndex/{index}")
 public static ArrayList<String> DeleteCars(@PathVariable String cars)
 {
     cars.remove(index);
        return Cars;
 }


    public static  void initArray()
    {
        number.add(2);
        number.add(5);
        number.add(2);
        number.add(8);
        System.out.println();
    }
    public static void initCars() {
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
    }
}