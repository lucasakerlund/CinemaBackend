package com.example.cinemabackend;

import com.example.cinemabackend.Service.CustomerService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackendApplication.class, args);


        //SpringBootApplication.run(CinemaBackendApplication.class, args);
       // CustomerService customerService = context.getBean(CustomerService.class);
        //StaffService staffService = context.getBean(StaffService.class);
        //MoviesService moviesservice = context.getBean(MoviesService.class);
        //ScheduleService ScheduleService = context.getBean(ScheduleService.class);
        //StaffScheduleService staffScheduleService = context.getBean(StaffScheduleService.class);

        //System.out.println(customerService.getCustomerById("1").toString());
        //System.out.println(staffService.getStaffById("1").toString());
        //System.out.println(moviesService.getMoviesById("1").toString());
        //System.out.println(scheduleService.getScheduleById("1).toString());
        //System.out.println(staffScheduleService.getStaffScheduleById("1").toString());


    }
}
