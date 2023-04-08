package com.architechz.project.payload.RegisterRequests;
import javax.validation.constraints.*;

public class ConductorRequest {
    
    @NotBlank
    private String name;

	@NotBlank
	@Size(max = 50)
	@Email
	private String username;

    @NotBlank
	@Size(max = 120,min = 10)
	private String password;

   
	private Long document;

	
	private Long phone;

	
	private String job;

	@NotBlank
	private String location;

	
	private Boolean directo;

	@Size(max = 50)
	@Email
	@NotBlank
	private String managerUsername;

	private String placaVehiculo;

	@NotBlank
	private String licencia;

	
	private String revisionAutoMec;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public Long getPhone() {
        return phone;
    }


    public void setPhone(Long phone) {
        this.phone = phone;
    }


    public String getJob() {
        return job;
    }


    public void setJob(String job) {
        this.job = job;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public Boolean getDirecto() {
        return directo;
    }


    public void setDirecto(Boolean directo) {
        this.directo = directo;
    }


    public String getManagerUsername() {
        return managerUsername;
    }


    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }


    public String getPlacaVehiculo() {
        return placaVehiculo;
    }


    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }


    public String getLicencia() {
        return licencia;
    }


    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }


    public String getRevisionAutoMec() {
        return revisionAutoMec;
    }


    public void setRevisionAutoMec(String revisionAutoMec) {
        this.revisionAutoMec = revisionAutoMec;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Long getDocument() {
        return document;
    }


    public void setDocument(Long document) {
        this.document = document;
    }

    

}