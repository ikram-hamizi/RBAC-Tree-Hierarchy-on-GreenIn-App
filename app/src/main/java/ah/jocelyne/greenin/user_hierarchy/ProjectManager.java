package ah.jocelyne.greenin.user_hierarchy;

import ah.jocelyne.greenin.signup.RegisteredUser;

public class ProjectManager extends RegisteredUser implements Role {

    public ProjectManager(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
        super(firstName, lastName, email, hashedPassword, salt, role);
    }

    public void addEvent() {    }
    public void deleteEvent() {    }


    public void invokeMyFunctions()
    {
        addEvent();
        deleteEvent();
    }

    public invokeMyChildrenFunctions() {
        //Explanation: List mychildren = TreeNodeObject.getChildren();
        getChildren().invokeMyFunctions();
    }
}
