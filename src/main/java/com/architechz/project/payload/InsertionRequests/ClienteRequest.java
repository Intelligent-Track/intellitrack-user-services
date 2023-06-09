package com.architechz.project.payload.InsertionRequests;
import javax.validation.constraints.*;

public class ClienteRequest {

	@NotBlank
    private String name;

	@NotBlank
	@Size(max = 50)
	@Email
	private String username;

	private Long document;

	private Long phone;

	@NotBlank
	private String job;

	@NotBlank
	private String location;

	private String nit;

	private String companyName;
	
	private Boolean adm;

	@Size(max = 50)
	@Email
	@NotBlank
	private String managerUsername;

    public ClienteRequest() {
    }

    public ClienteRequest(@NotBlank String name, @NotBlank @Size(max = 50) @Email String username, Long document,
            Long phone, @NotBlank String job, @NotBlank String location, String nit, String companyName, Boolean adm,
            @Size(max = 50) @Email @NotBlank String managerUsername) {
        this.name = name;
        this.username = username;
        this.document = document;
        this.phone = phone;
        this.job = job;
        this.location = location;
        this.nit = nit;
        this.companyName = companyName;
        this.adm = adm;
        this.managerUsername = managerUsername;
    }

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

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

}