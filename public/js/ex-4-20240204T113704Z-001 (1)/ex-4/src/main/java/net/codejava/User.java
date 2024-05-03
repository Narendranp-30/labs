package net.codejava;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class User {
	@NotBlank
    @Size(min=3,max=50)
    private String name;
    @NotBlank
    @Pattern(regexp = "^([a-zA-Z0-9_\\.-])+@(([a-zA-Z0-9-])+)\\.([a-zA-Z0-9]{2,4})+$",
             message = "Please enter a valid email address")
    private String email;
	@NotBlank
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
             message = "Password must contain at least one digit, one lowercase, one uppercase, and one special character")
    private String password;
    @NotBlank
    private String woodType;
    @NotBlank
    private String productType;
    @NotBlank
    private String amountRange;
    @NotBlank
    private String payment;
    @NotBlank
    private String comment;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must only contain 10 digits")
    private String mobile_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getAmountRange() {
        return amountRange;
    }

    public void setAmountRange(String amountRange) {
        this.amountRange = amountRange;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getComment() {
        return comment;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + ", password=" + password + ", woodType=" + woodType +", productType=" + productType +", amountRange=" + amountRange + ", payment=" + payment + ", comment=" + comment +

                 ", mobile_no=" + mobile_no+ "]";
    }
}
