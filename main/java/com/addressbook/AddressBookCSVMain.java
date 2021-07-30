package com.addressbook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

 /* * Add contact of AddressBook from AddressBook.java 
 * Read Data from readdata.csv and display in Console using method void read().
 * Write data from console to writedata.csv using method void write().
 */
             //class created
public class AddressBookCSVMain {

	/* Read data from data.csv */
	void readdata() throws Exception {

		String path = "C:\\Users\\Sanket\\eclipse-workspace\\jsonannotation\\src\\main\\java\\com\\addressbook\\readData.csv";

		Reader reader = Files.newBufferedReader(Paths.get(path));
		CsvToBean<AddressBook> csvToBean = new CsvToBeanBuilder<AddressBook>(reader)
				.withType(AddressBook.class).withIgnoreLeadingWhiteSpace(true).build();

		List<AddressBook> csvUsers = csvToBean.parse();
		for (AddressBook csvUser : csvUsers) {
			System.out.println(
					"************************************************************");
			System.out.println("fName :" + csvUser.getfName());
			System.out.println("lName :" + csvUser.getlName());
			System.out.println("addess :" + csvUser.getAddress());
			System.out.println("city :" + csvUser.getCity());
			System.out.println("state :" + csvUser.getState());
			System.out.println("Zip :" + csvUser.getZip());
			System.out.println("phoneNo :" + csvUser.getPhoneNo());
			System.out.println("email :" + csvUser.getEmail());
			System.out.println(
					"************************************************************");
		}

	}

	/* Write data from console to writedata.csv */
	void writeData() throws Exception {

		String path1 = "C:\\Users\\Sanket\\eclipse-workspace\\jsonannotation\\src\\main\\java\\com\\addressbook\\writeData.csv";
		Writer writer = Files.newBufferedWriter(Paths.get(path1));
		StatefulBeanToCsv<AddressBook> beanToCsv = new StatefulBeanToCsvBuilder<AddressBook>(writer)
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

		List<AddressBook> csvUsers = new ArrayList<AddressBook>();
		csvUsers.add(new AddressBook("sanket", "lalge", "aaa", "nagar", "maharastra", "414306", "1236547892",
				"abc@gmail.com"));
		beanToCsv.write(csvUsers);
		writer.close();
	} 

	// main method
	public static void main(String[] args) throws Exception {

		AddressBookCSVMain csv = new AddressBookCSVMain();
		csv.readdata();
		csv.writeData();
	}

}

