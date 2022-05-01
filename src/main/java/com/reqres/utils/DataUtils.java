package com.reqres.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reqres.exception.InvalidCsvFilePathException;
import com.reqres.pojo.Users;

//import io.github.sskorol.core.DataSupplier;
//import io.github.sskorol.data.JsonReader;
//import io.github.sskorol.data.TestDataReader;
//import one.util.streamex.StreamEx;

public class DataUtils {

	
	@DataProvider(name = "test-provider", parallel = true)
	public Object[] getData() {
		List<Users> users = null;
		try {
			users = new ObjectMapper()
					.readValue(new File(System.getProperty("user.dir")+"/src/test/resources/users.json"), new TypeReference<List<Users>>() {});
		} catch (IOException e) {
			throw new InvalidCsvFilePathException("Invalid csv file path ", e);
		}
		return users.toArray();
	}
	
//	@DataSupplier(name = "test-supplier", runInParallel = true)
//	public StreamEx<Users> getData1() {
//		return TestDataReader
//				.use(JsonReader.class)
//				.withTarget(Users.class)
//				.withSource("users.json")
//				.read();
//	}
}
