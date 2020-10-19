package com.nt.addressBook;

import java.util.Scanner;

public class Book {

	    Scanner s = new Scanner(System.in);
	    //Nested class for each entry
	    class Entry{
	    	private int id;
	        private String name;
	        private String city;
	        private String address;
	        private String email;
	        private int pinCode;
	        private long mobileNo;
	        Entry(int id,String name, String city,String address,String email , int pinCode,long mobileNo){
	            this.id=id;
	            this.name = name;
	            this.city=city;
	            this.address = address;
	            this.email = email;
	            this.pinCode=pinCode;
	            this.mobileNo=mobileNo;
	            
	        }
	        Entry(){
	            id = 0;
	            name = "";
	            city="";
	            address = "";
	            email = "";
	            pinCode=0;
	            mobileNo=0;
	        }
	        public void readEntry(){
	        	System.out.println("Enter ID:"+id);
	            System.out.println(" Name:"+name );
	            System.out.println("City:"+city );
	            System.out.println("Address:"+address );
	            System.out.println("Email:"+email );
	            System.out.println("Enter PinCode:"+pinCode);
	            System.out.println("Enter Mobile Number:"+mobileNo);
	        }
	    }


	    //Keeps track of how many entries are in the book
	    private int entries = 0;
	    Entry[] contents;
	    public void initEntries(int e) {
	        contents = new Entry[e];
	        for (int i = 0;i<contents.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
	            contents[i] = new Entry();
	        }
	    }
	    public int getEntries(){
	        return contents.length;
	    }
	    //Adds an entry to the book
	    public void add(int id,String name, String city, String address, String email,int pinCode,long mobileNo){
	        if (entries<contents.length){
	        contents[entries] = new Entry(id,name, city, address, email,pinCode,mobileNo);
	        entries++;
	        }
	        else System.out.println("Error: book is full");
	    }

	    //Removes an entry from the book
	    public void remove(int entry){
	        if (entries>0){
	            contents[entry] = new Entry();
	            for (int i = 0;i<entries-entry;i++){
	                if (entry+1==entries) contents[entry] = new Entry();
	                else{
	                    Entry temp = contents[entry+i];
	                    contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards.
	                    contents[entry+i+1] = temp;
	                }
	            }
	            entries--;
	            }
	            else System.out.println("Error: book is empty.");
	    }

	    //Changes the values of an entry
	    public void edit(int id,String name, String city, String address, String email,int pinCode,long mobileNo, int selection){
	        contents[selection].id = id;
	        contents[selection].name = name;
	        contents[selection].city=city;
	        contents[selection].address = address;
	        contents[selection].email = email;
	        contents[selection].pinCode=pinCode;
	        contents[selection].mobileNo=mobileNo;
	    }

	    //Sorts the book based on a part of the entry
	   	    public void sort(int n){
	        for(int i = 0;i<contents.length;i++){
	            for (int j = 0;j<contents.length;j++){
	                switch(n){
	                    case 1:
	                        if (contents[i].name.compareTo(contents[j].name)<0){
	                            Entry temp = contents[i];
	                            contents[i] = contents[j];
	                            contents[j] = temp;
	                        }
	                        break;
	                    case 2:
	                        if (contents[i].pinCode < contents[j].pinCode){
	                            Entry temp = contents[i];
	                            contents[i] = contents[j];
	                            contents[j] = temp;
	                        }
	                        break;
	                    
	                    default: 
	                        System.out.println("Error: invalid field");
	                        break;
	                }
	            }
	        }
	    }
	    public void addFromCopy(Entry e){
	        if (entries<contents.length){
	            contents[entries] = e;
	            entries++;
	            }
	            else System.out.println("Error: book is full");
	    }

	}
