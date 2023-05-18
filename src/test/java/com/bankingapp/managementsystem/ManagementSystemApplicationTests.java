package com.bankingapp.managementsystem;

import com.bankingapp.managementsystem.model.Customer;
import com.bankingapp.managementsystem.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ManagementSystemApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private CustomerRepository customerRepository;
	ObjectMapper om = new ObjectMapper();

	@Test
	void contextLoads() {
	}

	@Test
	public void testRegisterUser() throws Exception {
		//test new creation
		Customer customer= new Customer(1l,"test",
				"test@123", "pass", "Kerala",
				"India",
				"Kerala",
				"aleena@gmail.com",
				8786852l,
				"20-20-22",
				"Salary",
				"Kerala",
				500d,
				"PAN",
				"123",null
		);
		mockMvc.perform(post("/register")
						.contentType("application/json")
						.content(om.writeValueAsString(customer)))
				.andDo(print())
				.andExpect(status().isCreated());

		Customer actualResult = customerRepository.findByUserName(customer.getUserName()).get();
		Assert.assertEquals(customer.getUserName(),actualResult.getUserName());
		Assert.assertEquals(customer.getName(),actualResult.getName());


	}

	@Test
	public void testLoginUser() throws Exception {
		//test new creation
		String result = mockMvc.perform(get("/login").param("userName", "Aleena")
						.param("password","Aleena"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse().getContentAsString();
		System.out.println(result);
		Assert.assertEquals("Logged in successfully!!!",result);


	}

}
