/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imdbFacetSearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.*;
import java.io.*; 
import java.io.IOException;

/**
 *
 * @author User
 */
public class populate {
    
    static Connection c = null;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        c = JavaConnectDB.ConnectDB();
       
        try{populateTags(c);}catch (Exception e){ System.out.println("Error populating Tags");}
        try{populateMovies(c);}catch (Exception e){ System.out.println("Error populating Movies");}
        try{populateGenres(c);}catch (Exception e){ System.out.println("Error populating Genres");}
        try{populateLocations(c);}catch (Exception e){ System.out.println("Error populating Locations");}
        try{populateCountries(c);}catch (Exception e){ System.out.println("Error populating Countries");}
        try{populateMovieTags(c);}catch (Exception e){ System.out.println("Error populating MovieTags");}
        
        JavaConnectDB.CloseConnectionDB(c);
        } catch (SQLException e){}
      
    }
    
    public static void populateLocations(Connection c) throws Exception{
	Statement s = c.createStatement();
	s.executeQuery("delete from locations");
	
	//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
        File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/movie_locations.dat"); 
	
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	br.readLine();
	
	// prepare statement
	PreparedStatement ps = c.prepareStatement("insert into locations values(?,?)");
	
	String st;
	String[] stringArr = null; 
	
	while ((st = br.readLine()) != null) {
		
		stringArr = st.split("\\t");
		for(String a:stringArr) 
		System.out.print(a);
		System.out.println();
	if(stringArr.length < 1){
		System.out.print("Error with input Locations");
                continue;
	}
	else if (stringArr.length < 2){
            continue;
	}
	else{
		ps.setString(1, stringArr[0]);
		ps.setString(2, stringArr[1]);
	}
		//execute update
		ps.executeUpdate();
                
	} 
	//close connection
        s.close();
        ps.close();
        System.out.println("Countries Inserted Into DB");

        }
    
    public static void populateCountries(Connection c) throws Exception{
	Statement s = c.createStatement();
	s.executeQuery("delete from countries");
	
	//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
        File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/movie_countries.dat"); 
	
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	br.readLine();
	
	// prepare statement
	PreparedStatement ps = c.prepareStatement("insert into Countries values(?,?)");
	
	String st;
	String[] stringArr = null; 
	
	while ((st = br.readLine()) != null) {
		
		stringArr = st.split("\\t");
		for(String a:stringArr) 
		System.out.print(a);
		System.out.println();
	if(stringArr.length < 1){
		System.out.print("Error with input MovieTags");
	}
	else if (stringArr.length < 2){
		ps.setString(1, stringArr[0]);
		ps.setString(2, "");
	}
	else{
		ps.setString(1, stringArr[0]);
		ps.setString(2, stringArr[1]);
	}
		//execute update
		ps.executeUpdate();
                
	} 
	//close connection
        s.close();
        ps.close();
        System.out.println("Countries Inserted Into DB");

        }
    
    
    public static void populateMovieTags(Connection c) throws Exception{
	Statement s = c.createStatement();
	s.executeQuery("delete from MovieTags");
	
	//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
        File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/movie_tags.dat"); 
	
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	br.readLine();
	
	// prepare statement
	PreparedStatement ps = c.prepareStatement("insert into MovieTags values(?,?,?)");
	
	String st;
	String[] stringArr = null; 
	
	while ((st = br.readLine()) != null) {
		
		stringArr = st.split("\\t");
		for(String a:stringArr) 
		System.out.print(a);
		System.out.println();
	if(stringArr.length < 1){
		System.out.print("Error with input MovieTags");
	}
	else if (stringArr.length < 2){
		ps.setString(1, stringArr[0]);
		ps.setString(2, "");
	}
	else{
		ps.setString(1, stringArr[0]);
		ps.setString(2, stringArr[1]);
                ps.setString(3, stringArr[2]);
	}
		//execute update
		ps.executeUpdate();
                
	} 
	//close connection
        s.close();
        ps.close();
        System.out.println("Movie_tags Inserted Into DB");

        }
    
    
    public static void populateMovies(Connection c) throws Exception{
        Statement s = c.createStatement();
	s.executeQuery("delete from movies");
        PreparedStatement ps = c.prepareStatement("insert into movies values(?,?,?,?,?,?,?,?,?)");
        
        
        String[] wholeString = null;
		
		//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/movies.dat"); 
                File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/movies.dat"); 
                
                
		try{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			int lines = 0;
			String line;
			while((line = bufferReader.readLine()) != null){
				lines++;
			}
			
			bufferReader.close();
			fileReader.close();
			
			
			FileReader fileReader2 = new FileReader(file);
			BufferedReader bufferReader2 = new BufferedReader(fileReader2);
		
			String[] stringArr = new String[lines];
                        
                      
			for(int i=0; i<lines;i++){
	
				stringArr[i] = bufferReader2.readLine();
				
			}
			
			bufferReader2.close();
			fileReader2.close();
			
			//for(String a:stringArr) 
				//System.out.print(a);
				
			wholeString = stringArr;
			
			//System.out.print(stringArr.length);
			
			}catch (Exception e){
				System.out.print("Error1");
			}
			
			String[] indexBuckets = null;
			for (int i = 1 ; i < wholeString.length; i ++){
				indexBuckets = wholeString[i].split("\\t");
                                
                                
                                ps.setString(1, indexBuckets[0]);
                                ps.setString(2, indexBuckets[1]);
                                ps.setString(3, indexBuckets[5]);
                                
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(4, null);
                                } else {    
                                    ps.setString(4, indexBuckets[7]);
                                }
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(5, null);
                                } else {    
                                    ps.setString(5, indexBuckets[8]);
                                }
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(6, null);
                                } else {    
                                    ps.setString(6, indexBuckets[12]);
                                }
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(7, null);
                                } else {    
                                   ps.setString(7, indexBuckets[13]);
                                }
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(8, null);
                                } else {    
                                   ps.setString(8, indexBuckets[17]);
                                }
                                if(indexBuckets[7].equals("\\N")){
                                     ps.setString(9, null);
                                } else {    
                                    ps.setString(9, indexBuckets[18]);
                                }
                                
                                ps.executeUpdate();
                                
//                                ps.setString(5, indexBuckets[8]);
//                                ps.setString(6, indexBuckets[12]);
//                                ps.setString(7, indexBuckets[13]);
//                                ps.setString(8, indexBuckets[17]);
//                                ps.setString(9, indexBuckets[18]);
                                
                                
				//for(String a:indexBuckets) {
                                        // ps.setString(1, stringArr[0]);
					//System.out.print(a);
                                //}
			}
                        
        s.close();
        ps.close();
        System.out.println("Movies Inserted Into DB");

    
    }
    
     public static void populateGenres(Connection c) throws Exception{
	Statement s = c.createStatement();
	s.executeQuery("delete from genres");
	
	//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
        File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/movie_genres.dat"); 
	
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	br.readLine();
	
	// prepare statement
	PreparedStatement ps = c.prepareStatement("insert into genres values(?,?)");
	
	String st;
	String[] stringArr = null; 
	
	while ((st = br.readLine()) != null) {
		
		stringArr = st.split("\\t");
		for(String a:stringArr) 
		System.out.print(a);
		System.out.println();
	if(stringArr.length < 1){
		System.out.print("Error with input genres");
	}
	else if (stringArr.length < 2){
		ps.setString(1, stringArr[0]);
		ps.setString(2, "");
	}
	else{
		ps.setString(1, stringArr[0]);
		ps.setString(2, stringArr[1]);
	}
		//execute update
		ps.executeUpdate();
                
	} 
	//close connection
        s.close();
        ps.close();
        System.out.println("Genres Inserted Into DB");

        }
    public static void populateTags(Connection c) throws Exception{
    //Start Connection
	Statement s = c.createStatement();
	s.executeQuery("delete from tags");
	
	//File file = new File("/Users/ericcastronovo/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
        File file = new File("C:/Users/User/Desktop/hetrec2011-movielens-2k-v2/tags.dat"); 
	
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	br.readLine();
	
	// prepare statement
	PreparedStatement ps = c.prepareStatement("insert into tags values(?,?)");
	
	String st;
	String[] stringArr = null; 
	
	while ((st = br.readLine()) != null) {
		
		stringArr = st.split("\\t");
		for(String a:stringArr) 
		System.out.print(a);
		System.out.println();
		//System.out.println(st); 
	if(stringArr.length < 1){
		System.out.print("Error with input tags");
	}
	else if (stringArr.length < 2){
		//
		ps.setString(1, stringArr[0]);
		ps.setString(2, "");
	}
	else{
		ps.setString(1, stringArr[0]);
		ps.setString(2, stringArr[1]);
	}
		//execute update
		ps.executeUpdate();
                
	} 
	//close connection
        s.close();
        ps.close();
        System.out.println("Tags Inserted Into DB");

        }
    
    
}
    
