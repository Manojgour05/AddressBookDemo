package com.nt.addressBook;

import java.util.Scanner;
public class AddressBook2{
    public static void main(String[] args){
    	System.out.println("welcome to Display addressbook ");
    	System.out.println("-----------------------------------------------");
    	Scanner s = new Scanner(System.in);
        System.out.print("How many books do you want to create? ");
        int howManyBooks;
        int howManyEntries;

        Book[] library = new Book[0];


        while(true){
            howManyBooks = s.nextInt();
            if (howManyBooks>0){
                library = new Book[howManyBooks];                   
                break;
            }
            else System.out.print("You must create at least 1 book.");
            }



        for (int i=0;i<library.length;i++){


            library[i] = new Book(); // each book in the library had not been initialized yet.

            while(true){
                System.out.print("How many entries in book "+i+"? ");
                howManyEntries = s.nextInt();
                if (howManyEntries>0) {
                    library[i].initEntries(howManyEntries);                 
                    break;
                }
                else System.out.println("You must create at least 1 Entry.");
                }


        }
        boolean done = false;
        int selectedBook = 0;
        int selection;
        while (done==false){
            System.out.println("Book "+selectedBook+" is currently selected.");

            for (int i = 0;i<library[selectedBook].getEntries();i++){
                System.out.println("-----------Entry "+i+" ---------------");
                library[selectedBook].contents[i].readEntry(); //Accessing the array of entries INSIDE the array of books/the library
                System.out.println("---------------------------------------");
            }

  
            System.out.println("Select an option!");
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry"); 
            System.out.println("3. Edit an entry");
            System.out.println("4. Sort by name and pinCode");
            System.out.println("5. Exit the menu");
            System.out.print("> ");
             selection = s.nextInt();
            int id,pinCode;
            long mobileNo;
            String name, city, address, email;
            switch(selection){
            case 1: 
            	System.out.println("id");
            	id=s.nextInt();
                System.out.print(" name? ");
                name = s.next();
                System.out.print(" City? ");
                city = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Email? ");
                email = s.next();
                System.out.println("PinCode?");
                pinCode=s.nextInt();
                System.out.println("MobileNO?");
                mobileNo=s.nextLong();
                library[selectedBook].add(id,name, city , address, email,pinCode,mobileNo);
                break;
            case 2: 
                System.out.print("Remove which entry? ");
                int entry = s.nextInt();
                library[selectedBook].remove(entry);
                break;
            case 3:
                System.out.print("Edit which entry?");
                int whichEntry = s.nextInt();
                System.out.println("id?");
                id=s.nextInt();
                System.out.print(" name? ");
                name = s.next();
                System.out.print("City? ");
                city = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Email? ");
                email = s.next();
                System.out.println("PinCode?");
                pinCode=s.nextInt();
                System.out.println("MobileNo?");
                mobileNo=s.nextLong();
                library[selectedBook].edit(id,name,city, address, email,pinCode,mobileNo, whichEntry);
                break;
            case 4: 
                System.out.println("Sort by name and pincode");
                System.out.println("1. Sort by name");
                System.out.println("2. Sort by pinCod2e");
         
                library[selectedBook].sort(s.nextInt());
                break;
            
            case 5:
                done = true;
                break;
            default:
                System.out.print("Please choose a valid menu number");


            }

        }
    }
   
}
