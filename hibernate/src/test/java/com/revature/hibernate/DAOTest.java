package com.revature.hibernate;

import org.junit.Test;

public class DAOTest {
	@Test
	public void test() {
		TraineeDAO dao = new TraineeDAO();
		Trainee trainee = new Trainee(1, "Bryan Cantos", "CS");
		dao.insert(trainee);
	}
}
