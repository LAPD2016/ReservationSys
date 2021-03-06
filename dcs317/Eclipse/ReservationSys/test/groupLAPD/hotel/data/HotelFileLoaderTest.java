package groupLAPD.hotel.data;

import java.io.File;
import java.io.IOException;

import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;

/**
 * Test application for the HotelFileLoader class
 * and its public methods
 * @author Lyrene Labor and Ali Dali
 *
 */
public class HotelFileLoaderTest {
	
	public static void main(String[] args) throws IOException {
		
		TestGetRoomListFromSequentialFile();
		TestGetCustomerListFromSequentialFile();
		TestGetReservationListFromSequentialFile();	
	}
	
	public static void TestGetRoomListFromSequentialFile()
			throws IOException{
		System.out.println("\nTesting the "
				+ "getRoomListFromSequentialFile method");
		
		String path = "datafiles"+File.separator;
		String goodRoomFile = path+"rooms.txt";
		TestGetRoomListFromSequentialFile
			("Case 1: Room file with all correct entries", 
					true, goodRoomFile);
		path = "test"
				+File.separator +"groupLAPD"+
				File.separator+"hotel"+File.separator+"data"+
				File.separator+"datafilesTest"+File.separator;
		
		String badRoomFile1 = path+"badRoomFile1.txt";
		TestGetRoomListFromSequentialFile("Case 2: Room file "
				+ "with non existing room type bleh", true, badRoomFile1);
		
		String badRoomFile2 = path+"badRoomFile2.txt";
		TestGetRoomListFromSequentialFile("Case 3: Room file "
				+ "with numerical room type 123", true, 
				badRoomFile2);
		
		String badRoomFile3 = path+"badRoomFile3.txt";
		TestGetRoomListFromSequentialFile("Case 4: Room file "
				+ "with non-numerical room number normal", 
				true, badRoomFile3);
		
		String badRoomFile4 = path+"badRoomFile4.txt";
		TestGetRoomListFromSequentialFile("Case 5: Room file "
				+ "with entry with more than 2 fields", 
				true, badRoomFile4);
		
		String badRoomFile5 = path+"badRoomFile5.txt";
		TestGetRoomListFromSequentialFile("Case 6: Room file "
				+ "with entry with less than 2 fields", 
				true, badRoomFile5);
		
		String badRoomFile6 = path+"badRoomFile6.txt";
		TestGetRoomListFromSequentialFile("Case 7: Room file "
				+ "with entry containing wrong room number 110", 
				true, badRoomFile6);
		
		String badRoomFile7 = path+"badRoomFile7.txt";
		TestGetRoomListFromSequentialFile("Case 8: Room file "
				+ "with entry containing wrong room type for room number", 
				true, badRoomFile7);
		
		String badRoomFile8 = path+"badRoomFile8.txt";
		TestGetRoomListFromSequentialFile("Case 9: Room file "
				+ "with entry containing wrong room number for room type", 
				true, badRoomFile8);
		
		TestGetRoomListFromSequentialFile("Case 10: Room file "
				+ "does not exist", 
				false, path+"holla.txt");
		
	}
	
	public static void TestGetRoomListFromSequentialFile
				(String testCase, boolean expectedResult, String filename) 
						throws IOException{
		System.out.println();
		System.out.println("   " + testCase);
		System.out.println("    Filename: " + filename);
		
		try {
			Room[] roomList = HotelFileLoader.getRoomListFromSequentialFile
				(filename);
			System.out.println("    Here is the room data file content");
			for(Room r: roomList){
				System.out.println("\t"+r);
			}
			if(!expectedResult){
				System.out.println("ERROR! You expected this test case to"
						+ " fail but it didn't");
			}
		}
		catch(IllegalArgumentException e){
			System.out.print("\t"+ e.getMessage());
			if(expectedResult){
				System.out.println("ERROR! You expected this test case to "
						+ "to succeed but it didn't!");
			}
		}
		catch(Exception x){
			System.out.print("\n\tError! There was an unexpected exception"
					+ " type " + x.getClass() +  " "  + 				
					x.getMessage());
			if (expectedResult)
				System.out.print("\n\tYou expected this case to succeed but"
						+ " it didn't ");
		}
		
		System.out.println("\n");	
	}
	
	public static void TestGetCustomerListFromSequentialFile()
			throws IOException{
		System.out.println("\nTesting the "
				+ "getCustomerListFromSequentialFile method");
		
		String path = "datafiles"+File.separator;
		String goodCustFile = path+"customersLAPD.txt";
		TestGetCustomerListFromSequentialFile
			("Case 1: Customer file with all correct entries", 
					true, goodCustFile);
		
		path = "test"
				+File.separator +"groupLAPD"+
				File.separator+"hotel"+File.separator+"data"+
				File.separator+"datafilesTest"+File.separator;
		
		String badCustFile1 = path+"badCustFile1.txt";
		TestGetCustomerListFromSequentialFile
		("Case 2: Customer file with entry of 2 fields", 
				true, badCustFile1);
		
		String badCustFile2 = path+"badCustFile2.txt";
		TestGetCustomerListFromSequentialFile
		("Case 3: Customer file with entry of 4 fields only", 
				true, badCustFile2);
		
		String badCustFile3 = path+"badCustFile3.txt";
		TestGetCustomerListFromSequentialFile
		("Case 4: Customer file with entry of 1 field only", 
				true, badCustFile3);
		
		String badCustFile4 = path+"badCustFile4.txt";
		TestGetCustomerListFromSequentialFile
		("Case 5: Customer file with entry of 6 fields only", 
				true, badCustFile4);
		
		String badCustFile5 = path+"badCustFile5.txt";
		TestGetCustomerListFromSequentialFile
		("Case 6: Customer file with entry containing empty card type", 
				true, badCustFile5);
		
		String badCustFile6 = path+"badCustFile6.txt";
		TestGetCustomerListFromSequentialFile
		("Case 7: Customer file with entry containing wrong card type", 
				true, badCustFile6);
		
		String badCustFile7 = path+"badCustFile7.txt";
		TestGetCustomerListFromSequentialFile
		("Case 8: Customer file with entry containing wrong card number", 
				true, badCustFile7);
		
		String badCustFile8 = path+"badCustFile8.txt";
		TestGetCustomerListFromSequentialFile
		("Case 9: Customer file with entry containing wrong email", 
				true, badCustFile8);
		
		String badCustFile9 = path+"badCustFile9.txt";
		TestGetCustomerListFromSequentialFile
		("Case 10: Customer file with entry containing wrong "
				+ "customer name", 
				true, badCustFile9);	
	}
	
	public static void TestGetCustomerListFromSequentialFile
	(String testCase, boolean expectedResult, String filename) 
			throws IOException{

		System.out.println("   " + testCase);
		System.out.println("    Filename: " + filename);

		try {
			Customer[] CustomerList =
					HotelFileLoader.getCustomerListFromSequentialFile
					(filename);
			System.out.println("    Here is the customer data file content:");
			for(Customer c: CustomerList){
				System.out.println("\t"+c);
			}
			if(!expectedResult){
				System.out.println("\nERROR! You expected this test case to"
						+ " fail but it didn't");
			}
		}
		catch(IllegalArgumentException e){
			System.out.print("\t"+ e.getMessage());
			if(expectedResult){
				System.out.println("\nERROR! You expected this test case to "
						+ "to succeed but it didn't!");
			}
		}
		catch(Exception x){
			System.out.print("\nError! There was an unexpected exception"
					+ " type " + x.getClass() +  " "  + 				
					x.getMessage());
			if (expectedResult)
				System.out.print("\nYou expected this case to succeed but"
						+ " it didn't ");
		}

		System.out.println("\n");	
	}
	
	///////////////////////////////////////
	
	public static void TestGetReservationListFromSequentialFile(){
		
		System.out.println("\nTesting the "
				+ "getReservationListFromSequentialFile method");
		
		
		String path = "datafiles"+File.separator;
		String goodResFile = path+"reservationsLAPD.txt";
		
		TestGetReservationListFromSequentialFile
		("Case 1: Reservation file with all correct entries", 
				true, goodResFile);
		
		path = "test"
				+File.separator +"groupLAPD"+
				File.separator+"hotel"+File.separator+"data"+
				File.separator+"datafilesTest"+File.separator;
		
		String badResFile1 = path + "badResFile1.txt";
		TestGetReservationListFromSequentialFile
		("Case 2: Reservation file with Room not found", 
				true, badResFile1);
		
		String badResFile2 = path + "badResFile2.txt";
		TestGetReservationListFromSequentialFile
		("Case 3: Reservation file with Customer not found", 
				true, badResFile2);
		
		String badResFile3 = path + "";
		TestGetReservationListFromSequentialFile
		("Case 3: Reservation file does not exist", 
				false, badResFile3);		
	}
	
	
	public static void TestGetReservationListFromSequentialFile
	(String testCase,boolean expectedResult, String filename ){
		
		System.out.println("   " + testCase);
		System.out.println("    Filename: " + filename);

		
		
		String path = "datafiles"+File.separator;
		String goodRoomFile = path+"rooms.txt";
		Room[] roomList = null;
		try{
			roomList = HotelFileLoader.getRoomListFromSequentialFile(goodRoomFile);
		}catch(Exception e){
			System.out.println("Room File does not exist");
		}
		
		String goodCustFile = path+"customersLAPD.txt";
		Customer[] custList = null;
		try{
			custList = HotelFileLoader.getCustomerListFromSequentialFile(goodCustFile);
		}catch(Exception e){
			System.out.println("Cust File does not exist");
		}
		
		Reservation[] resList = null;
		try{
			resList = HotelFileLoader.getReservationListFromSequentialFile
					(filename, custList, roomList);
			System.out.println("    Here is the Reservation data file content:");
			for(Reservation r: resList){
				System.out.println("\t"+r);
			}
			if(!expectedResult){
				System.out.println("\nERROR! You expected this test case to"
						+ " fail but it didn't");
			}
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}catch(IOException d){
			System.out.println("File not found" + filename);
		}
		
		System.out.println();
		
	}
	

}
