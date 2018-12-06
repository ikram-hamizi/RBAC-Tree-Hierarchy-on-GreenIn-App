package ah.jocelyne.greenin.signup;

public class RegisteredUser {

    String firstName;
    String lastName;
    String email;
    String hashedPassword;
    String salt;
    String role;

    Role ROLE; //Try

    public RegisteredUser(String firstName, String lastName, String email, String hashedPassword, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.role = role;

        ROLE = new Role (role); //Try
    }

    public RegisteredUser(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
