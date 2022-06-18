package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //--------------------------------
    @NotEmpty(message = "Username is required")
    private String username;
    //-------------------------------------
    @NotEmpty(message = "Password is required")
    private String password;
    //-----------------------------------
    @NotEmpty(message = "Role is required")
//    @Pattern(regexp = ("Techar|Suudent"))
    private String role;
    //-----------------------------
    @NotEmpty(message = "not null")
    private String phoneNum;
    //----------------------------
    @NotEmpty(message = "is  not required")
    private String levelClass;

    //-------------------------
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Subject> subject;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<CommentRate> commentRates;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}








