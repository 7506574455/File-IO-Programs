package com.addressbook;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.google.gson.Gson;

public class OpenCSVandGsonMain {
	
	public static final String CSVPath= "C:\\Users\\Sanket\\eclipse-workspace\\jsonannotation\\src\\main\\java\\com\\addressbook\\readData.csv";
	public static final String JSONPath="C:\\Users\\Sanket\\eclipse-workspace\\jsonannotation\\src\\main\\java\\com\\addressbook\\data.json";
	
	public static void main(String[] args) throws Exception {
		Reader reader=Files.newBufferedReader(Paths.get(CSVPath));
		CsvToBeanBuilder<AddressBook> csvToBeanBuilder=new CsvToBeanBuilder<AddressBook>(reader);
		csvToBeanBuilder.withType(AddressBook.class);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<AddressBook> csvToBean =csvToBeanBuilder.build();
		List<AddressBook> addressBookPojos=csvToBean.parse();
		Gson gson=new Gson();
		String json=gson.toJson(addressBookPojos);
		FileWriter Writer=new FileWriter(JSONPath);
		Writer.write(json);
		Writer.close();
		BufferedReader br=new BufferedReader(new FileReader(JSONPath));
		AddressBook[] userObj=gson.fromJson(br,AddressBook[].class);
		Arrays.asList(userObj);			

	}
}

