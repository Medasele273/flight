package se.lexicon.flight.domain;

import java.util.Objects;

public class Users {

    private String userName;

    private String password;

    private String role;

    private Users(){

    }

    private Users(Builder builder){
        this.userName= Objects.requireNonNull(builder.userName,"userName should not be null");
        this.password= Objects.requireNonNull(builder.password,"password should not be null");
        this.role= Objects.requireNonNull(builder.role,"role should not be null");
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}' +'\n';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Users> {

         private String userName;
         private String password;
         private String role;

         public Users.Builder withUserName(String userName){
             this.userName=userName;
             return this;
         }

         public Users.Builder withPassword(String password){
             this.password=password;
             return this;
         }

         public Users.Builder withRole(String role){
             this.role=role;
             return this;
         }

        @Override
        public Users build() {
            return new Users(this);
        }
    }
}
