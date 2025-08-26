package com.Customer_Service.dto;

// import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomersDTO{
    
    private int id;

    @NotBlank(message="Name Field Cannot Be Blank")
    private String customer_name;

    @NotBlank(message="Email Field Cannot be Blank")
    private String customer_email;
    
    @NotBlank(message="Password is mandatory")
    private String password;

    // @NotNull(message = "Age is required")
    // @Min(value = 1, message = "Age must be at least 1")
    private int age;

    private String phNumber;

    private String role = "Customer";

    public CustomersDTO(String customer_name, String customer_email, String password, int age, String phNumber){
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.password = password;
        this.age = age;
        this.phNumber = phNumber;
    }
    
    public CustomersDTO(String customer_name, String customer_email, String password, int age){
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.password = password;
        this.age = age;
    }

    public CustomersDTO(String customer_name, String customer_email, String password){
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.password = password;
    }
}