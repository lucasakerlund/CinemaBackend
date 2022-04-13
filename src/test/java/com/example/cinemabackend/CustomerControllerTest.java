package com.example.cinemabackend;

import com.example.cinemabackend.api.CustomersController;
import com.example.cinemabackend.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



    @RunWith(SpringRunner.class)
    @WebMvcTest(value = CustomersController.class)
    @WithMockUser
    public class CustomerControllerTest {

        @Autowired
        private MockMvc mockMvc;
        @MockBean
        private com.example.cinemabackend.service.CustomerService customerService;
        Customer mockCustomer = new Customer(1,"?","1111","?");

        String CustomerJson = "{\"customer_id\":\"name\",\"securityNumber\"mail\"}";

        @Test
        public void retrieveDetailsForCustomer() throws Exception {

            Mockito.when(customerService.retrieveCustomer(Mockito.anyString(),
                    Mockito.anyString())).thenReturn(mockCustomer);

            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/customers/1/securitynumber/1111").accept(
                    MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            System.out.println(result.getResponse());

            String expected = "{id:1,name:Spring,securitynumber:1111}";

            JSONAssert.assertEquals(expected, result.getResponse()
                    .getContentAsString(), false);


        }

    } 

