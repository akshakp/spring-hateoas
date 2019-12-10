package com.akshak.springhateoas.Model;

/**
 * 
 * User
 */
public class User{

    private String firstName;
    private String lastName;
    private String email;
    private Long id;
    private boolean isActive;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Long getId() {
		return this.id;
	}


    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param id
     * @param isActive
     */
    public User(String firstName, String lastName, String email, long id, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.isActive = isActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "User [email=" + email + ", firstName=" + firstName + ", id=" + id + ", isActive=" + isActive
                + ", lastName=" + lastName + "]";
    }
    
}