package ah.jocelyne.greenin.user_hierarchy;

public class Volunteer implements Role extends RegisteredUser {


        public Volunteer(String firstName, String lastName, String email, String hashedPassword, String salt, String role) {
            super(firstName, lastName, email, hashedPassword, salt, role);
        }

        public void editDIY() {}
        public void addDIY() {}
        public void deleteDIY() {}

        public void invokeMyFunctions()
        {
            editDIY();
            addDIY();
            deleteDIY();
        }

        public invokeMyChildrenFunctions() {
            //Explanation: List mychildren = TreeNodeObject.getChildren();
            getChildren().invokeMyFunctions();
        }

}
