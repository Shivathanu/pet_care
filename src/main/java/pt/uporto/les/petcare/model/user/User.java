package pt.uporto.les.petcare.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pt.uporto.les.petcare.model.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "user_data")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User extends AbstractEntity implements UserDetails {

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String name;

	private String mobile;
	
	private String comment;

	@Column(nullable = false)
	private String password;

	@ManyToOne
	private Region region;

	//	private String region;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String image;

	public User() {
	}
	
	public User(User user, String role) {
	}

	public User(String email, String name, String mobile, String password) {
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
	}

	public User(String email, String name, String mobile, String password, Region region) {
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.region = region;
	}
	
	public User(String email, String name, String mobile, String password, String region, String image, String comment) {
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.image = image;
		this.comment = comment;
	}

	public User(User user) {
		this.email = user.email;
		this.name = user.name;
		this.mobile = user.mobile;
		this.password = user.password;
		this.region = user.region;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}

//	public String getRegion() {
//		return region;
//	}

//	public void setRegion(String region) {
//		this.region = region;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		if (!super.equals(o)) return false;
		User user = (User) o;
		return getEmail().equals(user.getEmail()) &&
				getName().equals(user.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getEmail(), getName());
	}

	@Override
	public String toString() {
		return "User{" + "email='" + email + '\'' + ", name='" + name + '\'' + ", mobile='" + mobile + '\''
				+ ", password='" + password + '\'' + ", comment='" + comment + '\'' 
				+ ", region=" + region + '}';
	}
}
