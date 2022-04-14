package com.example.cinemabackend.api;

import com.example.cinemabackend.WithMockUser;
import com.example.cinemabackend.model.Staff;
import com.example.cinemabackend.service.StaffService;
import org.junit.jupiter.api.Test;
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
@WebMvcTest(value = StaffController.class)
@WithMockUser
class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffService service;

    Staff mockedStaff = new Staff(1, "Borje", "199901011234", "borje@mail.com", "some address", 1000, "Cleaner");

    @Test
    public void getStaffById() throws Exception {
        Mockito.when(service.getStaffById(Mockito.anyInt())).thenReturn(mockedStaff);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/staffs/" + mockedStaff.getStaffId()).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"staff_id\":1," +
                "\"name\":\"Borje\"," +
                "\"security_number\":\"199901011234\"," +
                "\"mail\":\"borje@mail.com\"," +
                "\"address\":\"some address\"," +
                "\"salary\":1000," +
                "\"position\":\"Cleaner\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}