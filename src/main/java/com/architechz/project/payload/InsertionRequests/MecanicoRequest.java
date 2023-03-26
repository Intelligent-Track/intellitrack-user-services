package com.architechz.project.payload.InsertionRequests;
import javax.validation.constraints.*;

public class MecanicoRequest {
    
    @NotBlank
    private String name;

    @NotBlank
	@Size(max = 50)
	@Email
	private String username;

  public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

}