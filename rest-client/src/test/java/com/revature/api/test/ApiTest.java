package com.revature.api.test;

import org.junit.Test;

import com.revature.beans.Trainee;
import com.revature.rest.client.TraineeApi;

public class ApiTest {
 @Test
 public void testInsert(){
	 TraineeApi trainee = new TraineeApi();
	 trainee.insert(new Trainee("SuperMan", "Super Hero"));
 }
}
