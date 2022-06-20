package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        try {
            // create object mapper

            ObjectMapper mapper =  new ObjectMapper();


            // read json file and map/convert to java POJO
            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print firstName and lastName

            System.out.println("First name= " + theStudent.getFirstName() + " lastName = " + theStudent.getLastName());

            // print out address: street and city
            Address tempAddress = theStudent.getAddress();
            System.out.println("Street = " + tempAddress.getStreet());
            System.out.println("Street = " + tempAddress.getCity());

            //Print out languages
            for(String tempLang : theStudent.getLanguages()){
                System.out.println(tempLang);
            }



        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
